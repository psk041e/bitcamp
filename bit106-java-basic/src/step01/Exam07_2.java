package step01;
// 문자의 리터럴 - 크기
public class Exam07_2 {
    public static void main(String[] args) {
        
        // 문자(영어, 한글, 한자 상관없이)는 2바이트 메모리를 사용한다.
        // 문자 코드는 음수가 없으므로, 
        // 0 ~ 65535까지의 크기를 갖는다
        System.out.println(0x41);
        // c -> byte별로 관리
        // java -> char로 관리


    }
}