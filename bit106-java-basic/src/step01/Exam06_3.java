package step01;
// 부동 소수점의 리터럴 - 2진수로 변경된 것을 확인하기
public class Exam06_3 {
    static float f = 12.375f;
    public static void main(String[] args) {
        System.out.println(12.375f);

    }
}

// 컴파일 후 
// Exam06_3.class 파일을
// VisualStudio code 의 hexdump기능을 이용하여
// 16진수 코드를 확인해보라!
// 중간에 1.375의 2진수 값인 0x41460000을 볼 수 있을 것이다.