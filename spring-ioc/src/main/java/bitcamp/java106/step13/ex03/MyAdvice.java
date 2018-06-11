// 특정 메서드 호출 전후에 실행되는 클래스
package bitcamp.java106.step13.ex03;

public class MyAdvice {
    // 삽입될 메서드를 정의한다.
    public void doBefore() {
        System.out.println("MyAdvice.doBefore()");
    }
    
    public void doAfter() {
        System.out.println("MyAdvice.doAfter()");
    }
    
    public void doAfterReturning() {
        System.out.println("MyAdvice.doAfterReturning()");
    }
    
    public void doAfterThrowing() {
        System.out.println("MyAdvice.doAfterThrowing()");
    }
    
    public void doAround() {
        System.out.println("MyAdvice.doAround()");
    }
}
