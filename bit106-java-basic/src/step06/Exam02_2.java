// 메서드 : 개념 및 기본 문법 II
package step06;

import java.util.Scanner;

public class Exam02_2 {

    // 2) 메서드1 : 리턴값(X), 파라미터(O)
    // => 메서드 블록을 실행할 때 값이 필요하다면 파라미터 변수를 선언 하라!
    // => "여기 돈 줄테니 밥먹고 와!", "여기 등록금이다. 학비 내라."

    static void  hello(String name, int age) {
        // 파라미터란?
        // - 메서드를 실행할 때 사용할 값을 외부로부터 받기 위해 선언한 "로컬 변수"
        // - 메서드를 실행할 때 생성되고 메서드 실행이 끝나면 제거된다!!!!
        //   => hello 라는 메서드가 실행될때 변수가 생성되고 
        //      hello 메서드가 종료되면 변수는 사라진다.
        //   => 메모리를 확보했다가 없앤다. (그 메모리를 쓸 수 있도록 확보한다)
        //      -> 다시 그것을 다른 용도로 쓸 수 있도록 해제시킨다.
        System.out.printf("%d살, %s님 반갑습니다.\n", age, name);
        // printf -> c의 printf를 흉내낸것 (c가 먼저 나왔기 때문)
    }
    
    public static void main(String[] args) {

        System.out.println("main() 11111");

        // hello 메서드 호출하기
        hello("홍길동", 20);
        // hello 메서드 실행이 완료되면 다시 이곳으로 돌아와서 다음 명령 실행

        
        // 메서드는 언제든 필요할 때마다 반복하여 실행할 수 있다!
        System.out.println("main() 22222");
        hello("임꺽정", 30);

        
        System.out.println("main() 33333");
        hello("유관순", 16);

        System.out.println("main() 44444");

        // 파라미터의 타입, 개수, 순서가 일치해야 한다.
        // hello("윤봉길"); // 컴파일 오류!!
        // required: String,int
        // found: String
        // 요구 되는 것은 두개의 갑인데 하나의 값밖에 찾을 수 없다.

        // hello(20, "윤봉길"); // 컴파일 오류!!
        // String r = hllo("안중근", 30); // 컴파일 오류!!
        // void r = hello("안중근", 30);; // 컴파일 오류!!
    }
}

// 아규먼트(argument) -> (한자로) 인자, 요소
// => 메서드를 호출할 때 넘겨주는 값
// => 예) hello("홍길동", 20);
//     "홍길동", 20 이 아규먼트!
// 
// 파라미터(parameter)
// => 아규먼트를 받는 변수
// => 예) void hello(String name, int age) {...}
//     name, age 가 아규먼트!
//
// 현장에서는 "아규먼트"와 "파라미터"를 구분하지 않는다.