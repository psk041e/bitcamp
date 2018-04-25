// 게시판 관리 - 등록
package step25.ex02;

import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Exam01_insert {

    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        System.out.println("DBMS와 연결됨!");
        
        Statement stmt = con.createStatement();
        
        // 사용자로부터 제목, 내용을 입력받는다.
        System.out.print("제목? ");
        String title = keyScan.nextLine();
        
        System.out.print("내용? ");
        String content = keyScan.nextLine();
        
        String sql = String.format( // 형식을 갖춘 문자열
                "insert into ex_board(titl,cont,rdt) values('%s','%s',now())", 
                title, content);
        
        int count = stmt.executeUpdate(sql);
        System.out.printf("%d 개 입력 성공!", count);
        
        
        stmt.close();
        con.close();
        keyScan.close(); // 자원을정리하지 않으면 계속 낭비된다.
    }
}







