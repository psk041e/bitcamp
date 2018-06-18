// 게시물 관리 - 목록
package step25.ex07;

import java.sql.DriverManager;

public class Exam01_list {

    public static void main(String[] args) throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/java106db",
                "java106", "1111");
        System.out.println("DBMS와 연결됨!");
        
        java.sql.Statement stmt = con.createStatement();
        
        java.sql.ResultSet rs = stmt.executeQuery(
            "select bno,titl,rdt from ex_board");
        
        while (rs.next()) {
            System.out.printf("%d,%s,%s\n", 
                rs.getInt("bno"),  
                rs.getString("titl"),
                rs.getDate("rdt")); 
        }

        rs.close();
        stmt.close();
        con.close();
    }
}







