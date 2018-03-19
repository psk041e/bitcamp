// 클래스용도 - 사용자 정의 데이터 타입을 만들 때 사용 
package step07;

public class ExamX_1 {
    public static void main(String[] args) {
        // 사용자 정의 데이터 타입을 사용하는 방법
        // => new 명령을 사용하여 설계도에 기술된 대로 메모리를 준비한다.
        // => 메모리는 Heap 영역에 생성된다.
        // => 메모리 주소를 레퍼런스(주소 변수)에 저장한다.
        Score score = new Score();
        // 레퍼런스가 가리키는 객체 = 그 객체 = Score객체
        // 클래스 이름은 대문자, 그 클래스 객체의 주소를 담을 레퍼런스(변수)를 소문자로 시작한다.
        
        // => 클래스로 만든 메모리는 레퍼런스를 통해 접근한다.
        score.name = "홍길동";
        score.kor = 100;
        score.eng = 90;
        score.math = 85;
        score.sum = score.kor + score.eng + score.math;
//        score.average = (float)score.sum / (float)3;
        score.average = score.sum / 3f; // 암시적 형변환을 해서 float타입 연산을 수행한다.
        // 형변환 예제 찾아보기
        // 자바는 byte변수와 byte변수를 연산하면 int가 나온다.
        // byte를 연산하기 전 임시메모리 int를 만들어서 연산을 한다.
        // 자바는 최소 연산단위가 int이다.
        // long과 float을 연산할 때 조심해야 한다.
        // => long은 8byte 정수형이지만 float과 연산하게되면 소수점값이 잘릴수 있으므로
        //    long형을 오히려 4byte 부동소수점 타입으로 임시메모리를 만들어서 연산을 수행한다.
        //    그래서 원래의 long형의 메모리가 더 크기 때문에 값이 달라질수 있다.

        // 클래스로 묶은 메서드를 사용하는 방법
        // => 클래스 이름을 붙여 메서드를 호출한다.

        System.out.printf("%s, %d, %d, %d, %d, %.1f\n",
                score.name, score.kor, score.eng, score.math, score.sum, score.average);  
    }
}

// 클래스 문법의 용도?
// 1) 사용자 정의 데이터 타입 만들 때
//    - 즉 새로운 구조의 메모리를 설계할 때 사용한다.
// 2) 메서드를 묶을 때
//    - 서로 관련된 기능을 관리하기 쉽게 묶고 싶을 때 사용한다.