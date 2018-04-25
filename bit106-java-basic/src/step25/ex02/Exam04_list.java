// 팀 관리 - 목록 + PreparedStatement
package step25.ex02;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exam04_list {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        PreparedStatement stmt = con.prepareStatement(
                "select name,des,maq,srdt,erdt from ex_team");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            System.out.printf("%s,%s,%d,%s,%s\n",
                rs.getString("name"),
                rs.getString("des"),
                rs.getInt("maq"),  
                rs.getDate("srdt"),
                rs.getDate("erdt")); 
        }

        rs.close();
        stmt.close();
        con.close();
    }
}







