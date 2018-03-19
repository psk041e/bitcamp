package step01;
// 정수의 리터럴 - 크기
public class Exam05_3 {
    public static void main(String[] args) {
        // 정수를 표기할 때
        // 크기에 따라 표기 방법이 다르다.
        // 그냥 작성하면 4바이트 크기의 정수를 의미한다.
        System.out.println(2147483647); // 4바이트 양의 정수 최대값
        System.out.println(-2147483648); // 4바이트 음의 정수 최소값

        // 4바이트를 초과하면 컴파일 오류이다.
        // => 숫자가 1 증가하면 4바이트 메모리가 넘치기 때문에 오류이다
        // System.out.println(2147483648); // 4바이트 양의 정수 최대값
        // System.out.println(-2147483649); // 4바이트 음의 정수 최소값

        // 해결방법
        // => 4바이트 메모리보다 더 큰 메모리로 숫자를 저장하라고 명령을 내려라!
        // => 숫자뒤에 L, ㅣ을 붙여라!
        System.out.println(2147483648L);
        System.out.println(-21474836491L);

        // 8바이이트 정수 최대값 및 최소값
        // => 자바에서는 각 데이터 유형에 따라 최대, 최속 값을 받아볼수 있도록
        //    특별한 명령을 제공한다       
        System.out.println(Integer.MAX_VALUE); // 4자리트로 표현할수 있는 정수 최대
 



    }
}