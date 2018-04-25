package bitcamp.java106.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Task;

@Component
public class TaskDao {
    public int delete(int no) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                    "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                    "delete from pms_task where tano=?");) {
            
            stmt.setInt(1, no);
            return stmt.executeUpdate();
        }
    }
    
    public List<Task> selectList() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                    "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                    "select tano,titl,sdt,edt,stat,mid,tnm from pms_task");
            ResultSet rs = stmt.executeQuery();) {

            ArrayList<Task> arr = new ArrayList<>();
            while (rs.next()) {
                Task task = new Task();
                task.setNo(rs.getInt("tano"));
                task.setTitle(rs.getString("titl"));
                task.setStartDate(rs.getDate("sdt"));
                task.setEndDate(rs.getDate("edt"));
                task.setState(rs.getInt("stat"));
                task.setWorker(rs.getString("mid"));
                arr.add(task);
            }
            return arr;
        }
    }

    public int insert(Task task) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try ( // close 자동호출을 윌해 try 사용, 항상 try문을 나가기 전에 close가 자동으로 일어난다.
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                    "java106", "1111");
            PreparedStatement stmt = con.prepareStatement( // PreparedStatement: 준비된 문장
                    "insert into pms_task(titl,sdt,edt,stat,mid,tnm) values(?,?,?,?,?,?)");) {
            
            stmt.setString(1, task.getTitle());
            stmt.setDate(2, task.getStartDate());
            stmt.setDate(3, task.getEndDate());
            stmt.setInt(4, task.getState());
            stmt.setString(5, task.getWorker());
            stmt.setString(6, task.getTeam());
            
            return stmt.executeUpdate();
        }
    }

    public int update(Task task) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                    "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                    "update pms_board set titl=?, cont=?,cdt=now() where bno=?");) {
                
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getContent());
            stmt.setInt(3, task.getNo());
            return stmt.executeUpdate();
        }
    }

    public Task selectOne(int no) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                    "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                    "select bno,titl,cont,cdt from pms_board where bno=?");) {
                
            stmt.setInt(1, no); // try문 안에 들어갈수 없다.
            try (ResultSet rs = stmt.executeQuery();) { // 자동 close를 위해 try문 사용
                if (!rs.next())
                    return null;
                
                Task task = new Task();
                task.setNo(rs.getInt("bno"));
                task.setTitle(rs.getString("titl"));
                task.setContent(rs.getString("cont"));
                task.setCreatedDate(rs.getDate("cdt"));
                return task;
            }
        }
    }
}

//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList 클래스를 적용하여 객체(의 주소) 목록을 관리한다.
// ver 17 - 클래스 생성





