// 메서드 분류 - 클래스 변수의 활용 
package step07;


public class ExamY_2 {
    public static void main(String[] args) {
        // 계산 결과를 보곤할 변수는 더이상 필요가 없다.
        // Calculator2 내부에서 계산 결과를 관리한다.
        // int result = 0;
        
        //2 + 3 - 1 * 7 / 3 = ?
        // => 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
        Calculator2.plus(2);
        Calculator2.plus(3);
        Calculator2.minus(1);
        Calculator2.multiple(7);
        Calculator2.divide(3);
        

        System.out.printf("result = %d\n", Calculator2.result);
    
    }
}

// 클래스 문법의 용도?
// 1) 사용자 정의 데이터 타입 만들 때
//    - 즉 새로운 구조의 메모리를 설계할 때 사용한다.
// 2) 메서드를 묶을 때
//    - 서로 관련된 기능을 관리하기 쉽게 묶고 싶을 때 사용한다.