package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Task;

public class TaskDao {
    Task[] tasks = new Task[1000];
    int taskIndex = 0;
    
    public void insert(Task task) {
        task.setNo(taskIndex); // 방번호를 task에 넣는다.
        this.tasks[this.taskIndex++] = task;
    }
    
    private int count(String teamName) { // 배열의 개수를 세어준다.
        int cnt = 0;
        for (int i = 0; i < taskIndex; i++) {
            if (tasks[i] == null) continue;
            if (tasks[i].getTeam().getName().toLowerCase().equals(teamName)) {
                cnt++;
            }
        }
        return cnt;
    }
    
    public Task[] list(String teamName) { // 지정된 팀의 작업만 배열에 담아서 보내준다.
        Task[] arr = new Task[this.count(teamName)];
        for (int i = 0, x = 0; i < taskIndex; i++) {
            if (tasks[i] == null) continue;
            if (tasks[i].getTeam().getName().toLowerCase().equals(teamName)) {
                arr[x++] = tasks[i];
            }
        }
        return arr;
    }
    
    public Task get(String teamName, int taskNo) {
        for (int i = 0; i < taskIndex; i++) {
            if (tasks[i] == null) continue;
            if (tasks[i].getTeam().getName().toLowerCase().equals(teamName) && 
                    tasks[i].getNo() == taskNo) { // 두 조건 모두를 충족시키면 실행한다.
                                                  // 작업번호와 팀명이 모두 같아야 한다.
                return tasks[i];
            }
        }
        return null;    // 값을 찾지 못하면 null값을 리턴한다.
    }
    
    public void update(Task task) {
        tasks[task.getNo()] = task;
    }
    
    public void delete(int taskNo) {
        tasks[taskNo] = null;
    }
}

// ver 17 - 클래스 생성





