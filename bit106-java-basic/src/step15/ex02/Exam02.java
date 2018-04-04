// 인터페이스 구현 - 한 개라도 빠트리면 추상 메서드를 갖고 있는 상태가 된다.
package step15.ex02;

public abstract class Exam02 implements Servlet {
    // 인터페이스에 선언된 메서드를 한 개라도 빠트리면
    // 추상 메서드인채로 남아 있기 때문에
    // 일반 클래스가 될 수 없고,
    // 추상 클래스가 되어야 한다. -> 추상메서드를 보유할수 있는 클래스는 오직 추상 클래스여야 한다.
    public void init() {} // 메서드 몸체가 없다면 구현한 것이 아니다 -> 구현했다는것은 블럭안의 명령이 실행된다는 것이기 때문이다.
    public void destroy() {}
    public String getServletInfo() {return null;}
    public String getServletConfig() {return null;}
}
