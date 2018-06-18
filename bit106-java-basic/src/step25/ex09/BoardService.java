package step25.ex09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 붙이지 않으면 자동생성되지 않는다.
public class BoardService {
    
    @Autowired BoardDao boardDao;
    
    // 트랜잭션 매니저가 test1을 관리한다.
    // => test1에서 하는 모든 작업은 같은 connection 객체를 사용한다.
    public void test1(Board b1, Board b2, Board b3) {
        boardDao.insert(b1);
        System.out.printf("%d번 게시물 입력!\n", b1.getNo());
        
        boardDao.insert(b2);
        System.out.printf("%d번 게시물 입력!\n", b2.getNo());
        
        boardDao.insert(b3);
        System.out.printf("%d번 게시물 입력!\n", b3.getNo());
        
    }
}
