package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.util.ArrayList;

public class TeamMemberDao {
    private ArrayList teamCollection = new ArrayList(); // 팀의 이름을 저장
    private ArrayList memberCollection = new ArrayList(); // 멤버 아이디를 저장
    
    private int getIndex(String teamName, String memberId) {
        String ptn = teamName.toLowerCase(); 
        String pmi = memberId.toLowerCase(); 
        for (int i = 0; i < teamCollection.size(); i++) { 
               String tn = teamCollection.get(i).toString().toLowerCase(); 
               // teamCollection의 팀이름은 String이기 때문에 
               // String 클래스에서 오버라이딩 한 대로 클래스명@해시값이 아닌 실제 저장된 값이 출력된다.
               // get()은 실제 스트링객체를 리턴한다.
               // 
               // toLowerCase()는 Object 클래스에는 없는 메소드이다.
               // String 클래스에서만 쓸 수 있기 때문에 
               // 여기서 toLowerCase()를 쓰기 위해서는 
               // 1. 형변환 을하거나 2. toString()을 호출해 주면 된다.
               // String 클래스에서 toString() 메서드를
               // 클래스명@해시값이 아닌 실제 들어있는 값을 호출해 주기 때문에
               // 두가지 방법 모두 실제 값을 가리킨다.
               // 이 실제 값은 String 변수이기 때문에 toLowerCase()메서드를 사용할 수 있는 것이다.
               String mi = memberCollection.get(i).toString().toLowerCase();
               if (tn.equals(ptn) && mi.equals(pmi)) {
                   return i;
               }
        }
        return -1; 
    }
    
    public int addMember(String teamName, String memberId) { 
        if (this.isExist(teamName, memberId)) {
            return 0;
        }
        teamCollection.add(teamName);
        memberCollection.add(memberId);
        return 1; 
       }
       
    public int deleteMember(String teamName, String memberId) { 
        int index = this.getIndex(teamName, memberId);
        if (index < 0) { // 존재하지 않는 멤버라면, 
            return 0;
        }
        teamCollection.remove(index);
        memberCollection.remove(index);
        return 1; 
       }
       
       
    public boolean isExist(String teamName, String memberId) {
           if (this.getIndex(teamName, memberId) < 0) {
               return false;
           } else {
               return true;
           }
       }

    private int getMemberCount(String teamName) {
        int cnt = 0; // 로컬 변수는 자동 초기화 되지 않는다. 반드시 초기화 시켜줘야 한다.
        String ptn = teamName.toLowerCase();
        
        for (int i = 0; i < teamCollection.size(); i++) { 
            String tn = teamCollection.get(i).toString().toLowerCase(); 
            if (tn.equals(ptn)) {
                cnt++;
            }
        }
        return cnt++;
    }
    
    public String[] getMembers(String teamName) {
        String ptn = teamName.toLowerCase();
        String[] members = new String[this.getMemberCount(teamName)];
        
        for (int i = 0, x = 0; i < teamCollection.size(); i++) { 
            String tn = teamCollection.toString().toLowerCase(); 
            if (tn.equals(ptn)) {
               members[x++] = memberCollection.get(i).toString();
            }
        }
        return members;
    }
}
// 용어 정리!
// 메서드 시크너처(method signature) = 함수 프로토타입(function prototype) 
// => 메서드의 이름과 파라미터 형식, 리턴 타입에 대한 정보를 말한다.
//


// ver 18 - ArrayList를 적용하여 객체(의 주소) 목록을 관리한다.
// ver 17 - 클래스 추가