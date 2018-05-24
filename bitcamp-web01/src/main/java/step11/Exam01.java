package step11;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/step11/exam01")
public class Exam01 extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        // servletcontext를 알아낼수 있다.
        ServletContext sc = this.getServletContext();
        HttpSession session = request.getSession();
        
        sc.setAttribute("v1", "aaa"); // 웹 어플리케이션당 한개
        session.setAttribute("v2", "bbb"); // 클라이언트당 한개
        request.setAttribute("v3", "ccc"); // 매번 요청할때마다
        
        request.getRequestDispatcher("/step11/exam02").forward(request, response);
        
        // forwarding 하고 including하는 서블릿끼리는 데이터를 공유한다. 그것을 확인해보자!
    
    }
}
