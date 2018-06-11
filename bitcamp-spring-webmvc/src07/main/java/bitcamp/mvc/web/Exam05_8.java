// 요청 핸들러의 파라미터 - 쿠키 받기 
package bitcamp.mvc.web;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam05_8")
public class Exam05_8 {
    // 서버에서 물음표로 바꿔서 보낸것이다. 브라우저와 상관 없다.
    // @Cookie 애노테이션을 이용하여 클라이언트가 보낸 쿠키 값을
    // 프론트 컨트롤러로부터 받을 수 있다.
    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(HttpServletResponse response) {
        try {
            Cookie c1 = new Cookie("name",
                    URLEncoder.encode("홍길동", "UTF-8"));
            
            Cookie c2 = new Cookie("age", "20");
            
            response.addCookie(c1);
            response.addCookie(c2);
            
            return "쿠키 값을 보냈습니다.";
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(
            // 한글 데이터를 쿠키로 저장할때는 인코딩해서 저장하고, 꺼낼때는 쿠키로 받아 디코딩해야 한다.
            // URL 인코딩된 쿠키 값을 받을 때는 쿠키 객체로 받아야 문자가 깨지지 않는다.
            @CookieValue(value="name", defaultValue="") Cookie name, 
            
            // URL 인코딩된 값이 아닌 경우에는 다음과 같이 특정 타입으로 바로 받아도 된다.
            @CookieValue(value="age", defaultValue="0") int age) { // 파라미터가 int라면 int로 바꿀 것이다. 
        
        try {
            System.out.println(name.getValue());
            return String.format("m2(): name=%s, age=%d", 
                    URLDecoder.decode(name.getValue(), "UTF-8"), age);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
