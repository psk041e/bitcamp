package bitcamp.java106.pms.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.domain.Team;

@Component
public class TeamDao extends AbstractDao<Team> {
    
    public TeamDao() throws Exception {
        load();
    }
    
    public void load() throws Exception {
        try ( 
            ObjectInputStream in = new ObjectInputStream(
                                   new BufferedInputStream(
                                   new FileInputStream("data/team.data")));
            ) {
                
                while (true) {
                    try {
                        this.insert((Team) in.readObject());
                    } catch (Exception e) {
                        break; // 데이터를 읽을 수 없으면 예외를 던진다.
                    }
                }
            //in.close(); 자동으로 하기 때문에 필요 없다.
            } 
    }
    
    public void save() throws Exception {
        try (
                ObjectOutputStream out = new ObjectOutputStream(
                                new BufferedOutputStream(
                                new FileOutputStream("data/team.data")));
                 ) {
            
            Iterator<Team> teams = this.list();
            
            while (teams.hasNext()) {
                out.writeObject(teams.next());
            }
        }
    }
    
    public int indexOf(Object key) {
        String name = (String) key;
        for (int i = 0; i < collection.size(); i++) {
            if (name.equalsIgnoreCase(collection.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }
}

//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList 클래스를 적용하여 객체(의 주소) 목록을 관리한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
//ver 14 - TeamController로부터 데이터 관리 기능을 분리하여 TeamDao 생성.





