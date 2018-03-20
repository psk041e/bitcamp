// 메서드 분류 - 인스턴스 변수 사용
// => 관련된 기능을 수행하는 메서드를 한 그룹으로 묶는다.
package step07;

public class Calculator3 {
    // 인스턴스 변수
    // => 작업 결과를 개별적으로 관리하고 싶을 때 인스턴스 변수로 선언한다.
    // => 인스턴스 변수는 클래스가 로딩 될 때 만들어지지 않는다.
    // => new 명령을 사용해서 만들어야 한다.
    // => 변수 선언 앞에 static이 붙지 않는다.
    int result = 0; // 계산을 동시에할수 있다. -> 계산 결과를 따로따로 관리할 수 있다.
    
    // 인스턴스 변수를 다루는 메서드는 작업을 수행할 때 그 인스턴스 주소를 받아야 한다.
    public static void plus(Calculator3 calc, int value) { // 인스턴스 주소를 사용하지 않기 때문에 static을 뗄 필요가 없다.
        // result는 더이상 클래스 변수가 아니기 때문에 직접 접근할 수 없다.
        // 오직 인스턴스 주소를 통해서만 접근 할 수 있다.
        calc.result += value;
    }
    public static void minus(Calculator3 calc, int value) {
        calc.result -= value; 
    }
    public static void multiple(Calculator3 calc, int value) {
        calc.result *= value; 
    }
    public static void divide(Calculator3 calc, int value) {
        calc.result /= value; 
    }
}
