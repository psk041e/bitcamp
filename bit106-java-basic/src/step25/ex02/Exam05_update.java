// 수업 관리 - 변경 + PreparedStatement 적용
package step25.ex02;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam05_update {

    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("변경할 수업 번호? ");
        String no = keyScan.nextLine();
        
        System.out.print("수업명? ");
        String title = keyScan.nextLine();
        
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
                "update ex_classroom set titl=?, srdt=?,erdt=? where cno=?");
        stmt.setString(1, title);
        stmt.setDate(2, startDate);
        stmt.setDate(3, endDate);
        stmt.setString(4, no);
        int count = stmt.executeUpdate();
        System.out.printf("%d 개 변경 성공!", count); 
        
        stmt.close();
        con.close();
        keyScan.close();
    }
}







