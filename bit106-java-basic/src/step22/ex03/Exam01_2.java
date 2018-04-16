// 데이터 읽기 - int 값 읽기 
package step22.ex03;

import java.io.FileInputStream;

public class Exam01_2 {

    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/test3.data");
        
        // Exam02_1을 실행하여 출력한 데이터를 read()로 읽는다. 
        // read()는 1바이트를 읽어 int 값으로 만든 후 리턴한다.
        int value = in.read(); // 실제 리턴한 값은 0x08이다.
        
        in.close();
        
        System.out.printf("%x\n", value);
    }
}






