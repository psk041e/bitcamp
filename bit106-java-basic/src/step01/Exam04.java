package step01;
// 리터럴(literal)
public class Exam04 {
    public static void main(String[] args) {
        // 숫자

        // 정수
        // => 4바이트 크기의 정수
        System.out.println(10);
        System.out.println(+10);
        System.out.println(-10);
        
        // => 8바이트 크기의 정수
        // 숫자 뒤에 l, L을 붙인다
        System.out.println(10l);
        System.out.println(+10L);
        System.out.println(-10L);

        // 부동소수점(점이 떠다니면서 움직인다, 부양한다)
        // 4바이트 크기
        // 숫자뒤에 f, F를 붙인다
        System.out.println(3.14f);
        System.out.println(3.14F);

        // => 8바이트 크기의 정수
        // 위아래 값이 같다
        System.out.println(3.14);
        System.out.println(31.4e-1);    // 3.14 * 10의-1승


        // 문자열
        System.out.println("오호라!");

        // 한 개의 문자
        System.out.println('가');

        // 논리값
        System.out.println(true);
        System.out.println(false);
    
    }
}