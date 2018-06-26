package bitcamp.java106.pms.web.json;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.service.BoardService;
// json 처리할 컨트롤러
// jsp를 처리하는 경우와 json을 처리하는 경우를 분리시켰다.
@RestController
@RequestMapping("/board")
public class BoardController {
    
    // contextLoaderListener에 있는것을 공유한다.
    BoardService boardService;
    
    public BoardController(BoardService boardService) {
        this.boardService= boardService;
    }

    // 입력폼은 필요 없다.
    
    @RequestMapping("add")
    // 참고 (https://docs.spring.io/spring/docs/5.0.5.RELEASE/spring-framework-reference/web.html#mvc-ann-requestmapping)
    // 정교하게 응답하는 경우도 있다. => 등록이 성공했을 때 201 을 리턴한다. 
    @ResponseStatus(HttpStatus.CREATED)
    public void add(Board board) throws Exception {
        boardService.add(board);
        //return "success";
    }
    
    @RequestMapping("delete")
    //@ResponseStatus(HttpStatus.OK) // 응답 상태 코드 값의 기본은 "200(OK)" 이다.
    public void delete(@RequestParam("no") int no) throws Exception {
        boardService.delete(no);
    }
    
    @RequestMapping("list{page}")
    public Object list(
            @MatrixVariable(defaultValue="1") int pageNo,
            @MatrixVariable(defaultValue="3") int pageSize) {        
        
        return boardService.list(pageNo, pageSize);
    }
    
    @RequestMapping("update")
    @ResponseStatus(HttpStatus.OK) // 기본 값이 OK 이다.
    public void update(Board board) throws Exception {
        boardService.update(board);
    }
    
    @RequestMapping("{no}")
    public Board view(@PathVariable int no) throws Exception {
        return boardService.get(no);
    }

}

//ver 55 - JSON 데이터를 출력하는 페이지 컨트롤러 생성






