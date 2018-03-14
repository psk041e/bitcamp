// 메서드 : 개념 및 기본 문법 IV
package step06;

import java.util.Scanner;

public class Exam02_4 {

    // 4) 메서드1 : 리턴값(O), 파라미터(O)
    // => "이 돈 갖고 과자좀 사와!"

    static String hello(String name, int age) {
        String retVal = String.format("%d살 %s님을 환영합니다!", age, name);
        // format : 메서드이다. 세개를 메서드가 받아서 내부적으로 문자열을 만들어서
        //          그 문자열을 리턴시킨다.
        //          화면 출력이 아니라 문자열을 리턴해준다. -> 값을 그 자리에 놓는다.
        return retVal;
    }
    
    public static void main(String[] args) {

        // hello() 메서드를 실행하고, 그 리턴 값을 변수에 담는다.
        String r = hello("홍길동", 20);
        System.out.println(r);
        // 리턴값은 받기 싫으면 받지 않아도 된다. -> 버려지게 된다.

        // 리턴 값을 안 받아도 된다.
        hello("임꺽정", 30); // 리턴값은 버려진다.


    }
}
