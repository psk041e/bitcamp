// GenericServlet + HTTP 프로토콜 기능 = HttpServlet 클래스
package step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 비록 HttpServlet 클래스는 추상 메서드가 없지만,
// 이 클래스의 목적이 서브 클래스에게 공통 기능을 상속해 주는 것이기 때문에
// 바로 사용할 수 없도록 추상 클래스로 선언한다.
public abstract class HttpServlet extends GenericServlet{
    @Override // 톰캣서버가 이것을 호출하면 내부적으로 아래의 메서드를 호출한다.
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 파라미터로 넘어오는 것은 실제로 HTTP 프로토콜을 다룰 수 있는 객체가 넘어온다.
        // 즉, ServletRequest 대신에 그 자식 객체인 HttpServletRequest 가 넘어온다.
        // ServletResponse 대신에 그 자식 객체인 HttpServletReponse 객체가 넘어온다.
        // 따라서 이들 객체로 형변환해도 된다.
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;
        
        this.service(httpRequest, httpResponse); 
    } 
    
    // 개발 편의를 위해 serivce 메서드를 추가한다. (오버로딩)
    protected void service(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        // 이 메서드는 클라이언트가 요청한 명령에 따라
        // 또 다른 메서드를 호출한다.
        String command = request.getMethod();
        
        switch (command) {
        case "GET": doGet(request, response); break;
        case "POST": doPost(request, response); break;
        case "HEAD": doHead(request, response); break;
        default:
            throw new ServletException("해당 명령을 처리할 수 없습니다!");
        }
        
    }

    protected void doGet ( 
            // private하면 서브클래스에서 접근할수 없으므로 protected해주면
            // 패키지가 다르더라도 이 메서드를 사용할수 있으므로 오버라이딩 할 수 있다.
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        throw new ServletException("해당 명령을 처리할 수 없습니다!");    }
    
    protected void doPost (
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        throw new ServletException("해당 명령을 처리할 수 없습니다!");    }
    
    protected void doHead (
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        throw new ServletException("해당 명령을 처리할 수 없습니다!");    }
    
    protected void printError(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("해당 명령을 처리할 수 없습니다.");
    }
    
}
