package bitcamp.java106.pms.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/board")
public class BoardController {
    
    BoardDao boardDao;
    
    public BoardController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @RequestMapping("/add") // 단순히 add라고 해도 된다. spring web mvc에서는 /를 안붙여도 된다.
    public String add(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
            Board board = new Board();
            board.setTitle(request.getParameter("title"));
            board.setContent(request.getParameter("content"));

            boardDao.insert(board);
            return "redirect:list.do";
            
    }
    
    @RequestMapping("/delete")
    public String delete(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
            int no = Integer.parseInt(request.getParameter("no"));
            int count = boardDao.delete(no);
            if (count == 0) {
                throw new Exception("해당 게시물이 없습니다.");
            }
            return "redirect:list.do";
            
    }
    
    @RequestMapping("/list")
    public String list(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {        

            // JSP에서 출력할 게시물 목록을 가져온다.
            List<Board> list = boardDao.selectList();
            
            request.setAttribute("list", list);
            return "/board/list.jsp";
            
    }
    
    @RequestMapping("/update")
    public String update(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
            Board board = new Board();
            board.setNo(Integer.parseInt(request.getParameter("no")));
            board.setTitle(request.getParameter("title"));
            board.setContent(request.getParameter("content"));
            
            int count = boardDao.update(board);
            if (count == 0) {
                throw new Exception("해당 게시물이 존재하지 않습니다.");
            } 
            return "redirect:list.do";
            
    }
    
    @RequestMapping("/view")
    public String view(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {
        
            int no = Integer.parseInt(request.getParameter("no"));
            Board board = boardDao.selectOne(no);
            if (board == null) {
                throw new Exception("유효하지 않은 게시물 번호입니다.");
            }
            request.setAttribute("board", board);
            return "/board/view.jsp";
            
    }

}

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






