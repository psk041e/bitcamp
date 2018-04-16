// 객체 읽기 - 파일의 데이터를 읽어 인스턴스로 만들기 
package step22.ex04;

import java.io.FileInputStream;

public class Exam01_2 {

    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/test3.data");
        
        Member member = null; 
        // 먼저 멤버에 대해서 저장하기 위해 메모리를 만든다.
        member = new Member();
        
        // 1) 이름 읽기
        byte[] buf = new byte[100];
        int size = in.read();
        in.read(buf, 0, size);
        member.name = new String(buf, 0, size, "UTF-8");
        
        // 2) 나이 읽기
        member.age = in.read() << 24;
        member.age += in.read() << 16;
        member.age += in.read() << 8;
        member.age += in.read();
        
        
        // 3) 성별 읽기
        if (in.read() == 1)
            member.gender = true;
        else
            member.gender = false;
        
        in.close();
        
        System.out.printf("%s\n", member);
    }
}






