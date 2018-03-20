// 메서드 분류 - 인스턴스 변수
package step07;


public class ExamY_4 {
    public static void main(String[] args) {
        // 각각의 계산 결과를 개별적으로 관리하고 싶은가?
        // 그렇다면 개별적으로 관리 할 변수를 인스턴스 변수로 선언하라!
        
        // 다음 두 개의 식을 분리하여 계산해보자
        // 식1) 2 + 3 - 1 * 7 / 3 = ?
        // 식2) 3 * 2 + 7 / 4 - 5 = ?
        // => 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
        
        // 두 개의 식의 계산 결과를 따로 관리하기 위해서는
        // result 변수를 개별적으로 생성해야 한다.
        Calculator3 c1 = new Calculator3(); // 식1의 계산결과를 보관할 메모리 준비
        Calculator3 c2 = new Calculator3(); // 식2의 계산결과를 보관할 메모리 준비
        
     // 계산을 수행할 때 계산 결과를 보관할 메모리를 전달하라!
        Calculator3.plus(c1, 2);        // + 2
        Calculator3.plus(c2, 3);        // + 3
        
        Calculator3.plus(c1, 3);        // + 2 + 3
        Calculator3.multiple(c2, 2);    // + 3 * 2
        
        Calculator3.minus(c1, 1);       // + 2 + 3 - 1
        Calculator3.plus(c2, 7);        // + 3 * 2 + 7
        
        Calculator3.multiple(c1, 7);    // + 2 + 3 - 1 * 7
        Calculator3.divide(c2, 4);       // + 3 * 2 + 7 / 4 
        
        Calculator3.divide(c1, 3);      // + 2 + 3 - 1 * 7 / 3 = ?
        Calculator3.minus(c2, 5);       // + 3 * 2 + 7 / 4 - 5 = ?

        // 식1의 계산 결과는 c1 인스턴스의 result에 들어 있고,
        // 식2의 계산 결과는 c2 인스턴스의 result에 들어 있다.
        System.out.printf("c1.result = %d\n", c1.result);
        System.out.printf("c2.result = %d\n", c2.result);
    }
}

// 클래스 문법의 용도?
// 1) 사용자 정의 데이터 타입 만들 때
//    - 즉 새로운 구조의 메모리를 설계할 때 사용한다.
// 2) 메서드를 묶을 때
//    - 서로 관련된 기능을 관리하기 쉽게 묶고 싶을 때 사용한다.