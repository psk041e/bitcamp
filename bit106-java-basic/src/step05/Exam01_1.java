// 흐름 제어문 - 조건문 if
package step05;

public class Exam01_1 {
    public static void main(String[] args) {
        int age = 17;

        // 1) if (조건) 문장;
        if (age >= 19) System.out.println("성인이다.");

        // => 문장을 다음 줄에 놓는 경우가 많다.
        if (age >= 19); // if  문에 빈 문장을 넣을 수 있다. 
            System.out.println("성인이다.");
        // 이런 경우 개발자가 오해할 수 있다.
        // if (조건) 뒤에 문자의 끝을 표시하는 세미콜론을 사용하지 않도록 조심하라!
        // 컴파일러가 에러를 띄우지않는다. 
        // 빈문장이라는 뜻으로 그 뒤의 문장과 상관이 없게된다.

    }
}