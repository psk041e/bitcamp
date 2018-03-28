package bitcamp.java106.pms.domain;

// 사용자가 정의한 메모리 설계도 => class
public class Team {
    public String name;
    public String description;
    public int maxQty;
    public String startDate;
    public String endDate;
}
// "사용자 정의 데이터 타입" 역할을 하는 클래스에 대해서는
// domain/ package 밑에 둔다.   -> domain/Team.java
// (이나 vo(value object))      -> domain/Member.java
//                              -> domain/Board.java

// 분리하는 이유?
// 1) public class로 만들어주기 위해 App.java 파일과 분리한다
// 2) 팀 클래스를 수정할때 파일명과 클래스명이 다르면 찾기가 힘들지만
//    Team.class파일이 만들어지면 찾기가 쉽다-> 유지보수가 쉽다

// ★★ class 에만 public 을 주면 같은 패키지에 소속된
// 클래스에서만 세부항목(변수)에 접근할 수 있다.★★
// 따라서 그 외의 클래스에서도 접근할수 있도록 하기 위해서는
// 변수항목에도 public 명령을 앞에 붙여준다.
// => modifier : 원래의 특징이나 성질을 변경한다.