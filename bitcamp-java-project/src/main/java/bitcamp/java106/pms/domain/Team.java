package bitcamp.java106.pms.domain;

import java.sql.Date;

// Team 클래스 
// => 팀 정보를 저장할 수 있는 메모리의 구조를 설계한 클래스이다.
// => 즉, 팀 정보를 위해 사용자(자바 언어 사용자. 즉, 개발자)가 새로 정의한 데이터 타입이다.
// => user defined data type
//
public class Team {
    public String name;
    public String description;
    public int maxQty;
    public Date startDate;
    public Date endDate;
    public Member[] members = new Member[10];
    
    // 사용자 정의 데이터 타입에서 메서드 정의란?
    // => 새 데이터 타입의 값을 다룰 연산자를 정의하는 것을 의미한다.
}

// ver 15 - 멤버를 저장할 인스턴스 변수를 추가한다.
//          팀 멤버 배열에 멤버 객체를 추가하고 빼는 메서드를 새로 정의한다.
// ver 13 - 시작일, 종료일의 데이터 타입을 String에서 Date으로 변경