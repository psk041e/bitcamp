// 쿠기 : 한글 데이터 보내기
package step10.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step10/ex01/exam03")
public class Exam03 extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        // 쿠키 데이터의 조건
        // => 쿠키 데이터는 문자열만 가능하다.
        // => 응답 헤더로 보내기 때문에 반드시 URL 인코딩 해야 한다.
        // => Tomcat 9에서는 한글 데이터를 보내고 받을 수 있다.
        //    만약 Tomcat 8 이하 버전이나 다른 서블릿 컨테이너를 사용한다면
        //    한글이 깨질 수 있다.
        //    그럴 경우에는 URL 인코딩 하여 보내라!
        Cookie cookie1 = new Cookie("c1", 
                URLEncoder.encode("홍길동", "UTF-8"));
        Cookie cookie2 = new Cookie("c2", 
                URLEncoder.encode("임꺽정", "UTF-8"));
        
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("쿠키를 보냈습니다.");
        
        // 웹브라우저가 웹서버로 쿠키를 보내는 HTTP 프로토콜?
        //GET /bitcamp-web01/step10/ex01/exam02 HTTP/1.1
        //Host: localhost:8888
        //Connection: keep-alive
        //Pragma: no-cache
        //Cache-Control: no-cache
        //Upgrade-Insecure-Requests: 1
        //User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36
        //Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
        //Accept-Encoding: gzip, deflate, br
        //Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
        //Cookie: c1=123; JSESSIONID=A9CB1708BC2410A75CA97F960823C096
        
    }
    
    
}
