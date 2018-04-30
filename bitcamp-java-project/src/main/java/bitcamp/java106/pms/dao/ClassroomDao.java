package bitcamp.java106.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.jdbc.DataSource;

@Component
public class ClassroomDao {

    SqlSessionFactory sqlSessionFactory;
    
    public ClassroomDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public int delete(int no) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            int count = sqlSession.delete("bitcamp.java106.pms.dao.ClassroomDao.delete",no);
            sqlSession.commit();
            return count;
        } 
    }
    
    public List<Classroom> selectList() throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            return sqlSession.selectList("bitcamp.java106.pms.dao.ClassroomDao.selectList");
        } 
    }

    public int insert(Classroom classroom) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            int count = sqlSession.insert("bitcamp.java106.pms.dao.ClassroomDao.insert", classroom);
            sqlSession.commit();
            return count;
        } 
    }

    public int update(Classroom classroom) throws Exception {
        try (SqlSession sqlSession = this.sqlSessionFactory.openSession()) {
            int count = sqlSession.update("bitcamp.java106.pms.dao.ClassroomDao.update", classroom);
            sqlSession.commit();
            return count;
        } 
    }
}

//ver 32 - DB 커넥션 풀 적용
//ver 31 - JDBC API 적용
//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 20 - 클래스 추가




