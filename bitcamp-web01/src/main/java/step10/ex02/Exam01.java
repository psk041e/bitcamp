// 쿠기 : 유효기간 설정하기
package step10.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/step10/ex02/exam01")
public class Exam01 extends HttpServlet {
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        Cookie cookie1 = new Cookie("c1", "aaa");
        cookie1.setMaxAge(20); // 유지시간(초)을 설정한다.
        // 유효기간을 설정하면, 웹브라우저를 닫아도, 컴퓨터를 종료해도 유지된다.
        // 즉 파일 시스템(HDD 등)에 보관하기 때문에 컴퓨터를 꺼도 유지된다.
        
        Cookie cookie2 = new Cookie("c2", "bbb");
        cookie2.setMaxAge(30); // 30초 동안만 유효하다.
        
        Cookie cookie3 = new Cookie("c3", "ccc");
        // 유효기간을 설정하지 않으면, 웹 브라우저를 실행하는 동안만 유효하다.
        // 웹브라우저를 닫으면 유효기간이 설정되지 않은 쿠키는 자동으로 삭제된다.
        
        // 2) 응답 헤더에 쿠키 정보를 붙인다.
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("쿠키를 보냈습니다.");
        
        // 유효기간 설정된 쿠키의 프로토콜?
        //HTTP/1.1 200
        //Set-Cookie: c1=aaa; Max-Age=10; Expires=Wed, 23-May-2018 01:54:56 GMT
        //Set-Cookie: c1=bbb; Max-Age=30; Expires=Wed, 23-May-2018 01:55:16 GMT
        //Set-Cookie: c3=ccc
        //Content-Type: text/plain;charset=UTF-8
        //Content-Length: 28
        //Date: Wed, 23 May 2018 01:54:46 GMT
        
    }
    
    
}
