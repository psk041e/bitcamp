// 인터페이스 구현 - 호출 규칙에 따라 메서드를 정의한다.
package step15.ex02;

public class Exam01 implements Servlet {
    // 인터페이스를 구현한다는 것은
    // 인터페이스에 정의된 모든 메서드를 구현한다는 뜻이다!
    public void init() {} // 메서드 몸체가 없다면 구현한 것이 아니다 -> 구현했다는것은 블럭안의 명령이 실행된다는 것이기 때문이다.
    public void service() {}
    public void destroy() {}
    public String getServletInfo() {return null;}
    public String getServletConfig() {return null;}
}
