package bitcamp.java106.pms.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;

@Component("/board")
public class BoardController {
    
    BoardDao boardDao;
    
    public BoardController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    // Front Controller가 꼽아준다.
    // 공통적인 일을 할 필요가 없다.
    @RequestMapping("/add") // 단순히 add라고 해도 된다. spring web mvc에서는 /를 안붙여도 된다.
    public String add(Board board) throws Exception {
        
        // board객체에 클라이언트가 넘겨준 파라미터 값 달라
            boardDao.insert(board);
            return "redirect:list.do";
            
    }
    
    @RequestMapping("/delete")
    public String delete(@RequestParam("no") int no) throws Exception {
        // 파라미터명이 뭔지 모르기 때문에 
        // 겟터셋터가 없기 때문에 
        
            int count = boardDao.delete(no);
            if (count == 0) {
                throw new Exception("해당 게시물이 없습니다.");
            }
            return "redirect:list.do";
            
    }
    
    @RequestMapping("/list")
    public String list(Map<String,Object> map) throws Exception {        
        // request에 직접 담지 않고 jsp가 사용할 데이터를 받는다.
            // JSP에서 출력할 게시물 목록을 가져온다.
            List<Board> list = boardDao.selectList();
            
            map.put("list", list);
            return "/board/list.jsp";
            
    }
    
    @RequestMapping("/update")
    public String update(Board board) throws Exception {
        
            int count = boardDao.update(board);
            if (count == 0) {
                throw new Exception("해당 게시물이 존재하지 않습니다.");
            } 
            return "redirect:list.do";
            
    }
    
    @RequestMapping("/view")
    public String view(@RequestParam("no") int no, Map<String,Object> map) throws Exception {
        // 데이터를 넘겨줄테니 데이터를 넘겨줄 바구니를 줘라
        
            Board board = boardDao.selectOne(no);
            if (board == null) {
                throw new Exception("유효하지 않은 게시물 번호입니다.");
            }
            map.put("board", board);
            return "/board/view.jsp";
            
    }

}

//ver 49 - 요청 핸들러의 파라미터 값 자동으로 주입받기
//ver 48 - CRUD 기능을 한 클래스에 합치기
//ver 47 - 애노테이션을 적용하여 요청 핸들러 다루기
//ver 46 - 페이지 컨트롤러를 POJO를 변경
//ver 45 - 프론트 컨트롤러 적용
//ver 42 - JSP 적용
//ver 40 - 필터 적용
//ver 39 - forward 적용
//ver 38 - redirect 적용
//ver 37 - BoardAddController 클래스를 서블릿으로 변경
//         출력 결과를 HTML로 변경
//         자동 Refresh 태그 추가
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - BoardController에서 add() 메서드를 추출하여 클래스로 정의. 






