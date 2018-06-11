// @RequestMapping - HTTP 헤더로 메서드 구분하기
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam04_3") 
public class Exam04_3 {
    
    // HTTP 요청에서 "Accept" 헤더의 값에 따라 호출될 메서드를 구분하기
    // => 클라이언트가 리턴 받기를 원하는 타입이 무엇인지를 지정하는 헤더가 Accept이다.
    // 테스트 방법:
    // 예1) exam04_3.html
    @GetMapping(value="get", produces="text/plain") // 서버에게 ~을 달라고 요청할때 그것을 여기에 기록하는 것이다.
    @ResponseBody
    public String m1() {
        // 이 메서드는 실행한 결과를 순수한 텍스트로 만들어 보내야 한다.
        return "Exam04_3.m1()";
    }
    
    @GetMapping(value="get", produces="text/html")
    @ResponseBody
    public String m2() {
        // 이 메서드는 실행한 결과를 HTML 텍스트로 만들어 보내야 한다.
        return "Exam04_3.m2()";
    }
    
    @GetMapping(value="get", produces="application/pdf")  
    @ResponseBody
    public String m3() {
        // 이 메서드는 실행한 결과를 PDF 로 만들어 보내야 한다.
        return "Exam04_3.m3()";
    }
}
