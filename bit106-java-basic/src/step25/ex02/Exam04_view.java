// 팀 관리 - 조회 + PreparedStatement적용
package step25.ex02;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Exam04_view {

    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("조회할 팀명? ");
        String name = keyScan.nextLine();
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        
        PreparedStatement stmt = con.prepareStatement(
                "select name,des,maq,srdt,erdt from ex_team where name=?");
        stmt.setString(1, name);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            System.out.printf("팀명: %s\n", rs.getString("name"));
            System.out.printf("설명: %s\n", rs.getString("des"));
            System.out.printf("최대인원: %d\n", rs.getInt("maq"));
            System.out.printf("시작일: %s\n", rs.getDate("srdt"));
            System.out.printf("종료일: %s\n", rs.getDate("erdt"));
        } else {
            System.out.println("해당 이름의 팀이 없습니다!");
        }

        rs.close();
        stmt.close();
        con.close();
        keyScan.close();
    }
}







