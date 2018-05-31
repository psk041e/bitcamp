// 프론트 컨트롤러 구현 
package bitcamp.java106.pms.servlet;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.pms.support.WebApplicationContextUtils;
import bitcamp.java106.pms.web.RequestMapping;
import bitcamp.java106.pms.web.RequestParam;

@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {
    
    ApplicationContext iocContainer;
    
    @Override
    public void init() throws ServletException {
        // 이 서블릿을 생성할 때 이 서블릿이 사용할 Spring IoC 컨테이너를 준비한다.
        try {
            iocContainer = new ClassPathXmlApplicationContext(
                this.getServletConfig().getInitParameter("contextConfigLocation"));
            
            // 다른 서블릿에서 스프링 IoC 컨테이너를 꺼내 쓸 수 있도록,
            // WebApplicationContextUtils에 보관한다.
            WebApplicationContextUtils.containers.put(
                    this.getServletContext(), iocContainer);
            
            String[] beanNames = iocContainer.getBeanDefinitionNames();
            System.out.println("-----------------------------");
            for (String name : beanNames) {
                System.out.println(name);
            }
            System.out.println("-----------------------------");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void service(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        // Front Controller
        // => 클라이언트의 모든 요청을 받아서 특정 컨트롤러에게 위임하기 전에 
        //    필요한 공통 기능 처리한다.
        // => 클라이언트의 진입점이 한 군데라서 유지보수가 용이하다.
        
        response.setContentType("text/html;charset=UTF-8");

        // 클라이언트가 요청한 서블릿의 경로를 알아내기
        String servletPath = request.getServletPath().replace(".do", "");
        
        // servletPath에서 객체명 추출하기
        // => 즉 맨 끝 / 이후의 문자열을 제외한 이름
        // => 예) /board/add ===> /board 만 추출하자
        //          => 앞부분으로 객체를 찾고, 뒷부분으로 메서드를 찾겠다.
        int index = servletPath.lastIndexOf('/');
        String objName = servletPath.substring(0, index); // index 바로 전까지 뽑아야 하므로 -> '/' 전까지
        String handlerPath = servletPath.substring(index); // index부터 끝까지, /add를 뽑아낸다.
        
        
        try {
            Object pageController = iocContainer.getBean(objName);
            
            Method requestHandler = findRequestHandler(pageController, handlerPath);

            if (requestHandler == null)
                throw new ServletException("요청을 처리할 요청 핸들러가 없습니다.");
            
            HashMap<String,Object> resultMap = new HashMap<>();
            
            Object[] paramValues = prepareParamValues(
                    requestHandler, request, response, resultMap);
            
            
            String viewUrl = (String)requestHandler.invoke(
                                    pageController, paramValues);
            Set<String> keySet = resultMap.keySet();
            for (String key : keySet) {
                request.setAttribute(key, resultMap.get(key)); // 옮긴 값을 request에 넣는다.
            }

            if (viewUrl.startsWith("redirect:")) {
                response.sendRedirect(viewUrl.substring(9));
            } else {
                request.getRequestDispatcher(viewUrl).include(request, response);
            }
        } catch (Exception e) {
            throw new ServletException("페이지 컨트롤러 실행 중 오류 발생!", e);
        }
    }

    private Object[] prepareParamValues(
            Method requestHandler, 
            HttpServletRequest request,
            HttpServletResponse response, 
            HashMap<String, Object> resultMap) {
        
        ArrayList<Object> paramValues = new ArrayList<>();
                
        Parameter[] params = requestHandler.getParameters();
        
        for (Parameter p : params) {
            if (p.getType() == Map.class) {
                paramValues.add(resultMap);
            } else if (p.getType() == HttpServletRequest.class) {
                paramValues.add(request);
            } else if (p.getType() == HttpServletResponse.class) {
                paramValues.add(response);
            } else if (p.getType() == HttpSession.class) {
                paramValues.add(request.getSession());
            } else if (isPrimitiveType(p.getType())) {
                paramValues.add(getRequestParamValue(p, request));
            } else {
                paramValues.add(getValueObject(p, request));
            }
            
      }
        return paramValues.toArray();
    }
    
    private Object getValueObject(Parameter p, HttpServletRequest request) {
        Class<?> clazz = p.getType();
        
        try {
            Constructor<?> defaultConstructor = clazz.getConstructor();
            Object valueObject = defaultConstructor.newInstance();
            
            Method[] methods = clazz.getMethods();
            
            for (Method m : methods) {
                if (!m.getName().startsWith("set")) continue;
                String propName = getPropertyName(m.getName());
                String propValue = request.getParameter(propName);
                if (propValue == null) continue;
                Class<?> setterParamType = m.getParameterTypes()[0];
                if (!isPrimitiveType(setterParamType)) continue; 
                m.invoke(valueObject, toPrimitiveValue(propValue, setterParamType));
            }
            
            return valueObject; // 객체 리턴
            
        } catch (Exception e) {
            throw new RuntimeException(e);  // 예외가 발생하면 스텔스 예외를 던진다.
        }
    }
    
    private String getPropertyName(String methodName) {
        // setFirstName ==> FirstName
        StringBuffer buf = new StringBuffer(methodName.substring(3)); // set뒤부터 뽑는다.
        
        // 첫번째 알파벳을 소문자로 변경
        // 버퍼에 담긴 첫 글자를 소문자로 바꾼후 다시 버퍼에 담는다.
        buf.setCharAt(0, Character.toLowerCase(buf.charAt(0)));
        
        return buf.toString();
    }

    private Object getRequestParamValue(Parameter p, HttpServletRequest request) {
        // 파라미터 정보로부터 @RequestParam 애노테이션 정보를 추출한다.
        // 애노테이션이 여러개 들어갈수 있으니까 파라미터 정보중에서 RequestParam이라는 정보를 꺼낸다.
        RequestParam anno = p.getAnnotation(RequestParam.class);
        
        // 애노테이션 정보로부터 파라미터 이름을 꺼낸다. -> ex) /board/delete의 경우: no
        // 애노테이션에 우리가 value() 속성을 지었기 때문에 당연히 꺼낼때도 value()라는 이름으로 꺼내야 한다.
        String paramName = anno.value();
        
        // 파라미터 이름을 사용하여 클라이언트가 보낸 데이터의 값을 꺼낸다. -> ex) /board/delete -> no라는 이름으로 파라미터 값을 가져온다.
        String value = request.getParameter(paramName); 
        // request.getParameter()는 항상 String이다. 
        // -> int no = Integer.parseInt(request.getParameter("no"));
        // -> 이 반복적인 것을 안하겠다, DispatcherServlet으로부터 자동으로 처리해서 받겠다.
        // -> 도대체 이 변수의 타입이 뭔지 알아야 한다.
        // => DispatcherServlet에게 최솬의 정보를 알려줘야 한다. 그래서 파라미터 이름을 만든 것이다.
        
        if (value == null) return null; 
        
        // 클라이언트가 보낸 값은 문자열인데 그 문자열을 파라미터 
        return toPrimitiveValue(value, p.getType());
        
    }
    
    // 클라이언트로부터 받은 값을 메서드의 파라미터 타입으로 변환시킨다.
    // 원하는 타입에 맞춰서 바꿔주겠다.
    // 어차피 매번 리턴하기 때문에 if else 쓰지 않겠다.
    //
    // 타입을 주면 해당되는 형식으로 바꾼다.
    // 자동으로 // auto-boxinggksek.
    private Object toPrimitiveValue(String value, Class<?> type) {
        if (type == byte.class) return Byte.parseByte(value); 
        if (type == short.class) return Short.parseShort(value);
        if (type == int.class) return Integer.parseInt(value);
        if (type == long.class) return Long.parseLong(value);
        if (type == float.class) return Float.parseFloat(value);
        if (type == double.class) return Double.parseDouble(value);
        if (type == char.class) return value.charAt(0); // 문자가 여러개면 그중에 한개만 꺼내서 리턴
        if (type == boolean.class) return Boolean.parseBoolean(value);
        if (type == Date.class) return Date.valueOf(value);
        
        return value;
    }
    
    // 파라미터 타입이 기본타입이냐 아니냐에 따라서 boolean값 리턴 
    private boolean isPrimitiveType(Class<?> type) {
        if (type == byte.class || 
            type == short.class ||
            type == int.class ||
            type == long.class ||
            type == float.class ||
            type == double.class ||
            type == char.class ||
            type == boolean.class ||
            type == String.class ||
            type == Date.class) // java.sql.Date
            return true;
        return false;
    }

    private Method findRequestHandler(Object pageController, String handlerPath) throws Exception {
        Class<?> clazz = pageController.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            RequestMapping anno = m.getAnnotation(RequestMapping.class);
            if (anno != null && anno.value().equals(handlerPath))
                return m;
        }
        return null;
    }
}

//ver 46 - POJO 페이지 컨트롤러를 사용하여 클라이언트 요청 처리
//         이 프론트 컨트롤러가 사용할 페이지 컨트롤러는 
//         이 클래스에서 Spring IoC 컨테이너를 사용하여 관리할 것이다.
//         ContextLoaderListener의 스프링 IoC 컨테이너 생성 업무를 이 클래스로 이관한다. 
//ver 45 - 클래스 추가



