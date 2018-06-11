// 요청 핸들러의 리턴 값 - view 컴포넌트 URL또는 이름 리턴하기
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.RedirectView;

@Controller 
@RequestMapping("/exam06_3") 
public class Exam06_3 {
    // 우리가 많이 보게되는 유형은 String이나 ModelAndView를 리턴하는 것일것이다.
    
    // request handler에서 view URL을 리턴하면
    // 프론트 컨트롤러는 그 URL을 include한다.
    @GetMapping(value="m1")  
    public String m1() {
        // 리턴 값으로 JSP의 URL을 알려주면 된다. 
        return "/exam06_3.jsp";
    }
    
    // 이 경우는 잘 쓰지 않는다.
    @GetMapping(value="m2")  
    public View m2() {
        // view 컴포넌트 URL을 View 구현체에 담아서 리턴 할 수 있다.
        return new JstlView("/exam06_3.jsp");
    }
    
    // 실무에서 잘 쓰지 않는다. 보통 redirect는 m4와 같은것을 사용한다.
    @GetMapping(value="m3")  
    public View m3() {
        // view 컴포넌트 URL을 View 구현체에 담아서 리턴 할 수 있다.
        return new RedirectView("../exam06_1/m1"); // redirect하라 -> 웹브라우저는 다시 exam06_1요청
    }
    
    @GetMapping(value="m4")  
    public String m4() {
        // 보통 redirect는 문자열로 URL을 리턴한다.
        // URL에 "redirect:"라는 접두어를 붙여서 문자열로 리턴한다.
        return "redirect:../exam06_1/m2";
    }
    
    @GetMapping(value="m5")  
    public ModelAndView m5() {
        // 데이터와 하몍 view URL을 리턴할 때는 ModelAndView 객체를 사용하기도 한다.
        // => 
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "홍길동");
        mv.addObject("age", 20);
        mv.setViewName("/exam06_3.jsp");
        return mv;
    }
}







