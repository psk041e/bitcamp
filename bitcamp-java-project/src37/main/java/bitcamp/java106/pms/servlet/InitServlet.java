// 서블릿들이 사용할 자원을 미리 준비시키는 역할을 수행한다.
package bitcamp.java106.pms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.pms.AppConfig;

// 하는 일:
// => Spring IoC 컨테이너(bean container)를 준비한다.
// 
@WebServlet(
        urlPatterns="/initServlet", // value 는 urlPatterns 와 같다.
        loadOnStartup=1) // 보통 끝의 괄호는 이렇게 한다. 
@SuppressWarnings("serial") // serial에 대한 경고를 모두 무시한다.
public class InitServlet extends HttpServlet { 
    
    static ApplicationContext iocContainer; 
    // 여기 들어있는 DAO를 다른 서블릿들이 사용한다. -> 주소를 알아야 한다.
    // 서블릿의 객체 주소를 알 수는 없다.
    public static ApplicationContext getApplicationContext() {
        return iocContainer;
    } // 다른 서블릿에서 
    
    @Override
    public void init() throws ServletException {
        iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    // 다른 서블릿이 사용할 자원을 준비하는 일만 하기 때문에
    // 굳이 클라이언트의 요청을 처리할 service() 메서드를 구현할 필요가 없다.

}









