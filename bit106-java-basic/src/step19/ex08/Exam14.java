// IoC 컨테이너 만들기 - 의존 객체 자동 주입
package step19.ex08;

public class Exam14 {
    public static void main(String[] args) throws Exception {
        ApplicationContext9 iocContainer = new ApplicationContext9("step19.ex8");
        Car2 car2 = (Car2) iocContainer.getBean("step19.ex8.Car2");
        car2.move();
    }
}

// DI는 IoC의 한 예이다.
//
// IoC(Inversion of Control)?
// => 제어의 역행.
// => 일반적인 흐름에서 벗어난 동작을 말한다.(흐름을 역행)
// => 예:
//      1) Dependancy Injection(DI)
//         => 자신이 사용할 의존 객체를 자신이 만들지 않고 외부에서 주입 받는 것.
//          (보통 이것을 IoC라고 말한다.)
//      2) Event
//         => 실행 순서에 상관없이 특정 사건이 발생하면 지정된 코드가 실행되는 것.





