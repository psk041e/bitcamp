// 게시판 관리 - 등록  + PreparedStatement
package step25.ex02;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam02_insert {

    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        // 사용자로부터 제목, 내용을 입력받는다.
        System.out.print("제목? ");
        String title = keyScan.nextLine();
        
        System.out.print("내용? ");
        String content = keyScan.nextLine();
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        
        // 값이 들어갈 자리에 in-parameter(?)를 지정한다.
        // => 데이터 타입에 상관 없이 ?를 넣는다.
        PreparedStatement stmt = con.prepareStatement( // PreparedStatement: 준비된 문장
                "insert into ex_board(titl,cont,rdt) values(?,?,now())");
        
        // in-parameter에 값을 설정한다.
        // => 설정하는 순서는 상관없다. 하지만 유지보수를 위해 순서대로 나열하라!
        stmt.setString(1, title);
        stmt.setString(2, content);
        
        // 실행할 때는 SQL문을 파라미터로 넘길 필요가 없다. 이미 준비되었으므로 그냥 하면 된다.
        int count = stmt.executeUpdate();
        System.out.printf("%d 개 입력 성공!", count);
        
        
        stmt.close();
        con.close();
        keyScan.close(); // 자원을정리하지 않으면 계속 낭비된다.
    }
}







