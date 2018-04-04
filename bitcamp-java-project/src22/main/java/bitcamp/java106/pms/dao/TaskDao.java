package bitcamp.java106.pms.dao;

import java.util.ArrayList;
import java.util.Iterator;

import bitcamp.java106.pms.domain.Task;

public class TaskDao extends AbstractDao<Task> {
    
    // 상속으로 인해 직접 코드를 쓰지 않고 AbstractDao의 
    // 클래스를 상속받아 내것같이 쓸수 있다.
    
    // 기존의 list() 메서드로는 작업을 처리할 수 없기 때문에 
    // 팀명으로 작업 목록을 리턴해 주는 메서드를 추가한다.
    // => 오버로딩의 전형적인 예
    public Iterator<Task> list(String teamName) {
        ArrayList<Task> tasks = new ArrayList<>();
        // 빈 바구니를 준비한다. 
        // Stack, Queue는 FIFO,LIFO의 특징이 있기 때문에
        // ArrayList를 사용한다.
        // 배열을 쉽게 다룰수 있는 ArrayList를 사용하였다.
        // 여려개를 담을경우(단순하게 넣고 빼는 용도로 사용하기 좋다.)
        for (Task task : collection) {
            if (task.getTeam().getName().equalsIgnoreCase(teamName)) {
                tasks.add(task);
            }
            // 원하는 팀(taemName)만 받아서 ArrayList<> 배열에 담는다.
        }
        return tasks.iterator(); // ArrayList에서 값을 꺼내준다.
    }
    
    public int indexOf(Object key) {
        int taskNo = (Integer) key;
        for (int i = 0; i < this.collection.size(); i++) {
            Task task = (Task) collection.get(i);
            if (task.getNo() == taskNo) {
                return i;
            }
        }
        return -1;
    }
}

// ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
// ver 18 - ArrayList 클래스를 적용앟여 객체(의 주소) 목록을 관리한다.
// ver 17 - 클래스 생성





