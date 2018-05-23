package bitcamp.java106.pms.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.pms.AppConfig;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

// 서블릿 컨테이너가 시작될 때 스프링 IoC 컨테이너를 준비한다.
// => 기존의 InitServlet 역할을 대체한다.
//
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // sce-서블릿 컨텍스트를 리턴해주는 메서드가 존재하기 때문에 이를 사용한다.
        // 서블릿 컨테이너가 시작되면 스프링 IoC 컨테이너를 준비한다.
        ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(AppConfig.class);
        
        // 서블릿에서 스프링 IoC 컨테이너를 꺼내 쓸 수 있도록,
        // WebApplicationContextUtils에 보관한다.
        WebApplicationContextUtils.containers.put(
                sce.getServletContext(), iocContainer);
        
        // 왜, 이렇게 복잡하게 하는가?
        // => 스프링을 흉내내고, 모방하기위함이다.
        // => 그냥 이렇게 이해하라!
    }
}
