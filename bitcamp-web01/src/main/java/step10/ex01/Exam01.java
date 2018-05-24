// 쿠기 : 클라이언트쪽에 데이터를 보관하는 방법
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
@WebServlet("/step10/ex01/exam01")
public class Exam01 extends HttpServlet {
    // 파일을 저장할 때 몇번재 버전인지 저장할 목적으로 serialize를 사용한다.
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        // 쿠키(cookie) 보내기
        // 1) key-value 한 쌍의 값을 갖는 쿠키 객체를 만든다.
        Cookie cookie1 = new Cookie("c1", "aaa");
        Cookie cookie2 = new Cookie("c2", "123");
        
        // 2) 응답 헤더에 쿠키 정보를 붙인다.
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("쿠키를 보냈습니다.");
        
        // 쿠키(cookie)?
        // => 웹서버에서 데이터를 보내 웹브라우저에 쪽에 저장하는 것
        // => 웹브라우저는 웹서버로부터 받은 데이터를 보관하고 있다가
        //    웹서버에 요청할 때마다 다시 보낸다.
        //    예) 커피숍 쿠폰 
        //
        // 쿠키를 클라이언트로 보내는 Http프로토콜?
        //HTTP/1.1 200
        //Set-Cookie: c1=aaa
        //Set-Cookie: c1=123
        //Content-Type: text/plain;charset=UTF-8
        //Content-Length: 28
        //Date: Wed, 23 May 2018 01:17:36 GMT
        
    }
    
    
}
