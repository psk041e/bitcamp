package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.util.ArrayList;

public class TeamMemberDao {
    // 팀 ArrayList, 멤버 ArrayList두개 사용
    private ArrayList teamCollection = new ArrayList();
    private ArrayList memberCollection = new ArrayList();
    
    private Object[][] teamMembers = new Object[1000][2];
    private int rowIndex;   // 현재 위치를 지정, 몇번째 행이냐?
                            // 기본적으로 0부터 시작 
                            // 인스턴스 변수와 스태틱 변수는 기본적으로 값을 0으로 설정하지 않아도 
                            // 모든 타입이 다 0으로 설정된다.
                            // 다만 boolean인 경우는 false, 레퍼런스 주소인 경우는 null이라 부른다.
    
    private int getIndex(String teamName, String memberId) {
        String ptn = teamName.toLowerCase(); // p: parameter
        String pmi = memberId.toLowerCase(); // 파라미터가 대,소문자를 구분하지 않도록 바꾼다.
        for (int i = 0; i < this.rowIndex; i++) { 
            if (this.teamMembers[i][0] == null) continue;
               // 괄호를 빼버리면 마지막 항목에 대해 형변환한다.
               String tn = ((String) this.teamMembers[i][0]).toLowerCase(); 
               String mi = ((String) this.teamMembers[i][1]).toLowerCase();
               if (tn.equals(ptn) && mi.equals(pmi)) {
                   return i;
               }
        }
        return -1; // 0이라는 것은 유효한 인덱스 이기 때문에 -1을 리턴한다.
                      // 찾지 못한 경우(?) -1을 사용하도록 권장한다.
    }
    
    // 연산자는 외부에서 사용하는 것이기 때문에 공개해야 한다.
    // => 그래서 public modifier를 사용한다.
    public int addMember(String teamName, String memberId) { 
        if (this.isExist(teamName, memberId)) {
            return 0;
        }
            // 만약 일치하는 주소가 없다면 현재 행의 주소의 0번방에는 팀주소를,
            // 1번 방에는 팀 주소를 저장한다.
           this.teamMembers[rowIndex][0] = teamName;
           this.teamMembers[rowIndex][1] = memberId; // 저장할 때는 toLowerCase()를 적용한 값이 아닌 원본값을 저장한다.
           rowIndex++;
           return 1; // 한 개를 추가했다.
       }
       
    // true false값으로 반환해도 상관 없다.
    public int deleteMember(String teamName, String memberId) { 
        int index = this.getIndex(teamName, memberId);
        if (index < 0) { // 존재하지 않는 멤버라면, 
            return 0;
        }
        
        this.teamMembers[index][0] = null;
        this.teamMembers[index][1] = null;
        return 1; 
       }
       
       
    public boolean isExist(String teamName, String memberId) { // 팀에 들어있는 데이터중에서 멤버가 있는지 없는지 검사한다.
           if (this.getIndex(teamName, memberId) < 0) {
               return false; // 찾았을때
           } else {
               return true; // 찾지 못했을 때
           }
       }

    private int getMemberCount(String teamName) {
        int cnt = 0; // 로컬 변수는 자동 초기화 되지 않는다. 반드시 초기화 시켜줘야 한다.
        String ptn = teamName.toLowerCase();
        
        for (int i = 0; i < this.rowIndex; i++) { 
            if (this.teamMembers[i][0] == null) continue;
        
            String tn = ((String) this.teamMembers[i][0]).toLowerCase(); 
            if (tn.equals(ptn)) {
                cnt++;
            }
        }
        return cnt++;
    }
    
    public String[] getMembers(String teamName) {
        String ptn = teamName.toLowerCase();
        String[] members = new String[this.getMemberCount(teamName)];
        
        for (int i = 0, x = 0; i < this.rowIndex; i++) { 
            if (this.teamMembers[i][0] == null) continue;
        
            String tn = ((String) this.teamMembers[i][0]).toLowerCase(); 
            if (tn.equals(ptn)) {
               members[x++] = (String) this.teamMembers[i][1];
            }
        }
        return members;
    }
}
// 용어 정리!
// 메서드 시크너처(method signature) = 함수 프로토타입(function prototype) 
// => 메서드의 이름과 파라미터 형식, 리턴 타입에 대한 정보를 말한다.
//



// ver 17 - 클래스 추가