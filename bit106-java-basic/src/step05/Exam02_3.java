// 흐름 제어문 - switch 문법
package step05;

import java.util.Scanner;

public class Exam02_3 {
    public static void main(String[] args) {
        // switch (값) {}
        // 값으로 가능한 데이터 타입은?
        // => int 정수 (byte, short, int, char), 문자열(jdk7부터 가능),
        // 특별한 상수 Enum 타입
        // (=> byte, short, char값은 int보다 작기 때문에 int값이 될 수 있다.)
        // => case 값으로 변수를 사용할 수 없다. 상수 리터럴만 가능하다.
        // switch문으로 복잡하게 만들바에 if문을 사용해라.
        byte b = 2;
        switch (b) {
        case 1: 
        case 2:
        default:
        }

        short s = 2;
        switch (s) {
        case 1: 
        case 2:
        default:
        }

        // 컴파일 오류
        /*
        long l = 2;
        switch (l) {
        case 1: 
        case 2:
        default:
        }
        */

        char c = 'A'; // A문자의 유니코드 값(UTF-16) 0X41(65)을 c에 저장한다.
                      // 문자를 저장하는 것이 아니라 이진수값을 저장하므로
                      // 정수값이다.
                      // 유니코드 값은 보통 16진수로 표기한다. 
                      // (2진수의 값을 알려주기 위해)
        switch (c) {
        // case 의 값도 int (4byte 정수) 값이면 무엇이든 된다.
        case 'A': // 0x41 = 65
        case 66:
        case 0x43:
        default:
        }

        // String 값을 switch와 case의 값으로 사용할 수 있다.
        String str = "hello";
        switch (str) {
        // case 의 값으로 String 가능하다.
        case "hello":
        case "ohora":
        case "hul":
        default:
        }

        // boolean 값을 switch와 case 에 사용할 수 없다. 
        // (자바에서는 되는언어도 있다.)
        /*
        boolean bool = true;
        switch (boo) {
        case true;
        case false;
        }
        */

        // case에는 리터럴만 올 수 있다.
        // 즉 변수를 사용할 수 없다.
        int x = 1, y = 300;
        switch (x) {
        // case 1 * y: // 컴파일 오류!
        case 1 * 300: // OK -> but long값이 될수 있으므로 쓰지 않는것이 좋다.
        }


    }
}