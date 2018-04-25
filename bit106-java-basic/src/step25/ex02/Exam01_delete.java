// 게시판 관리 - 삭제
package step25.ex02;

import java.sql.DriverManager;
import java.util.Scanner;

public class Exam01_delete {

    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("삭제할 게시물 번호? ");
        String no = keyScan.nextLine();
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        java.sql.Statement stmt = con.createStatement();
        
        int count = stmt.executeUpdate(
            "delete from ex_board where bno=" + no);
        System.out.printf("%d 개 삭제 성공!", count); 
        // 기존의 sql문에 사용자가 입력한 값을 붙였다.
        // 이것은 치명적인 문제가 발생한다.
        // 해커들의 공격이 될만한 코드가 삽입될수 있다.
        // ex) 1 or 1=1 
        // select 또한 똑같다. 
        // 그래서 사용자 입력값으로 sql문을 만들지 않도록 한다. => 행안부 자바 시큐어코딩 검색
        // 이것을 방지하기 위해 소스코드에서 에러를 띄워서 개발자에게 알린다.
        // => Statement는 쓰지 말아라!
        
        stmt.close();
        con.close();
        keyScan.close();
    }
}







