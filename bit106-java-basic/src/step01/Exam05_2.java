package step01;
// 정수의 리터럴 - 자릿수 표기
public class Exam05_2 {
    public static void main(String[] args) {
        // _를 사용하여 읽기 쉽도록 숫자의 자릿수를 표시할 수 있다.
        // 물론 위치는 작성자 마음이다
        System.out.println(12783406);
        System.out.println(1278_3406);
        System.out.println(12_783_406);

        // 2진수
        // - 0b 또는 0B로 시작한다.
        System.out.println(0b1100100);
        System.out.println(0b110_0100);
        System.out.println(0b1_100_100);
    }
}