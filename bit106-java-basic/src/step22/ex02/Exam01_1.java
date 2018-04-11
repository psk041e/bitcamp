// character stream - 문자 단위로 출력하기
package step22.ex02;

import java.io.FileWriter;

public class Exam01_1 {
    public static void main(String[] args) throws Exception {
        // 1) 문자 단위로 출력할 도구 준비
        FileWriter out = new FileWriter("temp/test1.data");
        
        // 2) 문자 출력하기
        // => 자바는 문자 데이터를 다룰 때 UTF-16(2바이트) 유니코드를 사용한다.
        // => 그래서 출력할 때 UTF16 2 바이트 유니코드값을 출력한다.
        out.write(0xAC06bac0); // 파라미터 타입은 int이지만 1바이트를 출력한다.
        
        out.close();
        
        System.out.println("출력 완료!");
    }
}
