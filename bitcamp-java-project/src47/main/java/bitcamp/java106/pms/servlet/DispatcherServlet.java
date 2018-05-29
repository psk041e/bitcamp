// 프론트 컨트롤러 구현 
package bitcamp.java106.pms.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.pms.support.WebApplicationContextUtils;
import bitcamp.java106.pms.web.RequestMapping;

@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {
    
    ApplicationContext iocContainer;
    
    @Override
    public void init() throws ServletException {
        // 서블릿 객체가 생성될 때 이 메서드가 호출된다.
        // 서블릿 객체는 최초의 요청이 들어올 때 생성된다.
        //
        // 이 서블릿을 생성할 때 이 서블릿이 사용할 Spring IoC 컨테이너를 준비한다.
        try {
            iocContainer = new ClassPathXmlApplicationContext(
                            this.getServletConfig().getInitParameter("contextConfigLocation"));
            
            // 다른 서블릿에서 스프링 IoC 컨테이너를 꺼내 쓸 수 있도록,
            // WebApplicationContextUtils에 보관한다.
            // 당장 쓰지는 않겠지만 그냥 두겠다. 스프링을 모방하기 위해서
            WebApplicationContextUtils.containers.put(
                   this.getServletContext(), iocContainer);
            
            String[] beanNames = iocContainer.getBeanDefinitionNames();
            System.out.println("----------------------");
            for (String name : beanNames) {
                System.out.println(name);
            }
            System.out.println("----------------------");
            
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
        
        // 페이지 컨트롤러 실행
        try {
            // 클라이언트 요청을 처리할 페이지 컨트롤러를 얻기
            Object pageController = iocContainer.getBean(servletPath);
            // iocContainer에서 bean을 찾는다. 만약 못찾으면 에러를 띄울 것이다.
            
            // 클라이언트 요청을 처리하는 메서드(request handler)를 추출한다, 알아낸다.
            Method requestHandler = findRequestHandler(pageController);
            
            if (requestHandler == null) 
                throw new ServletException("요청을 처리할 요청 핸들러가 없습니다.");
            
            String viewUrl = (String)requestHandler.invoke(
                                    pageController, request, response);
            if (viewUrl.startsWith("redirect:")) {
                response.sendRedirect(viewUrl.substring(9));
            } else {
                request.getRequestDispatcher(viewUrl).include(request, response);
            }
        } catch (Exception e) {
            throw new ServletException("페이지 컨트롤러 실행 중 오류 발생!");
        }
    }
    

    private Method findRequestHandler(Object pageController) throws Exception {
        Class<?> clazz = pageController.getClass();
        Method[] methods = clazz.getDeclaredMethods(); // 현재 클래스에 선언된것만
        for (Method m : methods) {
            RequestMapping anno = m.getAnnotation(RequestMapping.class);
            if (anno != null) 
                return m; // 애노테이션이 있으면 메서드를 바로 리턴
        }
        return null;
    }
}

//ver 45 - 클래스 추가



