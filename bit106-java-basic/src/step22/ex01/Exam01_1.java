// Byte Stream - 바이트 단위로 출력하기
package step22.ex01;

import java.io.FileOutputStream;

public class Exam01_1 {
    public static void main(String[] args) throws Exception {
        //1) 파일로 데이터를 출력하는 객체를 준비한다.
        FileOutputStream out = new FileOutputStream("temp/test1.data");
        // 윈도우는 '/'와 '\\'을 사용한다. 
        // 역슬래시는 하나만 쓰면 안된다.(특별한 의미를 지니기 때문에 두개를 적어주어야 한다.)
        
        // 2) 1바이트를 출력한다.
        // => int 값을 아규먼트로 넘기더라도 맨 마지막 1바이트만 출력한다.
        out.write(0x7a6b5c4d); // 출력하는 값은 0x4d이다.
        
        // 자바는 c++ 이후에 나온 언어이다.
        // c++는 c 이후에 나온 언어이다.
        // c에서 입출력 -> read, write의 기본 파라미터 타입 int
        // 과거 c에서의 호환성을 위해서 byte를 사용하지 않고 그냥 int를 사용한다.
        
        // 3) 출력 도구를 닫는다.
        // => ★★ 항상 입출력 도구를 사용한 후 닫아야 한다.★★
        // => 어떤 입출력 도구는 닫지 않으면 버퍼(임시메모리)에 남아있는 데이터가
        //    출력되지 않고 버려진다.
        out.close();
        
        System.out.println("데이터 출력 완료!");
    }
}
