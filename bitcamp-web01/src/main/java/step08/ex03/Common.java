// 다른 서블릿의 작업을 포함하기 - include
package step08.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step08/ex03/common")
public class Common extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        
        // style태그 안에 css명령을 집어넣어야 한다.
        out.println("<style>");
        out.println("div#header {"); // header라는 id를 갖는 div
        out.println("    background-color: blue;");
        out.println("    color: white;");
        out.println("    font-weight: bold;");
        out.println("}");
        
        out.println("div#footer {");
        out.println("    background-color: yellow;");
        out.println("}");
        out.println("</style>");
        
    }
}
