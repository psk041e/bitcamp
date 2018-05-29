package step09.ex03;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/step09/ex03/*")
public class Filter1 implements Filter {
    // context메뉴에서 아이콘 위에 D가 있다면 default이다. 구현하지 않아도 된다.
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        ServletContext sc = request.getServletContext();
        System.out.printf("step09.ex03.Filter1 ==> %s, %s\n",
                sc.getInitParameter("p1"), sc.getInitParameter("p2"));
        
        // 다음 필터나 서블릿을 실행한다. 반드시 써줘야 한다.
        chain.doFilter(request, response);
        
    }
    
}






