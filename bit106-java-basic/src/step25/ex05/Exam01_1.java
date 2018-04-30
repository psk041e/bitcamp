// Data Persistence Framework 도입 - Mybatis
package step25.ex05;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// Data Persistence Framework
// => 데이터의 영속성(지속성; 등록,조회,변경,삭제)을 대신 처리해주는 프레임워크.
// 1) SQL Mapper
//    - 직접 SQL 문을 작성한다.
//    - 각각의 DBMS에 최적화된 SQL을 작성할 수 있다.
//    - DBMS마다 미미하게 다른 SQL을 작성해야 하는 번거로움이 있다.
//    - 예) Mybatis(실무에서 가장 많이 사용한다.) 등
// 2) OR Mapper
//    - 전용 언어 및 문법 (Domain-Specific Language;DSL)을 사용하여 작성
//      실행할 때 DBMS에 맞춰서 SQL을 생성하여 실행한다.
//    - DBMS 마다 SQL문을 작성할 필요가 없어 편리하다. 
//    - 대신 DBMS에 최적화된 SQL문을 실행할 수 없다.
//      즉, DBMS의 특징을 최대로 활용할 수 없다.
//    - 예) Hibernate, TopLink 등 
// 
// Mybatis 도입
// 1) 의존 라이브러리 추가
//    - mvnrepository.com 검색하여 build.gradle 파일에 추가한다.
//    - "gradle eclipse" 실행한 후 이클립스 에디터에서 프로젝트를 "refresh"한다.
// 2) Mybatis 설정 파일 준비
//    - mybatis-config.xml 생성 및 편집
// 3) DB 연결 정보를 담은 프로퍼티 파일 준비
//    - jdbc.properties 생성 및 편집
// 4) SQL 문장을 작성할 파일 준비
//    - BoardMapper.xml 생성 및 편집
// 5) Mybatis 객체 준비
public class Exam01_1 {

    public static void main(String[] args) throws Exception {
        // mybatis 설정 파일을 읽을 도구를 준비한다.
        // => Resources의 getResourceAsStream() 메서드는
        //    파라미터에 지정한 파일 경로를 CLASSPATH에서 찾는다.
        //    그리고 그 파일을 읽을 수 있는 InputStream 도구를 리턴한다.
        // => 개발자가 mybatis-config.xml 파일의 전체 경로를 지정하지 않아도 되기 때문에
        //    매우 편리하다.
        // => 단 해당 파일은 CLASSPATH에 있어야 한다.
        //
        // getResourceAsFile
        // => 객체를 만들어내는 역할을 하는 메서드 => 공장 역할을 하는 메서드 => factory method
        // 우리가 직접 fileInputStream을 만들려면 경로를 찾아야 하지만 이 메서드를 사용하면 그럴 필요가 없다.
        InputStream inputStream = Resources.getResourceAsStream(
                "step25/ex05/mybatis-config.xml");
        
        System.out.println(inputStream.getClass().getName());
        
        // Builder 패턴 사용 -> factory 객체 생성 과정이 복잡하기 때문에, 설정파일 정보를 읽어서 복잡하게 만들어야 하기 때문에
        //                  Builder 패턴을 사용하였다.
        // 객체를 생성해주는 factory method패턴을 사용하였다.
        //
        // mybatis 설정 파일을 가지고 Builder를 이용하여
        // SqlSession 공장 객체를 생성한다.
        SqlSessionFactory factory = 
                new SqlSessionFactoryBuilder().build(inputStream);
        
        // SqlSession 공장 객체로부터 SqlSession 객체를 얻는다.
        SqlSession sqlSession = factory.openSession();

        System.out.println("mybatis 준비 완료!");
        
        /*
                    김밥천국 강남지점 = 김밥천국인테리어업자.짓는다();
                    김밥 한줄 = 김밥천국.김밥주세요();
        */
        
        sqlSession.close();
    }
}




