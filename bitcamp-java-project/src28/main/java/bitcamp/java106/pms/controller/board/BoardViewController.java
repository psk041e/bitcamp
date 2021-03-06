package bitcamp.java106.pms.controller.board;

import java.io.PrintWriter;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/board/view")
public class BoardViewController implements Controller {
    BoardDao boardDao;
    
    public BoardViewController(BoardDao boardDao) {
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
            out.printf("팀명: %s\n", board.getTitle());
            out.printf("설명: %s\n", board.getContent());
            out.printf("등록일: %s\n", board.getCreatedDate());
        }
    }
}

