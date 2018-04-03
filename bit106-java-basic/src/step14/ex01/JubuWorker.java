// Worker 구현체(implementor)
package step14.ex01;

public class JubuWorker implements Worker {
    // 인터페이스 구현체는 인터페이스에 선언된 모든 메서드를 구현해야 한다.
    // ctrl + space했을때 동그라미 위의 A는 아직 구현하기 전 추상체라는 의미이다.
    public void execute() {
        System.out.println("주부로 일합니다.");
    }
}
