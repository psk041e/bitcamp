// 게시글 데이터를 저장할 새 데이터 타입을 정의한다.
package bitcamp.java106.pms.domain;

import java.sql.Date;

public class Board {
    private static int count = 1;
    // 이전에는 데이터를 삭제하면 null로 바뀌고 그 방은 쓸수 없게 되었지만
    // ArrayList 클래스를 사용해 
    // 삭제를 하더라도 배열을 당겨서 빈 방 없이 사용할 수 있도록 만들었다.
    
    private int no;
    private String title;
    private String content;
    private Date createdDate;
    
    public Board() {
        this.no = count++;
        // 게시물 객체가 만들어 질 때마다 고유번호를 갖게 한다.
        // 한번 번호가 들어가면 중간에 게시물이 없어지더라도
        // 그 번호를 유지한다.
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
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
}

//ver 18 - 게시물 객체의 고유 번호(no)를 static 변수(count)를 이용하여 자동 설정한다. 
//ver 16 - 캡슐화 적용, 겟터, 셋터 추가.
//ver 13 - 등록일의 데이터 타입을 String에서 Date으로 변경