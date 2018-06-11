// @RequestMapping - HTTP 요청에서 Content-Type 헤더 다루기
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam04_4") 
public class Exam04_4 {
    
    // HTTP 요청에서 "Content-Type" 헤더의 값에 따라 호출될 메서드를 구분하기
    // => 클라이언트는 POST 요청으로 데이터를 보낼 때 
    //    서버에 그데이터 타입을 알려줘야 한다.
    //    그 때 사용하는 헤더가 "Content-Type"이다. (보통 POST와 결합해서 한다.)
    // 테스트 방법: 
    // 예1) exam04_4.html
    
// POST 요청
/*
POST /bitcamp-spring-webmvc/mvc/exam04_4/get HTTP/1.1
Host: localhost:8888
Accept: ....
User-Agent: ....
Content-Type: 

name=aaa&age=20&tel=1111-2222&Postno=19876&addr=서울시강남구
 */
    
    // 만약 클라이언트가 보낸 데이터가 "변수=값&변수=값&변수=값" 형태로 돼 있다면?
    @PostMapping(value="post", consumes="application/x-www-form-urlencoded") // 서버쪽에서는 이런 형식으로 된 데이터를 소비(consumes)하겠다.
    @ResponseBody
    public String m1() {
        return "Exam04_4.m1()";
    }
    
    // 만약 클라이언트가 보낸 데이터가 "값,값,값,값" 형태로 돼 있다면?
    @PostMapping(value="post", consumes="text/csv")
    @ResponseBody
    public String m2() {
        return "Exam04_4.m2()";
    }
    
    // 만약 클라이언트가 보낸 데이터가 {"name":"aaa","age":"20","tel":"1111-2222"} 형태로 돼 있다면?
    @PostMapping(value="post", consumes="application/json")  
    @ResponseBody
    public String m3() {
        return "Exam04_4.m3()";
    }
}
