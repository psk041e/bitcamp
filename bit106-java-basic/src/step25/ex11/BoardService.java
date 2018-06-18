package step25.ex11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service // 붙이지 않으면 자동생성되지 않는다.
public class BoardService {
    
    @Autowired BoardDao boardDao;
    
//    @Transactional
    public void test1(Board b1, Board b2, Board b3, Board b4, Board b5) {
        boardDao.insert(b1);
        System.out.printf("test1(): %d번 게시물 입력!\n", b1.getNo());
        
        boardDao.insert(b2);
        System.out.printf("test1(): %d번 게시물 입력!\n", b2.getNo());
        
        test2(b3, b4); // 같은 트랜잭션에 종속된다.
        
        boardDao.insert(b5);
        System.out.printf("test1(): %d번 게시물 입력!\n", b5.getNo());
    }

    @Transactional(propagation=Propagation.REQUIRED) 
    // 트랜잭션을 반드시 요구 -> 트랜잭션이 있는것을 호출하면 그 트랜잭션을 사용한다.
    // 호출자와 같은 트랜잭션에 묶인다.
    public void test2(Board b3, Board b4) {
        boardDao.insert(b3);
        System.out.printf("test2() ====> %d번 게시물 입력!\n", b3.getNo());
        
        boardDao.insert(b4);
        System.out.printf("test2() ====> %d번 게시물 입력!\n", b4.getNo());
    }
}
