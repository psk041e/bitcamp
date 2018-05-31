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
        
        
        // 페이지 컨트롤러 실행
        try {
            // 클라이언트 요청을 처리할 페이지 컨트롤러를 얻기
            Object pageController = iocContainer.getBean(objName);
            
            // 클라이언트 요청을 처리하는 메서드(request handler) 정보를 알아낸다.
            Method requestHandler = findRequestHandler(pageController, handlerPath);

            if (requestHandler == null)
                throw new ServletException("요청을 처리할 요청 핸들러가 없습니다.");
            
            // 요청 핸들러가 리턴해 줄 값을 담을 바구니 준비(->작업결과)
            HashMap<String,Object> resultMap = new HashMap<>();
            
            // 요청 핸들러의 파라미터 값을 준비한다.
            Object[] paramValues = prepareParamValues(
                    requestHandler, request, response, resultMap);
            
            
            // 준비한 파라미터 값을 가지고 요청 핸들러를 호출한다.
            String viewUrl = (String)requestHandler.invoke(
                                    pageController, paramValues);
            // 전에는 이부분에 콕 집어서 메서드를 리턴할 때 response,request를 줬었다.
            // 그러나 이제는 그렇게 하지 않겠다.
            // 메서드를 호출할 때 얘가 준비한 파라미터 값을 넘기겠다.
            
            // 요청 핸들러를 실행한 후,
            // 요청 핸들러가 저장한 작업 결과가 담겨 있는 resultMap의 값들을 ServletReqeust로 옮긴다.
            // 왜? JSP가 꺼내 쓸 수 있도록 하기 위함.
            Set<String> keySet = resultMap.keySet();
            for (String key : keySet) {
                request.setAttribute(key, resultMap.get(key)); // 옮긴 값을 request에 넣는다.
            }

            // jsp로 include
            if (viewUrl.startsWith("redirect:")) {
                response.sendRedirect(viewUrl.substring(9));
            } else {
                request.getRequestDispatcher(viewUrl).include(request, response);
            }
        } catch (Exception e) {
            throw new ServletException("페이지 컨트롤러 실행 중 오류 발생!");
        }
    }

    private Object[] prepareParamValues(
            Method requestHandler, 
            HttpServletRequest request,
            HttpServletResponse response, 
            HashMap<String, Object> resultMap) {
        
        // 파라미터 값을 저장할 바구니 준비(어떤 값이 될지 모르므로 Object로 준비)
        ArrayList<Object> paramValues = new ArrayList<>();
                
        // 메서드의 파라미터 정보 알아내기
        Parameter[] params = requestHandler.getParameters();
        
//        for (Parameter p : params) {
//            System.out.println(p.getType()); // 파라미터의 타입은 클래스이다. 
//        }
        
        // 반복문을 돌면서 파라미터의 타입을 알아내서 메서드를 호출할 때 넘겨줄, 
        // 메서드가 원하는 값을 바구니에 담는다.
        for (Parameter p : params) {
            if (p.getType() == Map.class) { // 메서드가 파라미터 값으로 Map을 요구한다면,
                paramValues.add(resultMap);
            } else if (p.getType() == HttpServletRequest.class) { // 메서드가 파라미터 값으로 HttpServletRequest을 요구한다면,
                paramValues.add(request);
            } else if (p.getType() == HttpServletResponse.class) { // 메서드가 파라미터 값으로 HttpServletResponse을 요구한다면,
                paramValues.add(response);
            } else if (p.getType() == HttpSession.class) {
                paramValues.add(request.getSession());
            } else if (isPrimitiveType(p.getType())) {
                /*
                // 1) 파라미터에 붙은 @RequestParam의 값을 알아낸다.
                String paramName = getRequestParamValue(p);
                
                // 2) 그 값을 가지고 요청 파라미터 값을 꺼낸다.
                String value = request.getParameter(paramName);
                
                // 3) 요청 파라미터 값을 paramValues에 저장한다.
                paramValues.add(value);
                */
                // 메서드의 타입이 primitive타입이라면
                // primitive타입이면 파라미터 값을 바로 뽑아낼 수 있다.
                // 즉시 파라미터 정보를 추출해서 클라이언트가 보낸 데이터를 찾아서 
                // 파라미터 정보를 줘서 request타입으로 저장한다.
                paramValues.add(getRequestParamValue(p, request));
            } else {
                paramValues.add(getValueObject(p, request)); // 값객체를 얻겠다.
            }
            
      }
        return paramValues.toArray(); // 그냥 리턴하면 안된다, 배열로 바꿔서 리턴한다.
        // 그러면 준비된 파라미터 값을 가지고 해당 메서드를 호출한다.
    }
    
    private Object getValueObject(Parameter p, HttpServletRequest request) {
        // 파라미터의 타입을 가져온다.
        Class<?> clazz = p.getType();
        
        try {
            // 기본생성자를 알아낸다.
            Constructor<?> defaultConstructor = clazz.getConstructor(); // 기본생성자를 리턴할때는 파라미터값을 넣어주지 않는다.
            // 기본생성자를 가지고 객체를 생성한다.
            Object valueObject = defaultConstructor.newInstance(); // 파라미터값은 없으므로 안준다.
            
            Method[] methods = clazz.getMethods();
            
            for (Method m : methods) {
                if (!m.getName().startsWith("set")) continue; // set으로 시작하지 않는다면 다음 메서드를 가져와라. 셋터메서드만 필요하다.
                // 메서드 이름으로 프로퍼티 이름을 찾고 그 프로퍼티 이름으로 값을 출력해보자
                String propName = getPropertyName(m.getName());
                String propValue = request.getParameter(propName);
//                System.out.printf("===> %s = %s\n", propName, propValue);

                // 클라이언트가 그 프로퍼티 이름으로 보낸 값이 없으면 건너뛴다. 
                if (propValue == null) continue;
                
                // 셋터에서 요구하는 파라미터 값의 타입이 String이나 Primitive 타입이 아니면 건너뛴다.
                // 값을 넣지 않는다.
                // 메서드에서 파라미터 타입 목록을 뽑아내
                // 혹시 메서드의 파라미터 타입이 여러개 있을수 있기 때문에[0]을 붙여준다. 
                // 셋터이기 때문에 한개정보만 필요하다.
                Class<?> setterParamType = m.getParameterTypes()[0];
                if (!isPrimitiveType(setterParamType)) continue; 
                // => 셋터의 파라미터 타입
                // primitive타입이 아니면 호출할수 없다.
                
                // 셋터 메서드를 호출하여 클라이언트가 보낸 값을 저장한다.
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



