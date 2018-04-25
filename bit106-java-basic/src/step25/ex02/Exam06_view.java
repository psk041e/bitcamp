// 작업 관리 - 조회 + PreparedStatement적용
package step25.ex02;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Exam06_view {

    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("조회할 작업 번호? ");
        String no = keyScan.nextLine();
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        
        PreparedStatement stmt = con.prepareStatement(
                "select tno,titl,srdt,erdt,worker,team from ex_task where bno=?");
        stmt.setString(1, no);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            System.out.printf("번호: %d\n", rs.getInt("bno"));
            System.out.printf("작업명: %s\n", rs.getString("titl"));
            System.out.printf("시작일: %s\n", rs.getDate("srdt"));
            System.out.printf("종료일: %s\n", rs.getDate("erdt"));
            System.out.printf("회원명: %s\n", rs.getString("worker"));
            System.out.printf("팀명: %s\n", rs.getString("team"));
        } else {
            System.out.println("해당 번호의 작업이 없습니다!");
        }

        rs.close();
        stmt.close();
        con.close();
        keyScan.close();
    }
}







