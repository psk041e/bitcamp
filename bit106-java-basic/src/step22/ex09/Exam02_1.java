// Java I/O API 사용하기 - ObjectOutputStream으로 인스턴스 출력
package step22.ex09;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Exam02_1 {

    public static void main(String[] args) throws Exception {
        FileOutputStream fileOut = new FileOutputStream("temp/test9_3.data");
        BufferedOutputStream bufOut = new BufferedOutputStream(fileOut);
        ObjectOutputStream out = new ObjectOutputStream(bufOut);
        
        Member member = new Member();
        member.name = "AB가각간";
        member.age = 27;
        member.gender = true;
        
        // ObjectOutputStream 인스턴스의 값을 바이트 배열로 만들어 출력하는 기능이 있다.
        out.writeObject(member);
        // 그러나 출력 실행하면 오류가 발생한다.
        // => java.io.NotSerializableException
        // => 인스턴스의 값을 자동으로 바이트 배열로 만들 수 있도록 허락하지 않아서
        //    발생한 실행 오류이다.
        
        out.close();
        
        System.out.println("데이터 출력 완료!");

    }

}
