// 서블릿 만들기 5 - HttpServlet의 메서드 재정의하기
package step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step01/exam05") 
public class Exam05 extends HttpServlet {
    // 클라이언트가 실행을 요청하면
    // 명령어에 따라 적절한 메시지를 출력하도록 상속 받은 메서드를 재정의하자!
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 웹 브라우저의 주소창에 URL을 집어넣고 엔터를 치면,
        // 해당 서버에 GET 요청을 보낸다.
        // 그러면 서블릿 컨테이너가 자바 클래스에 대해 service()를 호출할 것이고,
        // 이 클래스는 HttpServlet을 상속 받았기 때문에
        // HttpServlet의 servlet(ServletRequest, ServletResponse)를 호출할 것이다.
        // 이 메서드는 다시 오버로딩한 service(HttpServletRequest, HttpServletResponse)를
        // 호출할 것이다. 그리고 이 오버로딩한 메서드는 클라이언트가 요청한 명령에 따라 
        // doGet()을 호출할 것이다.
        // 그래서 이 클래스는 doGet()을 오버라이딩(재정의)하여
        // 우리가 원하는 작업을 수행하도록 하였다.
        
        // doGet(), doPost(),, 처럼
        // 명령어에 따라서 구분해서 처리하고 싶을 때 HttpServlet을 상속받아 처리한다.
        
        // 출력 스트림을 얻기 전에 알려주지 않으면
        // 영어를 제외한, 즉 ASCII코드를 제외한 것들이 모두 깨진다.
        // 한글이 깨진것을 신경쓰지 말고 doGet()이 호출된것을 확인해라!
        PrintWriter out = response.getWriter();
        out.println("GET 요청 하셨네요.^^");
    }
}
