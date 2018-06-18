package step25.ex10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // 붙이지 않으면 자동생성되지 않는다.
public class BoardService {
    
    @Autowired BoardDao boardDao;
    
    @Transactional
    public void test1(Board b1, Board b2, Board b3) {
        boardDao.insert(b1);
        System.out.printf("%d번 게시물 입력!\n", b1.getNo());
        
        boardDao.insert(b2);
        System.out.printf("%d번 게시물 입력!\n", b2.getNo());
        
        boardDao.insert(b3);
        System.out.printf("%d번 게시물 입력!\n", b3.getNo());
    }
    
    public void test2(Board b1, Board b2, Board b3) {
        boardDao.insert(b1);
        System.out.printf("%d번 게시물 입력!\n", b1.getNo());
        
        boardDao.insert(b2);
        System.out.printf("%d번 게시물 입력!\n", b2.getNo());
        
        boardDao.insert(b3);
        System.out.printf("%d번 게시물 입력!\n", b3.getNo());
    }
}
