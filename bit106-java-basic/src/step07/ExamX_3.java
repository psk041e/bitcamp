// 사용자 정의 데이터 타입 - 인스턴스 메서드 
package step07;


public class ExamX_3 {
    public static void main(String[] args) {
        // 사용자 정의 데이터 타입의 값을 연산자를 사용하여 다뤄보자!
        Score3 score = new Score3();
        score.name = "홍길동";
        score.kor = 100;
        score.eng = 90;
        score.math = 85;
        
        // 다음은 Score의 값을 다루기 위해 non-instance 메서드를 호출하는 예이다.
        // non-instance 메서드 = static 메서드 = 클래스 메서드
        /* 
        Score3.calculator(score);
        */

        // 클래스 메서드를 사용할 때마다 매번 인스턴스의 주소를 파라미터로 넘겨줘야 했다.
        // 그러나 인스턴스 메서드를 사용하면 인스턴스 주소를 넘기기가 더 편하다.
        // 메서드 호출 앞에다 둔다.
        // 훨씬 소스 코드의 목적을 이해하는데 직관적이다.
        score.calculator(); // 변수 뒤에 연산자를 주는 i++ 의 예와 비슷하다.  
        // score에 들어있는 인스턴스 주소는 내장변수 this에 자동 저장된다.
        // static메소드는 this라는 변수가 존재하지 않는다. -> 이 메소드는 인스턴스를 넘길수 없기 때문
        // 훨씬 더 직관적으로 메소드를 사용할 수 있다.
        
        System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
                score.name, score.kor, score.eng, score.math, score.sum, score.average);  
    }
}

// 사용자 정의 데이터 타입에서
// 인스턴스의 값을 다루는 연산자를 정의할 때는
// 인스턴스 메서드로 만드는 것이 사용하기 편하다!
// (사용자 정의 타입을 만드는 경우 인스턴스 메서드를 쓰는 경우가 많다.)

