package bitcamp.java106.pms.controller.board;

import java.io.PrintWriter;
import java.sql.Date;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/board/add")
public class BoardAddController implements Controller {
    BoardDao boardDao;
    
    public BoardAddController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
     
    public void service(ServerRequest request, ServerResponse response) {
        Board board = new Board();
        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));
        board.setCreatedDate(new Date(System.currentTimeMillis()));
        boardDao.insert(board);
        
        PrintWriter out = response.getWriter();
        // PrintWriter에 StringWriter를 연결해 줬기 때문에 StringWriter 메모리에 값이 저장된다.
        out.println("등록 성공!");
    }

}

//ver 28 - 네트워크 버전으로 변경
//ver 26 - BoardController에서 add() 메서드를 추출하여 클래스로 정의. 
