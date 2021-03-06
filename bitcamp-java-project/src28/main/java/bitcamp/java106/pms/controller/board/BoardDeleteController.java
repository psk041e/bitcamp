package bitcamp.java106.pms.controller.board;

import java.io.PrintWriter;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/board/delete")
public class BoardDeleteController implements Controller {
    BoardDao boardDao;
    
    public BoardDeleteController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        int no = Integer.parseInt(request.getParameter("no"));
        
        Board board = boardDao.get(no);
        
        if (board == null) {
            out.println("유효하지 않은 게시물 번호입니다.");
        } else {
            boardDao.delete(no);
            out.println("삭제하였습니다.");
        }
    }
    
}

