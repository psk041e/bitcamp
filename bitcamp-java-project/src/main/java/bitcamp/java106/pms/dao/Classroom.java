package bitcamp.java106.pms.dao;

import java.sql.Date;

public class Classroom {
    private static int count; // 스태틱변수, 인스턴스 변수는 생성되는 순간 초기화된다.
    private int no;
    private String title;
    private Date startDate;
    private Date endDate;
    private String room;
    
    public Classroom() {
        this.no = ++count; // 1부터 시작되도록 한후 no에 넣는다.
    }
    
     @Override
    public String toString() {
        return "Classroom [no=" + no + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate
                + ", room=" + room + "]";
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
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
    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }
    
}
