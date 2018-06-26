// URL에서 값을 추출하기 - Path Variable(경로 변수)
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam07_1") 
public class Exam07_1 {
    
    // url포함 => path variable
    // ex) http://www.zdnet.co.kr/news/news_view.asp?artice_id=20180426113834&lo=z35
    // 실행 방법:
    // http://localhost:8888/bitcamp-spring-webmvc/mvc/exam07_1/m1?name=hong&age=20
    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody  
    public String m1(String name, int age) {
        return String.format("m1(): name=%s, age=%d", name, age);
    }
 
    // 파라미터
    // 주로 조회할 때 사용한다. ex) 아이디 (http://www.cnet.co.kr/)
    // url이 훨씬 직관적이다. 
    // 실행 방법:
    // http://localhost:8888/bitcamp-spring-webmvc/mvc/exam07_1/m2/hong/20
    @GetMapping(value="m2/{name}/{age}", 
                produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(
            @PathVariable String name,
            @PathVariable int age) {
        return String.format("m2(): name=%s, age=%d", name, age);
    }

}







