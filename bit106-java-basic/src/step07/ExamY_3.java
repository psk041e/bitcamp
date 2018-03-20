// 메서드 분류 - 클래스 변수의 단점
package step07;


public class ExamY_3 {
    public static void main(String[] args) {
        // 클래스 변수는 오직 한 개만 존재하기 때문에
        // 동시에 여러개의 작업을분리하여 진행할 수 없다.
        
        // 다음 두 개의 식을 분리하여 계산해보자
        // 식1) 2 + 3 - 1 * 7 / 3 = ?
        // 식2) 3 * 2 + 7 / 4 - 5 = ?
        // => 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
        
        // Calculator2에서는 계산 결과를 저장하는 변수가 한개여서
        // 식1과 식2를 개별적으로 동시에 계산할 수 없다.
        Calculator2.plus(2);        // + 2
        Calculator2.plus(3);        // + 3
        
        Calculator2.plus(3);        // + 2 + 3
        Calculator2.multiple(2);    // + 3 * 2
        
        Calculator2.minus(1);       // + 2 + 3 - 1
        Calculator2.plus(7);        // + 3 * 2 + 7
        
        Calculator2.multiple(7);    // + 2 + 3 - 1 * 7
        Calculator2.divide(4);       // + 3 * 2 + 7 / 4 
        
        Calculator2.divide(3);      // + 2 + 3 - 1 * 7 / 3 = ?
        Calculator2.minus(5);       // + 3 * 2 + 7 / 4 - 5 = ?

        // Calculator2의 result 변수는 한 개이기 때문에
        // 결과를 출력하면 식1과 식2가 모두 계산된 결과가 출력될 것이다.
        System.out.printf("result = %d\n", Calculator2.result);  
    }
}

// 클래스 문법의 용도?
// 1) 사용자 정의 데이터 타입 만들 때
//    - 즉 새로운 구조의 메모리를 설계할 때 사용한다.
// 2) 메서드를 묶을 때
//    - 서로 관련된 기능을 관리하기 쉽게 묶고 싶을 때 사용한다.