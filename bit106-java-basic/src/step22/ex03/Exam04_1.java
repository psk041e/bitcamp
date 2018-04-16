// 데이터 출력 - String 출력
package step22.ex03;

import java.io.FileOutputStream;

public class Exam04_1 {

    public static void main(String[] args) throws Exception {
        FileOutputStream out = new FileOutputStream("temp/test3.data");
        
        String str = "AB가각간";
        // String클래스에 바이트 배열을 만드는 메서드가 있기 때문에 String은 출력하기가 쉽다.
         
        // str.getBytes(문자코드표)
        // => 지정한 문자 코드표에 따라 인코딩하여 바이트 배열을 만든다.
        // => str.getBytes("UTF-8");
        //    UTF-16문자를 UTF-8문자로 변환해서 배열을 만든다. 
        out.write(str.getBytes("UTF-8"));
        // EUC-KR   -> 41 42 B0 A1 B0 A2 B0 A3
        // UTF-8    -> 41 42 EA B0 80 EA B0 81 EA B0 84
        
        out.close();
        
        System.out.println("데이터 출력 완료!");

    }

}
