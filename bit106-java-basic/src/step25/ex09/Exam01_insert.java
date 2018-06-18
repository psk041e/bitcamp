// mybatis + spring IoC - 트랜잭션 적용 전
package step25.ex09;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01_insert {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext(
                        "step25/ex09/application-context.xml");
        
        // 트랜젝션 적용
        // 1) 트랜젝션 관리자를 등록해야 한다.
        //    => application-context.xml 파일에 객체 추가
        // 2) 트랜젝션 관리자가 동작하려면 DAO를 사용하는 객체도 트랜잭션 관리자와 같은 컨테이너 객체가 있어야 한다.
        //    즉 DAO의 메서드를 사용하는 객체 또한 Spring IoC 컨테이너에 있어야 한다.
        //     => DAO 메서드를 호출하는 Service 객체를 만든다.
        //    => BoardService 클래스 추가
        // 3) AOP를 사용하여 트랜잭션 관리자를 적용한다.
        //    => application-context.xml에 AOP Advice와 PointCut을 설정한다.
        BoardService boardService= iocContainer.getBean(BoardService.class);
        
        Board b1 = new Board();
        b1.setNo(151);
        b1.setTitle("1111");
        b1.setContent("xxxx");
        
        Board b2 = new Board();
        b2.setNo(152);
        b2.setTitle("2222");
        b1.setContent("xxxx");
        
        Board b3 = new Board();
        b3.setNo(152);
        b3.setTitle("3333");
        b3.setContent("xxxx");
        
        // test1()은 트랜잭션 매니저가 관리하기 때문에
        // 실행 중에 오류가 발생하면 그 전에 실행했던 모든 결과를 취소(rollback)한다.
        // 오류가 없어야만 commit 한다.
        // boardService.test2(b1, b2, b3);
        
        // 그러나 
        boardService.test2(b1, b2, b3);
        System.out.println("입력 성공!");
    }
}







