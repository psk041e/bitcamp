// 서블릿 생성과 load-on-startup 옵션
package step07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step07/exam01")
public class Exam01 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public Exam01() {
        // 클라이언트로부터 최초로 실행 요청이 들어오면 객체가 생성된다.
        System.out.println("step7.Exam01() 호출!");
    }
    
    // 서블릿 인터페이스를 직접 구현하려면 아래의 init를 구현해야 하지만
    // GenericServlet, HttpServlet을 구현하면 위의 init를 구현해라
    // 아래의 init는 Servlet을 리턴해야 하기때문에 불편하다.이미 다 GenericServlet에 있다.
    // 아래의 init이호출되면 init()이 반드시 호출된다.
    @Override
    public void init() throws ServletException {
        // 서블릿 컨테이너가 init(ServletConfig)를 호출하면
        // => 그 메서드가 이 메서드를 호출한다.
        // => 따라서 서블릿이 작업하는 데 필요한 자원을 준비시키고 싶다면
        //    이처럼 이 메서드를 오버라이딩 하면 된다.
        // 이것이 다이렉트로 호출되는 것이 아니다.
        System.out.println("step07.Exam01.init() 호출!");
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        System.out.println("step07.Exam01.service() 호출!");
        // 클라이언트가 요청하지 않아도 객체를 생성시키는 방법이 있다.
        
        // 클라이언트가 GET 요청했을 때 호출된다. 
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("Hello!");
    }
}
