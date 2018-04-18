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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;

@Component
public class TaskDao extends AbstractDao<Task> {
    
    public TaskDao() throws Exception {
        load();
    }
    
    public void load() throws Exception {
        try ( 
            ObjectInputStream in = new ObjectInputStream(
                                   new BufferedInputStream(
                                   new FileInputStream("data/task.data")));
            ) {
                
                while (true) {
                    try {
                        this.insert((Task) in.readObject());
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
                                new FileOutputStream("data/task.data")));
                 ) {
            
            Iterator<Task> tasks = this.list();
            
            while (tasks.hasNext()) {
                out.writeObject(tasks.next());
            }
        }
    }
    
    // 기존의 list() 메서드로는 작업을 처리할 수 없기 때문에 
    // 팀명으로 작업을 목록을 리턴해주는 메서드를 추가한다. 
    // => 오버로딩
    public Iterator<Task> list(String teamName) {
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : collection) {
            if (task.getTeam().getName().equalsIgnoreCase(teamName)) {
                tasks.add(task);
            }
        }
        return tasks.iterator();
    }
    
    public int indexOf(Object key) {
        int taskNo = (Integer) key;
        for (int i = 0; i < collection.size(); i++) {
            Task task = collection.get(i);
            if (task.getNo() == taskNo) {
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
// ver 17 - 클래스 생성





