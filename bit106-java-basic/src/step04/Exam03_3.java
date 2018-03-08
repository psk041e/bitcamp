//  논리 연산자 : && vs &
package step04;

public class Exam03_3 {
    public static void main(String[] args) {
        boolean a = false;
        boolean b = false;
        boolean r = a && (b = true);
        System.out.printf("a=%b, b=%b. r=%b\n", a, b, r);
        // a가 false이므로 이미 답이 나왔기 때문에 그 뒤의 값은 실행하지 않는다.
        // 효율 연산을 한다.
        // 앞의 값으로 결론을 알수 있으면 뒤의 값은 실행하지 않는다.

        a = false;
        b = false;
        r = a & (b = true);
        System.out.printf("a=%b, b=%b. r=%b\n", a, b, r);
        // a가 false여도 그 뒤의 코드까지 실행한다.
        // 앞의 값으로 결론을 알수 있어도 뒤의 값까지 실행한다.

    }
}

// &&, ||
// - 앞의 피연산자의 값으로 결과를 알 수 있다면 뒤의 명령은 실행하지 않는다.
//
// &, |
// - 앞의 피연산자로 결과를 알 수 있을지라도,
//   뒤에 놓인 명령까지 모두 실행한다.