// view resolver 다루기 - 기본 뷰 리졸버를 InternalResouceViewResolve로 교체
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/exam06_4") 
public class Exam06_4 {
    
    @GetMapping(value="m1")  
    public String m1(Model model) {
        model.addAttribute("name", "홍길동");
        model.addAttribute("age", 20);
        
        // InternalResourceViewResolver를 사용하면 
        // view URL을 리턴할 때 다음과 같이 간결해진다.
        return "exam06_4";
    }
    // 바로 외부에서 jsp를 실행하는것은 의미가 없다. 실제 작업은 컨트롤러가 하기 때문에 값이 나오지 않기 때문이다. 
    // 그렇다면 jsp를 외부에서 실행하지 않도록 해보자. -> WEB-INF/jsp폴더를 만들고 exam06_4.jsp를 이 밑에 놓는다.  
    // => 이제 직접 exam06_4.jsp에 접근할수 없다. -> 실행 불가 
    // 오로지 프론트 컨트롤러만이 가능하게 된다.
    // 그런데 실무에서는 여기서 한 발 더 나아가 /WEB-INF/jsp 을 매번 붙이는것이 번거롭기 때문에 자동으로 붙여주도록 한다. 
    // => mvc-servlet.xml의 prefix, suffix
 
    @GetMapping(value="m2")  
    public void m2(Model model) {
        model.addAttribute("name", "홍길동");
        model.addAttribute("age", 20);
        
        // view URL을 리턴하지 않는다.
        // 에러메세지 ->  /bitcamp-spring-webmvc/WEB-INF/jsp/exam06_4/m2.jsp
        //
        // view URL을 리턴하지 않으면
        // 프론트 컨트롤러는 요청 URL을 기준으로 view URL을 계산한다.
        // 예) /bitcamp-spring-webmvc/WEB-INF/jsp/exam06_4/m2
        // 프론트 컨트롤러에 전달되는 기본 URL을 제외하면 다음과 같다.
        //      => exam06_4/m2
        // 이 URL을 가지고 InternalResourceViewResolver는 view URL을 계산한다.
        //      prefix + 페이지 컨트롤러 url + suffix
        //      = "/WEB-INF/jsp/" + "exam06_4/m2" + ".jsp"
        //      = "/WEB-INF/jsp/exam06_4/m2.jsp"
        //
        // 이 방식의 장점은
        // JSP를 requst handler의 URL에 맞춰서 만들면
        // request handler에서 따로 view URL을 리턴할 필요가 없어 편리하다.
        //
        // 실무에 가면 최대한 반복적인 일을 하지 않도록 노력한다.
        // => jsp폴더에 exam06_4폴더를 만들고 exam06_4.jsp를 메서드 명과 같이 바꿔 붙여넣어준다.
        //    ex) m2.jsp
        //
        // 이것이  InternalResouceViewResolve를 쓰는 이유이다.
        // 구조만 이해하면 그 파일을 찾기가 쉬워 유지보수가 쉽다.
        // 이것을 프로젝트에 적용해보자
        //
        // 주의!
        // 웹 브라우저가 직접 접근해야 하는것은 절대 jsp폴더 밑에 둬서는 안된다! ex) html,css... 
        
    }
}







