package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Member;

public class MemberDao {
    Member[] members = new Member[1000];
    int memberIndex = 0;
    
    public void insert(Member member) {
        // 회원 정보가 담겨있는 객체의 주소를 배열에 보관한다.
        this.members[this.memberIndex++] = member;
    }
    
    public Member[] list() {
        // 멤버가 들어있는 갯수만큼 배열을 만든다.
        // 멤버가 들어있는 배열길이만큼 반복해서 arr배열에 값을 집어넣는다.
        Member[] arr = new Member[this.memberIndex];
        for (int i = 0; i < this.memberIndex; i++) 
            arr[i] = this.members[i];
        return arr; // arr배열의 주소를 반환한다.
        
    }
    
    public Member get(String id) {
        // getMemberIndex(): 배열에 있는 id값과 입력받은 id값을 비교해
        //                   같은 값이 있으면 그 배열의 인덱스 값을 반환하는 메서드
        // getMemberIndex()메서드에서 받은 인덱스값을 저장하고
        // 그 값이 -1 이면 동일한 id가 없는것 이기 때문에 null값을 반환,
        // -1 이 아니면 해당 인덱스의 배열값을 반환한다.
        int i = this.getMemberIndex(id);
        if (i == -1) 
            return null;
        return this.members[i];
    }
    
    public void update(Member member) {
        // 새로 변경하는 값을 저장한 객체의 주소값을 받아서 그 객체의
        // id값을 getMemberIndex메서드에 넘겨준다.
        // getMemberIndex(): 배열에 있는 id값과 입력받은 id값을 비교해
        //                   같은 값이 있으면 그 배열의 인덱스 값을 반환하는 메서드
        // getMemberIndex()메서드에서 받은 인덱스 값을 i 변수에 저장하고,
        // 그 값이 -1이 아니면, 입력받 id값과 같은 id값을 가진 배열이
        // 존재한다는 것이기 때문에 새로변경하는 값을 저장한 객체주소를
        // 해당 배열에 넣어준다.
        int i = this.getMemberIndex(member.getId());
        if (i != -1) 
            this.members[i] = member;
    }
    
    public void delete(String id) {
        int i = this.getMemberIndex(id);
        if (i != -1) 
            this.members[i] = null;
    }
    
    // id를 찾는 코드가 반복되므로 따로 만들어준다.
    // 다음 메서드는 내부에서만 사용할 것이기 때문에 공개하지 않는다.
    private int getMemberIndex(String id) {
        // 멤버 배열의 수만큼 반복해서 입력받은 id값과 배열에 들어있는 id값을 비교한다.
        // 이때 입력값과 배열의 값이 같으면 그 인덱스값을 반환한다.
        // 그리고 같은 값이 없는 경우에는 -1을 리턴해준다.
        for (int i = 0; i < this.memberIndex; i++) {
            if (this.members[i] == null) continue;
            if (id.equals(this.members[i].getId().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
}




