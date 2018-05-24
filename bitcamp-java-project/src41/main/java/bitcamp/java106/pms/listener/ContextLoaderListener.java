package bitcamp.java106.pms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.pms.support.WebApplicationContextUtils;

// 서블릿 컨테이너가 시작될 때 스프링 IoC 컨테이너를 준비한다.
// => 기존의 InitServlet 역할을 대체한다.
//
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    // 웹 어플리케이션의 환경을 로딩시켜주는 리스너,
    // 실제 존재하는 리스너이다.
    
    static ApplicationContext container;
    
    public static ApplicationContext getApplicationContext() {
        return container;
    }
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        String configClassName = sc.getInitParameter("contextConfigLocation");
        // 문자열로 클래스 이름을 받아서 그것을 가지고 클래스 타입 정보를 얻는다.
        // => 정확하게 어떤 클래스인지 지정하지 않는다. 하드코딩하지 않도록한다.
        
        // sce-서블릿 컨텍스트를 리턴해주는 메서드가 존재하기 때문에 이를 사용한다.
        // 서블릿 컨테이너가 시작되면 스프링 IoC 컨테이너를 준비한다.
        //
        try {
            ApplicationContext iocContainer = 
                    new AnnotationConfigApplicationContext(
                            Class.forName(configClassName));
            
            container = iocContainer;
            
            // 서블릿에서 스프링 IoC 컨테이너를 꺼내 쓸 수 있도록,
            // WebApplicationContextUtils에 보관한다.
            WebApplicationContextUtils.containers.put(
                    sce.getServletContext(), iocContainer);
            
            // 왜, 이렇게 복잡하게 하는가?
            // => 스프링을 흉내내고, 모방하기위함이다.
            // => 그냥 이렇게 이해하라!
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
