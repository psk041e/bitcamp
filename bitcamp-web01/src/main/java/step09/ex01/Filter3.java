// 웹 애플리케이션 컴포넌트 : 필터
package step09.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//애노테이션 대신에 web.xml에 배치 정보를 설정한다.
//@WebFilter("/step09/ex1/exam03")
public class Filter3 implements Filter{
    FilterConfig config;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 최초로 필터 객체가 생성될 때 호출된다.
        // 필터가 작업할 때 사용할 도구를 준비시키는 코드를 여기에 둔다.
        this.config = filterConfig;
        System.out.println("Filter2.init()");
    }
    
    @Override
    public void destroy() {
        // 웹 애플리케이션을 멈추거나 서블릿 컨테이너를 멈출 때 호출된다.
        // 필터가 init()를 통해 준비했던 도구나 자원을 해제시키는 코드를 여기에 둔다.
        System.out.println("Filter2.destroy()");
    }
    
    @Override
    public void doFilter(
            ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // FilterConfig 도구를 사용하여 web.xml에 설정된 파라미터 값을 가져올 수 있다.
        String v1 = config.getInitParameter("v1");
        String v2 = config.getInitParameter("v2");
        System.out.printf("v1=%s, v2=%s\n", v1, v2);
        
        chain.doFilter(request, response);
    
    }
    
    
}
