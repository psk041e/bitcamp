// 수업 관리 - 등록  + PreparedStatement
package step25.ex02;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam05_insert {

    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("수업명? ");
        String title = keyScan.nextLine();
        
        System.out.print("시작일? ");
        Date startDate = Date.valueOf(keyScan.nextLine());
        
        System.out.print("종료일? ");
        Date endDate = Date.valueOf(keyScan.nextLine());
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        
        PreparedStatement stmt = con.prepareStatement( 
                "insert into ex_classroom(titl,srdt,erdt) values(?,?,?)");
        
        stmt.setString(1, title);
        stmt.setDate(2, startDate);
        stmt.setDate(3, endDate);
        int count = stmt.executeUpdate();
        System.out.printf("%d 개 입력 성공!", count);
        
        
        stmt.close();
        con.close();
        keyScan.close(); // 자원을정리하지 않으면 계속 낭비된다.
    }
}







