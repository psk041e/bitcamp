// 레퍼런스와 인스턴스 - 인스턴스 주소 주고받기
package step03;

public class Exam03_2 {
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

        // Score 레퍼런스 선언 + 인스턴스 생성(사용할 메모리 확보)
        Score s1 = new Score();

        // s1에 저장된 주소를 s2에도 저장한다.
        // s1에 저장된 주소값과 s2에 저장된 주소값이 같기 때문에
        // 같은 메모리 공간을 가리킨다.
        // 따라서 s1레퍼런스의 주소값이 가리키는 인스턴스의 
        // name항목에 값을 넣어 주었기 때문에
        // 같은 주소값을 가리키는 s2의 name항목의 값은
        // 당연히 같은 값을 가지게 된다.
        Score s2 = s1;

        s1.name = "홍길동";

        System.out.println(s2.name);

    }
}