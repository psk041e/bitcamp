// 흐름 제어문 - switch 문법 II
package step05;

import java.util.Scanner;

// 상수를 좀 더 조직적으로 관리하는 방법
// => enum을 사용하여 상수를 정의한다.
enum Level {
    GUEST2, MEMBER2, ADMIN2
}


public class Exam02_4 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("사용자 레벨: ");
        int level = keyScan.nextInt();

        // 상수를 사용하지 않았을 때
        // => 값의 의미를 주석으로 달아야만 다른 개발자가 이해할 수 있다.
        switch (level) {
        case 0: // 손님
            System.out.println("조회만 가능합니다.");
            break;
        case 1: // 일반회원
            System.out.println("글작성 가능합니다.");
            break;
        case 2: // 관리자
            System.out.println("다른 회원의 글도 변경, 삭제할 수 있습니다.");
            break;
        }


        // 상수를 사용하면 주석없이 바로 이해할 수 있다.
        // 값을 직접 넣기보다는 그 값을 변수에 담아놓는다.
        // 단순히 조회하는 용도로 사용하기 위해 final을 사용, 변수의 값을 바꿀수 없다.

        final int GUEST = 0, MEMBER = 1, ADMIN = 2;
        switch (level) {
        case GUEST:
            System.out.println("조회만 가능합니다.");
            break;
        case MEMBER:
            System.out.println("글작성 가능합니다.");
            break;
        case ADMIN:
            System.out.println("다른 회원의 글도 변경, 삭제할 수 있습니다.");
            break;
        case 2100000000 * 7: // 계산식을 case에 쓰지 말아라
        }

        

        // enum으로 정의된 상수를 사용하려면,
        // enum타입의 변수를 선언해야 한다.
        // => final int처럼 직접 값을 지정하지 않아도 된다.
        // => 값을 직접 지정할 수도 있다.(나중에 따로 enum 문법에서 설명)
        
        // enum을 사용하는 주된 이유는?
        // 값을 직접 => 100, 200, "admin" 과 같이 작업을 직접 지정할 필요가 없다.
        // enum 변수에는 그 타입에 정의된 값만 저장할 수 있다.
        Level userLevel = Level.MEMBER2;

        // 다음과 같이 switch나 case 값으로 enum 타입의 값이 올 수 있다.
        switch (userLevel) {
        case GUEST2:
            System.out.println("조회만 가능합니다.");
            break;
        case MEMBER2:
            System.out.println("글작성 가능합니다.");
            break;
        case ADMIN2:
            System.out.println("다른 회원의 글도 변경, 삭제할 수 있습니다.");
            break;
        }

        
    }
}

// if vs switch (흐름제어문 - 조건문)
// => 복잡한 조건으로 프로그램 흐름을 제어해야 하는 상황이라면
//    if문을 사용하라!
// => int나 문자열처럼 단순한 값으로 프로그램을 제어할 수 있다면,
//    switch문을 사용하는게 낫다.
