// 버퍼 사용 전 - 파일 복사 및 시간 측정
package step22.ex05;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam02_1 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/jls8.pdf");
        FileOutputStream out = new FileOutputStream("temp/jls8_2.pdf");
        
        int b;
        
        long startTime = System.currentTimeMillis(); // 밀리초
        
        while ((b = in.read()) != -1) {
            out.write(b);
        }; // 파일을 끝까지 읽는다.
        
        long endTime = System.currentTimeMillis();
        
        System.out.println(endTime - startTime);
        
        in.close();
        out.close();
    }
}

