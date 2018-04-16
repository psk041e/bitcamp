// BufferedInputStream과 
package step22.ex07;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam02_2 {
    public static void main(String[] args) throws Exception {
        // 파일 읽는건 FileInputStream이, 버퍼에 담아두는건 BufferedInputStream이 한다.
        FileInputStream fileIn = new FileInputStream("temp/jls8.pdf");
        // 장신구, 플러그인 버퍼에 담는 일을 한다.
        BufferedInputStream in = new BufferedInputStream(fileIn);
        
        // 파일 읽는건 FileInputStream이, 버퍼에 담아두는건 BufferedInputStream이 한다.
        FileOutputStream fileOut = new FileOutputStream("temp/jls8_4.pdf");
        BufferedOutputStream out = new BufferedOutputStream(fileOut); 
        
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

