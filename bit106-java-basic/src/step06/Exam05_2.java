// 메서드 : main() 메서드 - 프로그램 아규먼트
package step06;

public class Exam05_2 {

    // 프로그램 아규먼트d
    // - jvm을 실행할 때 프로그램에 전달하는 값
    // - 예)
    // > java -cp bin Exam05_2 aaa bbb cccc 
    // aaa bbb cccc 가 프로그램 아규먼트이다.
    //
    public static void main(String[] args) {
        // 프로그램 아규먼트는 스트링 배열에 담겨서 main()메서드를 호출할 때
        // 넘어온다.
        // 프로그램 아규먼트는 공백을 기준으로 문자열을 잘라서 배열을 만든다.
        // 
        for (String value : args) {
            System.out.printf("[%s]\n", value);
        }
    }
}
