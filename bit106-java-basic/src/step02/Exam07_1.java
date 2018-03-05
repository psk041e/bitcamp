// 논리값 변수 - 유효한 값 범위

package step02; 


public class Exam07_1 {
    public static void main(String[] args) {
        boolean b1, b2;
        b1 = true; // 실제 메모리에는 1을 저장한다.
        b2 = false; // 실제 메모리에는 0을 저장한다.

        System.out.println(b1);
        System.out.println(b2);

        // 직접 정수 값을 저장하려 해서는 안된다.
        // true, false 대신에 0, 1 정수 값을 저장할 수 없다.
        b1 = 1; // 컴파일 오류!
        b2 = 0; // 컴파일 오류!
        // c는 가능하나 java는 할수 없다. 숫자로 대체할 수 없다.
        // 당연히 boolean값을 연산할수 없다.

    }
}

