// 메서드 분류 - 클래스 변수 사용
// => 관련된 기능을 수행하는 메서드를 한 그룹으로 묶는다.
package step07;

public class Calculator2 {
    // 이 클래스에 들어있는 메서스들의 작업 결과를 보관할 변수를 준비한다.
    // => 클래스 변수는 new 명령으로 생성하는 것이 아니라
    //    클래스가 메모리에 로딩되면 자동으로 "Method Area" 영역에 생성된다.
    static int result = 0;
    
    // 클래스의 용도(객체지향 분석설계 설명)
    // 사용자 정의타입을 만든다, 메소드를 추가한다.
    // 메소드를 관리하기 좋게끔 묶는다.
    
    
    
    
    // 작업 결과를 리턴하지 않고 내부변수(클래스 변수)에 보관한다. => 바깥에서 따로 결과를 다룰 필요가 없다.
    // 다음 메소드는 작업 결과를 클래스 변수에 보관한다.
    public static void plus(int value) { // 인스턴스의 주소를 사용하지 않기 때문에 static을 뗄 필요가 없다.
        result += value; // result = result + value;
    }
    public static void minus(int value) {
        result -= value; // result = result - value;
    }
    public static void multiple(int value) {
        result *= value; // result = result * value;
    }
    public static void divide(int value) {
        result /= value; // result = result / value;
    }
}
