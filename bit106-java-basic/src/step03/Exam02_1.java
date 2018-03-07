// 레퍼런스 배열 - 사용전
package step03;

public class Exam02_1 {
    public static void main(String[] args) {
        // 여러 개의 인스턴스 주소 저장하기

        class Score {
            String name;
            int kor;
            int eng;
            int math;
            int sum;
            float aver;
        }

        // Score 레퍼런스를 여러개 준비한다.
        Score s1, s2, s3;

        // 각 레퍼런스에 인스턴스를 만들어 주소를 저장한다.
        s1 = new Score();
        s2 = new Score();
        s3 = new Score();

        // 레퍼런스를 이용하여 인스턴스에 접근한 다음에 항목에 값 넣는다.
        s1.name = "홍길동";
        s2.name = "임꺽정";
        s3.name = "유관순";

        // 레퍼런스를 통해 인스턴스에 각 항목 값을 꺼낸다.
        System.out.printf("이름 : %s\n", s1.name);
        System.out.printf("이름 : %s\n", s2.name);
        System.out.printf("이름 : %s\n", s3.name);

    }
}

// 클래스(class)
// - 여러 타입을 묶어서 사용자 정의 데이터 타입을 만드는 문법이다.
// - 관련된 기능(메서드, 함수)을 관리하기 편하게 묶는 문법이다.
//     몇백개, 몇천개의 낱개의 변수를 다루면 다루기가 굉장히 어렵다.
//     관리하기 좋으라고, 다루기 좋으라고 묶어서 놓는다.
// 이 두가지 이유로 사용을 한다.
//
// 배열(array)
// - 단일한 타입의 메모리를 묶는 문법이다.
//
// primitive 변수와 레퍼런스
// - primitice type(byte, short, int long, float, double, boolean, char)의
//   메모리를 만들 때 변수 선언 만으로 완료된다.
//   변수 이름이 곧 메모리를 가리키는 이름이 된다.
//   예) int age;
// - class(사용자 정의 데이터 타입)으로 메모리를 만들 때는
//   반드시 new 명령을 사용해야 한다.
// - 메모리를 만든 후에는 그 주소를 변수에 저장해서 메모리를 사용한다.
//   예) Score s; <==== 메모리의 주소를 저장하는 변수
//       s = new Score(); <=== 메모리를 확보한 후 그 주소를 s에 저장.
//
// 인스턴스의 항목 접근하기
// - 문법
//   레퍼런스명.항목명 = 값;


