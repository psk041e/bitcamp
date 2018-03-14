// 메서드 : 개념 및 기본 문법 VI
package step06;

import java.util.Scanner;

public class Exam02_3 {

    // 3) 메서드1 : 리턴값(O), 파라미터(X)
    // => 메서드 블록을 실행한 후 값을 리턴하는 메서드.
    //    메서드 정의할 때 어떤 값을 리턴하는 지 그 타입을 적어야 한다.
    //    메서드에서도 종료하기 전에 반드시 그 타입의 값을 리턴해야 한다.
    // => 리턴 타입은 반드시 한 개만 가능하다.
    //  ****만약 여러 개의 값을 리턴하고 싶다면, 배열에 담거나 객체에 담아 리턴하라!**
    // => "손들어, 돈내놔!"

    static String hello() {
        // 값을 리턴하는 문법 => return 값;
        return "안녕하세요!";
    }
    
    public static void main(String[] args) {

        // hello() 메서드를 실행하고, 그 리턴 값을 변수에 담는다.
        String r = hello();
        System.out.println(r);

        // 메서드가 값을 리턴한다고 해서 반드시 그 값을 변수에 받아야 하는 것은 아니다.
        // 변수에 받을 지 여부는 호출하는 쪽의 마음!!
        hello(); // -> 값을 받을 변수가 없다 -> ** 리턴값은 버려진다!!!! **
        //                                  -> 반드시 받을 필요 없다.

        // 리턴 타입과 다른 타입의 변수로 값을 받으려 하면 컴파일 오류!
        // int r2 = hello(); // 컴파일 오류!!

    }
}
