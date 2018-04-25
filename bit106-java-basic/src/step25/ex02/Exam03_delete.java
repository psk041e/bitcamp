// 멤버 관리 - 삭제 + PrepredStatement 적용
package step25.ex02;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam03_delete {

    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("삭제할 회원 아이디 ");
        String id = keyScan.nextLine();
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        
        PreparedStatement stmt = con.prepareStatement(
                "delete from ex_member where id=?");
        stmt.setString(1, id);
        int count = stmt.executeUpdate();
        
        System.out.printf("%d 개 삭제 성공!", count); 
        
        stmt.close();
        con.close();
        keyScan.close();
    }
}







