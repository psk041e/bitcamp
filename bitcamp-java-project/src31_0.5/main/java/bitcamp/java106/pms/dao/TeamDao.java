package bitcamp.java106.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.domain.Team;

@Component
public class TeamDao {
    public int delete(String name) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                    "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                    "delete from pms_team where name=?");) {
            
            stmt.setString(1, name);
            return stmt.executeUpdate();
        }
    }
    
    public List<Team> selectList() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                    "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                    "select name,max_qty,sdt,edt from pms_team");
            ResultSet rs = stmt.executeQuery();) {

            ArrayList<Team> arr = new ArrayList<>();
            while (rs.next()) {
                Team team = new Team();
                team.setName(rs.getString("name"));
                team.setMaxQty(rs.getInt("max_qty"));
                team.setStartDate(rs.getDate("sdt"));
                team.setEndDate(rs.getDate("edt"));
                arr.add(team);
            }
            return arr;
        }
    }

    public int insert(Team team) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try ( // close 자동호출을 윌해 try 사용, 항상 try문을 나가기 전에 close가 자동으로 일어난다.
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                    "java106", "1111");
            PreparedStatement stmt = con.prepareStatement( // PreparedStatement: 준비된 문장
                    "insert into pms_team(name,dscrt,max_qty,sdt,edt) values(?,?,?,?,?)");) {
            
            stmt.setString(1, team.getName());
            stmt.setString(2, team.getDescription());
            stmt.setInt(3, team.getMaxQty());
            stmt.setDate(4, team.getStartDate(), Calendar.getInstance(Locale.KOREAN));
            stmt.setDate(5, team.getEndDate(), Calendar.getInstance(Locale.KOREAN));
            
            return stmt.executeUpdate();
        }
    }

    public int update(Team team) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                    "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                    "update pms_team set dscrt=?,max_qty=?,sdt=?,edt=? where name=?");) {
                
            stmt.setString(1, team.getDescription());
            stmt.setInt(2, team.getMaxQty());
            stmt.setDate(3, team.getStartDate(), Calendar.getInstance(Locale.KOREAN));
            stmt.setDate(3, team.getEndDate(), Calendar.getInstance(Locale.KOREAN));
            return stmt.executeUpdate();
        }
    }

    public Team selectOne(String name) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                    "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                    "select name,dscrt,max_qty,sdt,edt from pms_team where name=?");) {
                
            stmt.setString(1, name); // try문 안에 들어갈수 없다.
            try (ResultSet rs = stmt.executeQuery();) { // 자동 close를 위해 try문 사용
                if (!rs.next())
                    return null;
                
                Team team = new Team();
                team.setName(rs.getString("name"));
                team.setDescription(rs.getString("descrt"));
                team.setMaxQty(rs.getInt("max_qty"));
                team.setStartDate(rs.getDate("sdt"));
                team.setEndDate(rs.getDate("edt"));
                return team;
            }
        }
    }
}

//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList 클래스를 적용하여 객체(의 주소) 목록을 관리한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
//ver 14 - TeamController로부터 데이터 관리 기능을 분리하여 TeamDao 생성.





