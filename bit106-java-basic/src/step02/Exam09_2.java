// 배열 - 배열 초기화

package step02; 

public class Exam09_2 {
    public static void main(String[] args) {
        // 배열 선언
        int i1, i2, i3, i4, i5;

        // 배열 선언
        int[] arr1 = new int[5]; //OK!

        // 배열 메모리를 0으로 초기화
        arr1[0] = 0;
        arr1[1] = 0;
        arr1[2] = 0;
        arr1[3] = 0;
        arr1[4] = 0;

        // 배열 선언 과 초기화를 한 번에 하기
        //  int arr2[] = new int[5]{0, 0, 0, 0, 0};
        // => 배열 개수 지정. 문법오류!

        // 1) 배열 선언 + 초기화 명령
        int arr2[] = new int[]{0, 0, 0, 0, 0}; //OK!
        int arr3[] = {0, 0, 0, 0, 0}; //OK!

        // 2) 배열 선언 ==> 초기화 명령
        int[] arr4;
        arr4 = new int[]{0, 0, 0, 0, 0};

        int[] arr5;
        // 배열 변수를 선언한 후 따로 초기화 시킬 때는
        // 다음과 같이 new 명령을 생략할 수 없다.
        arr5 = {0, 0, 0, 0, 0}; // 컴파일 오류!


    }
}

// 배열 초기화 명령
// 1) 배열 선언 + 초기화
//    데이터타입[] 변수명 = new 데이터타입[]{값, 값, 값};
//    - 배열 메모리를 초기화시킬 때는 배열 개수를 지정해서는 안된다.
//    - 배열을 초기화시키는 값의 개수 만큼 메모리가 만들어진다.
//    - 즉 다음은 값 개수만큼 int 메모리가 3개가 생성된다.
//    ex) int[] arr = new int[]{10, 20, 30};
//    - 다음과 같이 new 명령을 생략할 수 있다.
//    데이터타입[] 변수명 = {값, 값, 값};
//
//
// 2) 배열 선언 후 따로 배열 초기화 문장 실행
//    데이터타입[] 변수명;
//    변수명 = new 데이터타입[]{값, 값, 값};
//    ex)
//    int[] arr1;
//    