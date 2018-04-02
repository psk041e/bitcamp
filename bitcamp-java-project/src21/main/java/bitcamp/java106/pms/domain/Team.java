package bitcamp.java106.pms.domain;

import java.sql.Date;

// Team 클래스 
// => 팀 정보를 저장할 수 있는 메모리의 구조를 설계한 클래스이다.
// => 즉, 팀 정보를 위해 사용자(자바 언어 사용자. 즉, 개발자)가 새로 정의한 데이터 타입이다.
// => user defined data type
//
public class Team {
    private String name;
    private String description;
    private int maxQty;
    private Date startDate;
    private Date endDate;
    
    // 사용자 정의 데이터 타입에서 메서드 정의란?
    // => 새 데이터 타입의 값을 다룰 연산자를 정의하는 것을 의미한다.
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxQty() {
        return maxQty;
    }

    public void setMaxQty(int maxQty) {
        this.maxQty = maxQty;
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


    @Override
    public String toString() {
        return "Team [name=" + name + ", description=" + description + ", maxQty=" + maxQty + ", startDate=" + startDate
                + ", endDate=" + endDate + "]";
    }
    // toString()오버라이딩 - 개발하는 동안 중간중간 그 값을 출력해서 확인하고 싶을 때 사용한다.
}   

// ver 17 - getMember() 메서드 추가
//          toString() 오버라이딩.
// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - 멤버를 저장할 인스턴스 변수를 추가한다.
//          팀 멤버 배열에 멤버 객체를 추가하고 빼는 메서드를 새로 정의한다.
// ver 13 - 시작일, 종료일의 데이터 타입을 String에서 Date으로 변경