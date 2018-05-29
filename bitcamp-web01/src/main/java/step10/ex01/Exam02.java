// 쿠기 : 클라이언트쪽에 데이터를 보관된 쿠키 데이터를 꺼내는 방법
package step10.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial") // serial관련된 경고는 무시하라
@WebServlet("/step10/ex01/exam02")
public class Exam02 extends HttpServlet {
    // 파일을 저장할 때 몇번재 버전인지 저장할 목적으로 serialize를 사용한다.
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        // 쿠키(cookie) 보내기
        // => 쿠키는 서버가 요청하지 않아도 웹브라우저에게 무조건 보낸다.
        //    물론 웹서버가 웨브라우저에 쿠키를 보낼 때 조건에 따라 웹서버에 보낸다.
        
        // 1) 쿠키 가져오기
        // => 안타깝게도 특정 이름을 가진 쿠키 값만 꺼내는 메서드가 없다.
        // (스프링 mvc에서는 이것을 자동으로 처리해준다.)
        Cookie[] cookies = request.getCookies();
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("클라이언트가 보낸 쿠키들: ");

        for (Cookie cookie : cookies) {
            out.printf("%s=%s\n", cookie.getName(), cookie.getValue());
        }
        
// 웹브라우저가 웹서버로 쿠키를 보내는 HTTP 프로토콜?
//        GET /bitcamp-web01/step10/ex01/exam02 HTTP/1.1
//        Host: localhost:8888
//        Connection: keep-alive
//        Pragma: no-cache
//        Cache-Control: no-cache
//        Upgrade-Insecure-Requests: 1
//        User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36
//        Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
//        Accept-Encoding: gzip, deflate, br
//        Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
//        Cookie: c1=aaa; c2=123
        
    }
    
    
}
