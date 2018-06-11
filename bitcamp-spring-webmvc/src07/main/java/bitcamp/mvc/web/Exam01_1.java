// @Controller와 @RequestMapping
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 페이지 컨트롤러를 가리킬 때 보통 이 애노테이션을 붙인다. 그래서 컨트롤러이다.
@RequestMapping("/exam01_1/m1") // 요청 핸들러와 URL을 연결할 때 이 애노테이션을 붙인다.
public class Exam01_1 {
    
    @RequestMapping // 위에서 지정한 URL 요청을 처리할 메서드를 지정한다. (위에서는 URL, 밑에서는 메서드 지정)
    @ResponseBody // 이 메서드의 리턴 값은 클라이언트에게 리턴할 콘텐트임을 지정한다.
    public String m1() {
        return "Exam01_1.m1()";
    }
    
    // 
    //@RequestMapping
    //@ResponseBody
//    public String m2() {
//        return "Exam01_1.m2()";
    }
