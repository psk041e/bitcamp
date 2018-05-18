// 오류 처리 작업을 수행하는 서블릿 - forward 적용
package bitcamp.java106.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/error")
public class ErrorServlet extends HttpServlet {

    @Override
    protected void service(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        String refererUrl = request.getHeader("Referer"); // 이 서블릿을 실행하기 전에 실행한 서블릿을 알려준다.
        if (refererUrl != null) { // Referer에 값이 있을 때만 Refresh해라
            // 무조건 referer라는 헤더가 있는 것이 아니다.
            // 사용자가 직접 주소창에 요청하면 referer헤더가 존재하지 않는다.
            // 어떤 창에서 요청했을 때에 referer헤드가 존재한다.
            out.printf("<meta http-equiv='Refresh' content='5;url=%s'>\n", refererUrl);
        }
        out.println("<title>실행 오류</title>");
        out.println("</head>");
        out.println("<body>");
        out.printf("<h1>%s</h1>\n", request.getAttribute("title")); // 위임하는 쪽에서 알려줘야 한다. 어디서 에러가 났는지.
        out.println("<pre>"); 
        Exception e = (Exception) request.getAttribute("error");
        e.printStackTrace(out); 
        out.println("</pre>"); 
        out.println("</body>");
        out.println("</html>");
    }
    
}
