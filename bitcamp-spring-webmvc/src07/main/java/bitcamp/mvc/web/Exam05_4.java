// 요청 핸들러의 파라미터 - custom property editor 등록하기
package bitcamp.mvc.web;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bitcamp.mvc.vo.Member;

@Controller 
@RequestMapping("/exam05_4") 
public class Exam05_4 {
    
    // 프론트 컨트롤러가 페이지 컨트롤러를 호출할 때 기본적으로
    // 클라이언트가 보낸 문자열 데이터를 primitive type의 값으로 변환시켜 준다.
    // 그 외의 타입에 대해서는 개발자가 프로퍼티 값 변환기(property editor)를 등록해야 한다.
    // 테스트: 
    // http://localhost:8888/bitcamp-spring-webmvc/mvc/exam05_4/m1?title=aaa&content=bbb&createdDate=2018-06-04
    @GetMapping(value="m1")
    @ResponseBody
    public String m1(String title, String content, Date createDate) {
        return String.format("m1(): %s, %s, %s", title, content, createDate);
    }
    
    // 문자열로 넘어오 값을 커스텀 프로퍼티 에디터를 통해 Member 객체로 받을 수 있다.
    // 단 파라미터 타입 앞에 @RequestParam을 반드시 붙여야 한다.
    // 테스트: 
    // http://localhost:8888/bitcamp-spring-webmvc/mvc/exam05_4/m1?member=hong,hong@test.com,1111
    // member라는 이름으로 문자열이 넘어온다. 문자열은 객체가 아니기 때문에 문자열을 멤버 객체로 바꿔주어야 한다.
    // 그러면 문자열을 멤버 객체로 바꿔주는 에디터가 있느냐?
    // 프론트 컨트롤러가 멤버라는 파라미터 값으로 넘겨주는 것을 에디터에서 멤버 객체에 담아서 메서드가 호출될 때 그 결과값이 출력된다.
    @GetMapping(value="m2")
    @ResponseBody
    public String m2(@RequestParam Member member) {
        // Member 파라미터 앞에 @RequestParam이 붙게 되면
        // 반드시 파라미터명("member")으로 넘어온 값을 처리한다
        // 애노테이션을 붙이는 순간 그냥 "id", "email", "password"로 넘어온 값은 처리하지 않는다. 
        return String.format("m2(): id=%s, email=%s, password=%s", 
                member.getId(), member.getEmail(), member.getPassword());
    }
    
    // 각 페이지 컨트롤러에 프로퍼티 에디터를 등록할 수 있다.
    // 메서드의 형식:
    //      public void 메서드명(WebDataBinder binder) {...}  // 메서드명은 아무거나 적어도 된다. 파라미터 값은 보통 WebDataBinder
    // 그리고 요청이 들어올 때 마다 이 메서드를 먼저 실행하도록 설정해야 한다.
    //      @InitBinder 애노테이션을 붙여라
    @InitBinder // 이렇게 표시해야만 프론트 컨트롤러가 요청 핸들러를 호출하기 전에 먼저 이 메서드를 호출한다.
    public void initBinder(WebDataBinder binder) {
        
        // 이 메서드는 요청이 들어올 때 마다 파라미터 값을 준비하기 위해
        // 파라미터의 개수 만큼 호출된다.
        System.out.println("Exam05_4().오호라()");
        
        // java.long.String ===> java.sql.Date 변환시켜주는 프로퍼티 에디터 등록
        binder.registerCustomEditor(
                java.util.Date.class, /* 요청 핸들러의 파라미터 타입 */
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) throws IllegalArgumentException {
                        // "text" 파라미터는 클라이언트가 보낸 데이터이다.
                        // 이렇게 문자열로 보낸 데이터는 java.sql.Date 객체로 바꿔야 한다.
                        this.setValue(Date.valueOf(text));
                    }
                }); // 익명클래스 객체를 만든다.
        
     // java.long.String ===> bitcamp.mvc.vo.Member 객체로 변환시켜주는 프로퍼티 에디터 등록
        binder.registerCustomEditor(
                bitcamp.mvc.vo.Member.class, /* 요청 핸들러의 파라미터 타입 */
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) throws IllegalArgumentException {
                        // "text" 파라미터는 클라이언트가 보낸 데이터이다.
                        // 이렇게 문자열로 보낸 데이터는 java.sql.Date 객체로 바꿔야 한다.
                        String[] values = text.split(",");
                        Member obj = new Member();
                        obj.setId(values[0]);
                        obj.setEmail(values[1]);
                        obj.setPassword(values[2]);
                        this.setValue(values);
                    }
                });
        
// 만약 String을 날짜형식으로 바꾸려면 위의 클래스를 사용해라 
}
}


