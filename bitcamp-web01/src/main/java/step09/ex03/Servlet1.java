package step09.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step09/ex03/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        // 서블릿 컨텍스트를 얻는다.
        // 서블릿 컨텍스트를 얻을 수 있으면 언제든지 이니셜파라미터 값을 얻을 수 있다.
        ServletContext sc = this.getServletContext();
        // 컨텍스트 파라미터(스프링에서 사용하기 때문에 배운다.) 
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("p1=%s\n", sc.getInitParameter("p1"));
        out.printf("p2=%s\n", sc.getInitParameter("p2"));
        
    }
}













