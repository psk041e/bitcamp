package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Member;

public class MemberDao {
    Member[] members = new Member[1000];
    int memberIndex = 0;
    
    public void insert(Member member) {
        member.no = memberIndex;
        this.members[this.memberIndex++] = member;
    }
    
    public Member[] list() {
        Member[] arr = new Member[memberIndex];
        for (int i = 0; i < memberIndex; i++) 
            arr[i] = members[i];
        return arr;
    }
    
    public Member get(int i) {
        if (i < 0 || i >= memberIndex)
            return null;
        return members[i];
    }
    
    public void update(Member member) {
        members[member.no] = member;
    }
    
    public void delete(int i) {
        members[i] = null;
    }
}


