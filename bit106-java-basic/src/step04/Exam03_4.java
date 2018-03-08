//  논리 연산자 : || vs |
package step04;

public class Exam03_4 {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        boolean r = a || (b = true);
        System.out.printf("a=%b, b=%b. r=%b\n", a, b, r);

        a = true;
        b = false;
        r = a | (b = true);
        System.out.printf("a=%b, b=%b. r=%b\n", a, b, r);
        // a가 false여도 그 뒤의 코드까지 실행한다.
        // 앞의 값으로 결론을 알수 있어도 뒤의 값까지 실행한다.

    }
}
