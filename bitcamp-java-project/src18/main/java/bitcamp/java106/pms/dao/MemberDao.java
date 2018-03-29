package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.util.ArrayList;

public class MemberDao {
    ArrayList collection = new ArrayList();
    
    public void insert(Member member) {
        this.collection.add(member);
    }
    
    public Member[] list() {
        Member[] arr = new Member[this.collection.size()];
        for (int i = 0; i < this.collection.size(); i++) 
            arr[i] = (Member) this.collection.get(i);
        return arr; // arr배열의 주소를 반환한다.
        
    }
    
    public Member get(String id) {
        int index = this.getMemberIndex(id);
        if (index < 0)
            return null;
        return (Member) collection.get(index);
    }
    
    public void update(Member member) {
        int index = this.getMemberIndex(member.getId());
        if (index < 0)
            return;
        collection.set(index, member);
    }
    
    public void delete(String id) {
        int index = this.getMemberIndex(id);
        if (index < 0)
            return;
        collection.remove(index);
    }
    
    private int getMemberIndex(String id) {
        for (int i = 0; i < this.collection.size(); i++) {
            Member originMember = (Member)collection.get(i);
            if (originMember.getId().toLowerCase().equals(id.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    
    
}

//ver 18 - ArrayList를 사용하여 객체(의 주소) 목록을 관리한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
//ver 14 - MemberController로부터 데이터 관리 기능을 분리하여 MemberDao 생성.



