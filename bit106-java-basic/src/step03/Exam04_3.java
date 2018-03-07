// 클래스 사용 - public 클래스와 기본 클래스
package step03;

public class Exam04_3 {
    public static void main(String[] args) {
        // 다른 패키지의 클래스 사용

        // => A 클래스는 public 이 아니다.
        // => 따라서 다른 패키지의 클래스는 A를 사용할 수 없다.
        // step03.test.A v1; // 컴파일 오류!

        step03.test.B v2;

    }
}