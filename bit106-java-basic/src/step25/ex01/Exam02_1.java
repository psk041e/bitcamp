// JDBC 프로그래밍 개요 - DBMS에 연결하기
package step25.ex01;

import java.sql.DriverManager;

public class Exam02_1 {

    public static void main(String[] args) throws Exception {
        // 1) JDBC 드라이버 로딩
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        // 2) DBMS에 연결하기
        // => DriverManager를 통해 등록된 Driver 객체를 사용하여 DBMS와 연결한다.
        //    jdbc url : DBMS 서버 정보. 예) jdbc:mysql://서버:포트/데이터베이스명
        //    username : DBMS 사용자 아이디
        //    password : DBMS 사용자 암호
        // => 리턴 : Driver가 DBMS와 연결한 후 연결 정보를 다루는 객체를 리턴한다.
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111"); 
        // 포트번호를 생략하면 3306
        // 기본적인 시간은 UTC로 하겠다.
        // 원래는 KST가 기본이나 이 드라이버는 KST를 지원하지 않아 다른 시간기준을  명시해 주어야 한다.
        System.out.println("DBMS와 연결됨!");
        // 자원 해제
        // => 파일과 마찬가지로 DBMS에 연결한 후 더이상 사용하지 않으면 연결을 해제해야 한다.
        con.close();
    }
}
