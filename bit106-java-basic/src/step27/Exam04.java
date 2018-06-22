// 람다(lambda) - 파라미터와 리턴 값이 있는 람다
package step27;

public class Exam04 {
    
    static interface Calculator {
        int compute(int a, int b);
    }
    
    static void test(Calculator c) {
        System.out.println(c.compute(100, 200));
    }
    
    public static void main(String[] args) {
        
        // 파라미터와 리턴 값이 있는 메서드 구현하기
        // 람다 표현식 사용
        test((a, b) -> a + b); // a와 b를 받아서 a와 b을 터한값을 리턴한다.
        
        // 위의 람다 표현식은 다음 익명 클래스와 같은 의미다.
        // 익명 클래스 사용
        test(new Calculator() {
            public int compute(int a, int b) {
                return a + b;
            }
        });
        
        // 여러 문장을 실행하는 경우 블록 {}으로 감싸라!
        // 자바도 스크립트 류의 언어처럼 간결하기 위해서 이와 같은 문법을 만든다.
        // 자바도 arrow function같은 것이 있다는것만 기억하면 된다.
        test((a, b) -> {
            int sum = 0;
            for (int i = a; i <= b; i++) {
                sum += i;
            }
            return sum;
        });
        // 위의 람다 표현식은 다음 익명 클래스와 같은 의미다.
        test(new Calculator() {
            public int compute(int a, int b) {
                int sum = 0;
                for (int i = a; i <= b; i++) {
                    sum += i;
                }
                return sum;
            }
        });
        
    }

}







