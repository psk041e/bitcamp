// 팀 관리 - 변경 + PreparedStatement 적용
package step25.ex02;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam04_update {

    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("변경할 팀명? ");
        String name = keyScan.nextLine();
        
        System.out.print("설명? ");
        String description = keyScan.nextLine();
        
        System.out.print("최대인원? ");
        int maxQty = keyScan.nextInt();
        keyScan.nextLine();
        
        System.out.print("시작일? ");
        Date startDate = Date.valueOf(keyScan.nextLine());
        
        System.out.print("종료일? ");
        Date endDate = Date.valueOf(keyScan.nextLine());
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        PreparedStatement stmt = con.prepareStatement(
                "update ex_team set des=?, maq=?,srdt=?, erdt=? where name=?");
        stmt.setString(1, description);
        stmt.setInt(2, maxQty);
        stmt.setDate(3, startDate);
        stmt.setDate(4, endDate);
        stmt.setString(5, name);
        
        int count = stmt.executeUpdate();
        
        // PreparedStatement
        // ex) 제목: okok', rdt=now()
        // 출력 => 제목: okok', rdt=now() 
        //    => 입력한 것을 문자 그대로 받아들여 그 값이 제목이 된다.
        
        System.out.printf("%d 개 변경 성공!", count); 
        
        stmt.close();
        con.close();
        keyScan.close();
    }
}







