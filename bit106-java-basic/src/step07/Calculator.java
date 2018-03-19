// 메서드 분류
// => 관련된 기능을 수행하는 메서드를 한 그룹으로 묶는다.
package step07;

public class Calculator {
    public static int plus(int a, int b) {return a + b;} // 인스턴스 주소를 받아서 사용하지 않기 때문에 static메소드로 만들었다.
    public static int minus(int a, int b) {return a - b;}
    public static int multiple(int a, int b) {return a * b;}
    public static int divide(int a, int b) {return a / b;}
}
