// 요청 핸들러의 파라미터 - 클라이언트가 보낸 데이터를 객체로 받기
package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bitcamp.mvc.vo.Board;

@Controller 
@RequestMapping("/exam05_3") 
public class Exam05_3 {
    
    // 프론트 컨트롤러로부터 클라이언트가 보낸 값들을 객체에 담아서 받을 수 있다.
    // 테스트: 
    // http://localhost:8888/bitcamp-spring-webmvc/mvc/exam05_3/m1?no=11&title=aaaa&content=bbbb
    @GetMapping(value="m1")
    @ResponseBody
    public String m1(Board board) {
        return String.format("m1(): no=%d, title=%s, content=%s",
                board.getNo(),
                board.getTitle(),
                board.getContent());
    }
    
    // 객체로 받을 수 있는 
    @GetMapping(value="m2")
    @ResponseBody
    public String m2(Board board, String writer) {
        return String.format("m2(): no=%d, title=%s, content=%s, writer=%s",
                board.getNo(),
                board.getTitle(),
                board.getContent(),
                writer);
    }
    
    // 객체로 받을 수 있는 
    @GetMapping(value="m3")
    @ResponseBody
    public String m3(Board board) {
        return String.format("m3(): %s", board);
    } // board객체의 toString을 호출해서 그 리턴값을 이 자리에 놓을 것이다.
    
}



