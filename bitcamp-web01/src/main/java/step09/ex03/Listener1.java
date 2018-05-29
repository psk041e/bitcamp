package step09.ex03;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener1 implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 객체를 얻을 수 있으면 그 객체에서 언제든지 꺼낼 수 있다.
        // <context-param> 태그의 값을 꺼내려면 ServletContext 객체가 있어야 한다.
        ServletContext sc = sce.getServletContext();
        System.out.printf("step09.ex03.Listener1 => %s, %s\n",
                sc.getInitParameter("p1"), sc.getInitParameter("p2"));
    }
}
