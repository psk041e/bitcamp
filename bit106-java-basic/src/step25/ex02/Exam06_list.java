// 작업 관리 - 목록 + PreparedStatement
package step25.ex02;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exam06_list {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        PreparedStatement stmt = con.prepareStatement(
                "select tno,titl,srdt,erdt,worker,team from ex_task");
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            System.out.printf("%d,%s,%s\n", 
                rs.getInt("tno"),  
                rs.getString("titl"),
                rs.getDate("srdt"),
                rs.getDate("erdt"),
                rs.getString("worker"),
                rs.getString("teawm")); 
        }

        rs.close();
        stmt.close();
        con.close();
    }
}







