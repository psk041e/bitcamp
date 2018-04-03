package bitcamp.java106.pms.dao;

import java.util.ArrayList;
import java.util.Iterator;

import bitcamp.java106.pms.domain.Task;

public class TaskDao extends AbstractDao<Task> {
    
    // 기존의 list() 메서드로는 작업을 처리할 수 없기 때문에 
    // 팀명으로 작업 목록을 리턴해 주는 메서드를 추가한다.
    // => 오버로딩의 전형적인 예
    public Iterator list(String teamName) { // 지정된 팀의 작업만 배열에 담아서 보내준다.
        ArrayList<Task> tasks = new ArrayList<>();
        // 여려개를 담을경우(ArrayList가 LinkedList보다 속도가 빠르고 크다)
        for (Task task : collection) {
            if (task.getTeam().getName().equalsIgnoreCase(teamName)) {
                tasks.add(task);
            }
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





