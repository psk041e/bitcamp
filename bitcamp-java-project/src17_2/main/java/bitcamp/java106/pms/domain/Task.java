package bitcamp.java106.pms.domain;

import java.sql.Date; 
//클래스를 가져오는 것이 아니라 컴파일러에게 어느 클래스의 패키지인지 알려주는 것이다.
// cf. C에서는 import를 #define라는 이름으로 사용한다.
// java.lang -> 프로그램을 짤때 매우 필요한 클래스들이 들어있다.
//           -> import하지 않아도 기본적으로 import가 된다.

public class Task /*extends java.lang.Object*/ {
    public static final int READY = 0;
    public static final int WORKING = 1;
    public static final int COMPLETE = 9;
    
    // static이 붙지 않은 메모리 - 인스턴스는 primitive타입은 0 / 0.0 / false 로 셋팅한다.
    // 개발자들 사이에서 0이 셋팅된다고 말을 하면 헷갈려한다.
    // ex) Team taem; team = 0; 을 자꾸 시도한다.
    // 자바에서는 주소가 없는 것을 null이라고 말을한다.
    // 물리적으로 모든메모리가 다 0bit로 셋팅된다.
    private int no; // 작업번호 -> 입력받는 것이 아니라 내부적으로 쓰기 위해서 만드는 변수
    private String title;
    private Date startDate;
    private Date endDate;
    private int state;
    private Member worker;
    private Team team;
    
    // 특정 팀에 소속되지 않은 작업을 만들 수 없도록 기본생성자를 없앴다.
    //public  Task() {}
    
    public Task(Team team) {
        this.team = team; 
    }
    
    public Task(Team team, String title ,Date startDate, Date endDate) {
        this.team = team;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = /*Task.*/READY; // 같은 Task안에 있기 때문에 생략 가능
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Member getWorker() {
        return worker;
    }
    public void setWorker(Member worker) {
        this.worker = worker;
    }
    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Task [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", state=" + state
                + ", worker=" + worker + ", team=" + team + "]";
    }
    // toString()을 재정의 해 주지 않으면
    // bitcamp.java106.pms.domain.Task@1540e19d 와 같은 값이 출력된다. 따라서 오버라이딩 해 주어야 한다.
    
    
}

// ver 17 - 사용자 정의 데이터 타입 생성