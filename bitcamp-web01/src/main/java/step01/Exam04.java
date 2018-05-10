// 서블릿 만들기 4 - 
package step01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// => GenericServlet 상속 받는 대신 HTTP 프로토콜을 다루는 기능이 추가된
//    HttpServlet 을 상속 받아 만든다.
//
@WebServlet("/step01/exam04") 
public class Exam04 extends HttpServlet { 
    // 클라이언트가 실행을 요청하면,
    // HTTP 프로토콜의 명령에 따라
    // 상속 받은 메서드 중에서 doGet(), doPost(), doHead()가 호출될 것이다.
    // 문제는,
    // 이들 메서드를 적절히 오버라이딩(재정의)하지 않았기 때문에
    // 원래 작성된
}
