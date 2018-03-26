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
    
    // 연산자는 외부에서 사용하는 것이기 때문에 공개해야 한다.
    // => 그래서 public modifier를 사용한다.
    public int addMember(Member member) {
     // 팀 멤버 배열에서 빈 방을 찾아 그 방에 멤버 객체(의 주소)를 넣는다.
        for (int i = 0; i < this.members.length; i++) { // 팀 객체 안의 members배열 길이만큼 반복
            if (this.members[i] == null) {
                this.members[i] = member;
                System.out.println("추가하였습니다.");
                return -1;
            }
        }
        return 0;
    }
    
    public int deleteMember(String memberId) {
        for (int i = 0; i < this.members.length; i++) {
            if (this.members[i] == null) continue;
            if (this.members[i].id.equals(memberId)) {
                this.members[i] = null;
                System.out.println("삭제하였습니다.");
                return 1;
            }
        }
        return 0;
    }
    
    public boolean isExist(String memberId) { // 팀에 들어있는 데이터중에서 멤버가 있는지 없는지 검사한다.
                                              // 팀의 멤버값을 다루는 메서드, 연산
        for (int i = 0; i < this.members.length; i++) { // 팀 객체 안의 members배열 길이만큼 반복
            if (this.members[i] == null) continue;
            if (this.members[i].id.equals(memberId)) {
                return true;
            }
          }
        return false;
    }
    
}


// ver 15 - 멤버를 저장할 인스턴스 변수를 추가한다.
//          팀 멤버 배열에 멤버 객체를 추가하고 빼는 메서드를 새로 정의한다.
// ver 13 - 시작일, 종료일의 데이터 타입을 String에서 Date으로 변경