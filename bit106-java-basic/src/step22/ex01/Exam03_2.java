// Byte Stream - 읽은 데이터를 바이트 배열의 특정 위치에 저장하기
package step22.ex01;

import java.io.FileInputStream;

public class Exam03_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/test1.data");
        
        byte[] buf = new byte[100];
        
        // read(버퍼의주소, 저장할 위치, 읽을 바이트개수)
        // => 리턴 값은 실제 읽은 바이트의 개수이다.
        int count = in.read(buf, 10, 40); // 4바이트를 읽어 10번 방부터 저장한다.
        // 내가 읽으라는 것보다 파일에 있는 데이터가 작으면 파일에 있는 크기만큼만 읽는다.
        // 그래서 실제 읽는 값, count값이 중요하다.

        in.close();
        
        System.out.printf("%d\n",count);
        for (int i = 10; i < (count + 10); i++) 
            System.out.printf("%x ", buf[i]);
        
        System.out.println(); // byte 배열을 읽는다.
        
        
        
        
    }
}
