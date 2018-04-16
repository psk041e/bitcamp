// 데이터 읽기 - String 값 읽기
package step22.ex03;

import java.io.FileInputStream;

public class Exam04_2 {

    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/test3.data");
        
        byte[] buf = new byte[100];
        
        int count = in.read(buf);
        
        // Exam04_1의 실행 결과로 만들어진 파일을 읽어라!
        // 바이트 배열에 들어있는 값을 사용하여 String 인스턴스를 만든다.
        // new String(바이트 배열, 시작번호, 개수, 문자코드표)
        // => 예) new String(buf, 0, 10, "UTF-8");
        //    buf 배열에서 0번부터 10개의 바이트를 꺼낸다.
        //    이 UTF-8 코드 배열을 UTF-16 문자 배열로 만들어 String 객체를 리턴한다.
        String str = new String(buf, 0, count);
        // 바이트 배열의 문자가 어떤형식으로 인코딩되어있는가?
        // 자바의 String객체는 무조건 UTF-16이다.
        // 어떤 다른 종류의 형식을 UTF-16으로 바꾸는 것이다.
        					
        in.close();
        
        System.out.printf("%s,%d\n", str,count);
    }
}






