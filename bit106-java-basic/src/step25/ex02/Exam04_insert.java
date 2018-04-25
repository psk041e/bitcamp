// 팀 관리 - 등록  + PreparedStatement
package step25.ex02;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam04_insert {

    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("이름? ");
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
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        PreparedStatement stmt = con.prepareStatement( 
                "insert into ex_team(name,des,maq,srdt,erdt) values(?,?,?,?,?)");
        
        stmt.setString(1, name);
        stmt.setString(2, description);
        stmt.setInt(3, maxQty);
        stmt.setDate(4, startDate);
        stmt.setDate(5, endDate);
        
        int count = stmt.executeUpdate();
        System.out.printf("%d 개 입력 성공!", count);
        
        stmt.close();
        con.close();
        keyScan.close(); 
    }
}







