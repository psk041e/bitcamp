// 서블릿 생성과 load-on-startup 옵션
package step07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// loadOnStartup=생성순서
// - 서블릿 컨테이너가 시작할 때 이 옵션이 붙은 서블릿은 클라이언트가 요청하지 않아도 객체를 자동 생성한다.
// - 번호가 빠른 순서대로 먼저 서블릿이 생성된다.
// - 보통 다른 서블릿들이 사용할 자원을 준비할때 이 옵션을 사용한다.ㅑ
@WebServlet(
        value="/step07/exam02", // 서블릿의 URL
        loadOnStartup=1 // 클라이언트가 요청하지 않아도 자동 생성하도록 설정함. 1번으로 생성
        )
public class Exam02 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public Exam02() {
        // 클라이언트로부터 최초로 실행 요청이 들어오면 객체가 생성된다.
        System.out.println("step7.Exam02() 호출!");
    }
    
    @Override
    public void init() throws ServletException {
        System.out.println("step07.Exam02.init() 호출!");
    }
   
    // 다른 서블릿들을 위해 초기화 작업을 수행하는 서블릿인경우
    // 
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
