// 서블릿 실행 
package step09.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step09/ex01/exam01")
public class Exam01 extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("  <meta charset='UTF-8'>");
        out.println("  <title>exam01</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>exam01 실행!</h1>");
        out.println("</body>");
        out.println("</html>");
        
        // 콘솔창에 서블릿이 실행되었음을 표시하기 위해
        // => 필터의 실행과 서블릿의 실행 순서를 확인하기 위함이다.
        System.out.println("/step09/ex01/exam01 실행!");

        // http://localhost:8888/bitcamp-web01/step08/ex03/exam01?name=%ED%99%8D%EA%B8%B8%EB%8F%99
    }
}
