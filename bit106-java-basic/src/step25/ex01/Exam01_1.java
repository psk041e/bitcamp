// JDBC 프로그래밍 개요 - JDBC 드라이버 준비
package step25.ex01;

import java.sql.DriverManager;

// JDBC 드라이버 다운로드 및 설정
// 1) 직접 설정하기
// - java-basic/lib 폴더 생성
// - c:\Program Files(x86)\MySQL\Connector J 8.0\mysql-connector-java-8.0.11
// - java-basic/lib 폴더에 붙여넣기
// - 컴파일과 실행할 때 .jar 파일을 사용할 수 있도록 CLASSPATH에 추가한다.
// - project 컨텍스트 메뉴/build path/configure build path.../Libraries/Add Jars...
public class Exam01_1 {

    public static void main(String[] args) throws Exception {
        // 1) JDBC 드라이버 로딩
        // => java.sql.Driver 인터페이스 구현체를 만들어
        //    DriverManager가 찾을 수 있도록 등록해야 한다.
        DriverManager.registerDriver(new com.mysql.jdbc.Driver()); 
        // 파라미터 값으로 반드시 드라이버 구현체가 와야 한다. 
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        
        // 위 mysql 드라이버는 구형 드라이버로서 사용하지 말도록 권고되고 있다.
    }
}
