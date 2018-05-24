// 모든 페이지에 삽입될 공통 헤더를 출력하는 서블릿
package bitcamp.java106.pms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bitcamp.java106.pms.domain.Member;

@SuppressWarnings("serial")
@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
    @Override
    protected void service(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        // 이 서블릿을 include하는 쪽에서 출력스트림의 콘텐트 타입을 설정하기 때문에 
        // 이 서블릿에서는 콘텐트 타입을 설정할 필요가 없다.
        //response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        Member loginUser = (Member) session.getAttribute("loginUser");
        
        out.println("<div id='header'>");
        if (loginUser != null) {
            out.printf("    %s", loginUser.getId());
            out.printf(" <a href='%s/auth/logout'>로그아웃</a>",
                    request.getContextPath());
            // 이 div가 어디에 삽입될지 모른다.
            // /board/list페이지에 삽입된다면, ../auth를 의미하기 때문에 이때는 정상적으로 동작한다.
            // 그런데 만약에 /board/aaa/ccc에 삽입된다면, 그때 ..이 의미하는것은 board가 된다.
            // 그래서 이런 상대주소는 위험하다.
            // 서블릿의 경로에 따라 다른 의미를 가지기 때문이다.
            // => 절대 경로를 써라!
            
        } else {
            out.printf(" <a href='../auth/login'>로그인</a>",
                    request.getContextPath());
        }
        out.println("</div>");
        
        response.setContentType("text/html;charset=UTF-8");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        String refererUrl = request.getHeader("Referer");
        if (refererUrl != null) {
            out.printf("<meta http-equiv='Refresh' content='5;url=%s'>", refererUrl); 
        }
        out.println("<title>실행 오류</title>");
        out.println("</head>");
        out.println("<body>");
        out.printf("<h1>%s</h1>\n", request.getAttribute("title"));
        out.println("<pre>");
        Exception e = (Exception) request.getAttribute("error");
        e.printStackTrace(out);
        out.println("</pre>");
        out.println("</body>");
        out.println("</html>");
    }
}



















