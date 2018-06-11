// 세션 다루기 - @ModelAttribute를 사용하여 @SessionAttributes에 지정된 값 꺼내기 
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller 
@RequestMapping("/exam08_4")

//세션 보관소에 저장하고 꺼낼 값의 이름을 지정한다.
@SessionAttributes({"name", "age", "working"})
// 세션의 값을 @ModelAttribute를 사용하여 꺼내려면
// 마찬가지로 @SessionAttributes 애노테이션으로 꺼낼 값의 이름을 지정해야 한다. 
public class Exam08_4 {
    
    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(
            // 만약 세션에 보관된 값이 없다면 실행 오류가 발생한다!
            // @SessionAttributes가 반드시 선언되어있어야 한다.
            @ModelAttribute("name") String name,
            @ModelAttribute("age") int age,
            @ModelAttribute("working") boolean working) {
        
        return String.format("m1(): @ModelAttribute로 세션 값 꺼내기 - name=%s, age=%d, working=%b",
                name, age, working);
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(SessionStatus status) { 
        
        // SessionStatus로 세션에 보관된 값 없애기 (값만 없앨 수 있다.)
        status.setComplete(); // 서블릿 기술이 아니라 스프링에서 제공하는 기술이다.
        
        return String.format("m2(): SessionStatus로 세션에 보관된 값 없애기!"); // 세션을 무효화시키는 것이 아니다.
    }
    
    @GetMapping(value="m3", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m3(
            // @SessionAttributes에 지정된 값을 꺼낼 때는 @ModelAttribute 를 사용하라!
            // => HttpSession에서 꺼내지 말고 @ModelAttribute 을 사용해 지정된 값을 바로 꺼내도록 해라.
            @ModelAttribute("name") String name, // name="name"
            @ModelAttribute("age") int age, 
            
            // ※주의! @SessionAttributes에 지정된 값이 아니거나 없을 때는 오류가 발생한다!
            @ModelAttribute("working") boolean working) { 
        // 항상 default값은 문자열이어야 한다.
        // 그 문자열을 int, boolean 타입으로 바꾸는 것이다.
        return String.format("m3(): name=%s, age=%d, working=%b", name, age, working);
    }
    
}


