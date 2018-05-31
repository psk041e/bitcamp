// Spring과 Mybatis 연동 : 설정이 아니라 객체를 통해SqlSessionFactory 만들기
package bitcamp.java106.step12.ex02;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;
import bitcamp.java106.step12.Board;

public class Exam01 {

    public static void main(String[] args) throws Exception {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step12/ex02/application-context.xml");
        
        // 생성된 객체가 있는지 확인한다.
        BeanUtils.printBeanNames(iocContainer);
        
        BoardDao boardDao = iocContainer.getBean(BoardDao.class);
        
        // 1) 게시물 입력
        Board board = new Board();
        board.setTitle("제목입니다.");
        board.setContent("내용입니다.");
        boardDao.insert(board);
        
        // 2) 게시물 목록 조회
        List<Board> list = boardDao.selectList(1, 5);
        for (Board b : list) {
            System.out.printf("%d, %s, %s\n",
                    b.getNo(),
                    b.getTitle(),
                    b.getRegisteredDate());
            
        }
        
    }

}





