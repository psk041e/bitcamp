// 클래스 사용 - 패키지 클래스 사용
package step03;

public class Exam04_1 {
    public static void main(String[] args) {

        // 바깥 쪽에 별도 선언한 클래스를 사용하기
        Score s1 = new Score();
        // Score클래스가 없으면 자바 컴파일러가 찾지 못해 컴파일에러가 난다!
        // Score가 컴파일된 경로를 알려줘야 한다.
        // javac -encoding utf8 -d bin -cp bin src/step03/Exam04_1.java
        s1.name = "홍길동";
        System.out.println(s1.name);

    }
}

// Exam04_1.java 컴파일 오류1
// - 다음 명령을 사용하여 소스 파일을 컴파일하려 하면
//   Score 클래스를 찾을 수 없다고 오류가 발생할 것이다.
//   >javac -encoding utf8 -d bin src/step03/Exam04_1.java
// - 이유?
//   Exam04_1.java 에서 Source 클래스를 사용하는데,
//   컴파일할 때 Score 클래스 정보가 필요하다.
//   그런데 컴파일러가 Score 클래스에 대한 정보를 모르기 때문에
//   Exam04_1.java를 제대로 컴파일 할 수 없는 것이다.
// - 해결책?
//   컴파일러에게 Score 클래스에 대한 정보를 알려줘라!
// 방법1) Source.class 파일을 갖고 있다면 그 파일이 있는 위치를 알려줘라.
// > javac -encoding utf8 -d bin -cp bin src/step03/Exam04_1.java
//                          (Source를 컴파일해야 가능하다.)
//
// 방법2) Score 클래스의 소스 파일을 갖고 있다면 소스 파일의 위치를 알려줘라.
//  > javac -encoding utf8 -d bin -sourcepath src src/step03/Exam04_1.java
//    (Source를 컴파일해주지 않아도 알아서 해준다. 경로는 패키지 이전의 폴더)
//
// 언제 이렇게 해야 하는가?
// - 자바에서 기본으로 제공하는 클래스가 아닌 다른 클래스를 사용할 때!