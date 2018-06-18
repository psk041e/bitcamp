// mybatis + spring IoC - 트랜잭션 적용 전
package step25.ex08;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01_insert {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext(
                        "step25/ex08/application-context.xml");
        
        // 트렌젝션 관리자를 도입하지 않으면,
        // DAO의 각 메서드 호출은 독립작업으로 간주한다.
        // 즉 DAO 메서드를 호출할 때마다 별도의 
        // DataSource로부터 별도의 DB 커넥션을 받아서 사용한다.
        // 따라서 DAO 메서드를 호출하다가 오류가 발생하더라도,
        // 그 전에 호출한 메서드의 작업은 그대로 DB 테이블에 적용된다.
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);
        
        Board board = new Board();
        board.setNo(131);
        board.setTitle("1111");
        board.setContent("xxxx");
        
        boardDao.insert(board);
        System.out.printf("%d번 게시물 입력!\n", board.getNo());
        
        board.setNo(132);
        board.setTitle("2222");
        boardDao.insert(board);
        System.out.printf("%d번 게시물 입력!\n", board.getNo());
        
        board.setNo(133);
        board.setTitle("3333");
        boardDao.insert(board);
        System.out.printf("%d번 게시물 입력!\n", board.getNo());
        
        System.out.println("-------------------------------------");
        
        List<Board> list = boardDao.selectList();
        for (Board b : list) {
            System.out.printf("%d, %s, %s\n",
                    b.getNo(), b.getTitle(), b.getRegisteredDate());
        }
    }
}







