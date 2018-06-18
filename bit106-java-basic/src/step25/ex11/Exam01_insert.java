// mybatis + spring IoC - 트랜잭션 정책 테스트
package step25.ex11;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01_insert {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext(
                        "step25/ex11/application-context.xml");
        
        BoardService boardService= iocContainer.getBean(BoardService.class);
        
        Board b1 = new Board().setNo(191).setTitle("1111").setContent("xxxx");
        Board b2 = new Board().setNo(192).setTitle("1111").setContent("xxxx");
        Board b3 = new Board().setNo(193).setTitle("1111").setContent("xxxx");
        Board b4 = new Board().setNo(194).setTitle("1111").setContent("xxxx");
        Board b5 = new Board().setNo(191).setTitle("1111").setContent("xxxx");
        
        boardService.test1(b1, b2, b3, b4, b5);
    }
}







