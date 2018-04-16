// DataOutputStream을 이용하여 객체 출력 - 버퍼 사용 전
package step22.ex08;

import java.io.FileOutputStream;

import org.omg.Messaging.SyncScopeHelper;

public class Exam01_1 {

    public static void main(String[] args) throws Exception {
        FileOutputStream fileOut = new FileOutputStream("temp/test8.data");
        DataOutputStream out = new DataOutputStream(fileOut);
        
        Member member = new Member();
        member.name = "AB가각간";
        member.age = 27;
        member.gender = true;
        
        // 장신구/보조장치/플러그인(decorator)를 사용하여 String, int, boolean 값을 출력한다.
        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < 100000; i++) { // 약 1.7메가 출력
            out.writeUTF(member.name); 
            out.writeInt(member.age);
            out.writeBoolean(member.gender);
        }
        
        long endTime = System.currentTimeMillis();
        out.close();
        
        System.out.println("데이터 출력 완료!");
        System.out.println(endTime - startTime);

    }

}
