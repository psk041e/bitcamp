// 다른 서블릿의 작업을 포함하기 - include
package step08.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step08/ex03/exam01")
public class Exam01 extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("  <meta charset='UTF-8'>");
        out.println("  <title>include</title>");
        
        RequestDispatcher 요청배달자 = request.getRequestDispatcher("/step08/ex03/common");
        요청배달자.include(request, response);
        
        out.println("</head>");
        out.println("<body>");
        
        요청배달자 = request.getRequestDispatcher("/step08/ex03/header");
        요청배달자.include(request, response);
        
        out.printf("<h1>%s님 반갑습니다.</h1>\n", name);
        
        요청배달자 = request.getRequestDispatcher("/step08/ex03/footer");
        요청배달자.include(request, response);
        
        out.println("</body>");
        out.println("</html>");
        
        // http://localhost:8888/bitcamp-web01/step08/ex03/exam01?name=%ED%99%8D%EA%B8%B8%EB%8F%99
    }
}
