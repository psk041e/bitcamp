package step22.ex07;
// DataInputStream으로 객체 읽기 - 파일이 데이터를 읽어 인스턴스로 만들기package step22.ex04;

import java.io.FileInputStream;

public class Exam01_2 {

    public static void main(String[] args) throws Exception {
        FileInputStream fileIn = new FileInputStream("temp/test7.data");
        
        // FileInputStream 객체에 String, int, boolean 값을 읽는
        // 플러그인/장신구/보조장치(decorator)를 장착한다.
        DataInputStream in = new DataInputStream(fileIn);
        // -> 실제 일을 수행할 객체의 주소를 넘겨준다.
        
        Member member = new Member();
        
        member.name = in.readUTF();
        member.age = in.readInt();
        member.gender = in.readBoolean();
        
        in.close();
        
        System.out.printf("%s\n", member);
    }
}






