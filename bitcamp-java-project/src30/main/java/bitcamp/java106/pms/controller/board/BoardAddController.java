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
        
        // 스레드 테스트용 코드
        /*
        for (int i = 0; i < 300000000; i++) {
            Math.random(); // add하는데 시간이 걸린다. 
            // 임의의 수를 가져온다.but, 완전한 랜덤은 아니다. -> 0 <= x(double) < 1
            // cf) 많이 반복하게 되면 패턴이 반복된다. -> 암호화시킬때 랜덤값으로 암호화시켜서 보낼 때 알아챌수 있다.
            //     양자 컴퓨팅을 사용하면 진정한 랜덤값을 뽑아낼 수 있고 그 랜덤값을 가지고 실생활에 적용하면 완전한 암호가 가능하다.
            // cpu는 다른 
        }
        */
        
        PrintWriter out = response.getWriter();
        // PrintWriter에 StringWriter를 연결해 줬기 때문에 StringWriter 메모리에 값이 저장된다.
        out.println("등록 성공!");
    }

}

//ver 28 - 네트워크 버전으로 변경
//ver 26 - BoardController에서 add() 메서드를 추출하여 클래스로 정의. 
