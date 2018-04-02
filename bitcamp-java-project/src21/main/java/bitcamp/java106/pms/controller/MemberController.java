// 이 클래스는 회원 관련 기능을 모두 둔 클래스이다.
// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.util.Console;
import bitcamp.java106.pms.dao.MemberDao;
import java.util.Scanner;

// MemberController는 Controller 규칙을 이행한다.
//=> Controller 규칙에 따라 메서드를 만든다.
public class MemberController implements Controller { // 의존객체 -> MemberDao()가 없으면 안된다.
    Scanner keyScan;
    MemberDao memberDao;
    
    public MemberController(Scanner scanner, MemberDao memberDao) {
        this.keyScan = scanner;
        this.memberDao = memberDao;
    }

    public void service(String menu, String option) {
        if (menu.equals("member/add")) {
            this.onMemberAdd();
        } else if (menu.equals("member/list")) {
            this.onMemberList();
        } else if (menu.equals("member/view")) {
            this.onMemberView(option);                
        } else if (menu.equals("member/update")) {
            this.onMemberUpdate(option);                
        } else if (menu.equals("member/delete")) {
            this.onMemberDelete(option);                
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    void onMemberAdd() {
        System.out.println("[회원 정보 입력]");
        Member member = new Member();
        
        System.out.print("아이디? ");
        member.setId(this.keyScan.nextLine());

        System.out.print("이메일? ");
        member.setEmail(this.keyScan.nextLine());

        System.out.print("암호? ");
        member.setPassword(this.keyScan.nextLine());

        // 입력받은 멤버객체를 insert메서드에 넘겨준다.
        // insert 메서드가 입력받은 객체를 새 인덱스의 배열에 넣어주고
        // 인덱스 값은 +1한다.
        memberDao.insert(member);
    }

    void onMemberList() {
        System.out.println("[회원 목록]");
        // list메서드에서 멤버가 들어있는 갯수만큼 반복해서
        // 새로운 배열 arr에 집어넣어주고 그 주소값을 반환해 주면
        // list라는 Member[]배열 타입의 변수에 넣어준다.
        // 그리고, 그것을 list 배열의 길이만큼 반복하여 출력해준다.
        Member[] list = memberDao.list();
        for (int i = 0; i < list.length; i++) {
            System.out.printf("%s, %s, %s\n", 
                    list[i].getId(), list[i].getEmail(), list[i].getPassword());
        }
    }

    void onMemberView(String id) {
        System.out.println("[회원 정보 조회]");
        if (id == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            return;
        }
        
        Member member = memberDao.get(id);
        // 입력받은 id값을 넘겨주면 get메서드에서는 이 값을
        // getMemberIndex 메서드에 넘겨주고, 같은 값을 가진 배열을
        // 찾아 존재하면 그 배열의 인덱스 값을 다시 get메소드의 i변수에
        // 저장한다.
        // 그리고 그 인덱스에 해당하는 배열의 값을 받아온다.
        // 만약 id가 같은 값을 가진 배열이 없으면 null 값을 반환한다.
        if (member == null) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            System.out.printf("아이디: %s\n", member.getId());
            System.out.printf("이메일: %s\n", member.getEmail());
            System.out.printf("암호: %s\n", member.getPassword());
        }
    }

    void onMemberUpdate(String id) {
        System.out.println("[회원 정보 변경]");
        if (id == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            return;
        }

        Member member = memberDao.get(id);
        
        if (member == null) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            Member updateMember = new Member();
            System.out.printf("아이디: %s\n", member.getId()); // 따로 입력 받지 않고 고정시켜 버린다.
            updateMember.setId(member.getId());
            System.out.printf("이메일(%s)? ", member.getEmail());
            updateMember.setEmail(this.keyScan.nextLine());
            System.out.printf("암호? ");
            updateMember.setPassword(this.keyScan.nextLine());
            
            // 새로 변경하는 객체의 주소를 넘겨주면
            // 이 객체의 id값과 동일한 값을 가지는 배열을 찾아
            // 그 배열에 새로 변경하는 객체의 주소를 저장한다.
            memberDao.update(updateMember);
            System.out.println("변경하였습니다.");
        }
    }

    void onMemberDelete(String id) {
        System.out.println("[회원 정보 삭제]");
        if (id == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            return;
        }
        
        Member member = memberDao.get(id);
        // 입력받은 id값과 같은 값을 가지는 배열을 넘겨준다.
        
        if (member == null) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                memberDao.delete(id);
                // 입력받은 id값과 같은 값을 가지는 배열을 찾아
                // 존재한다면 그 배열의 주소를 null로 바꿔준다.
                System.out.println("삭제하였습니다.");
            }
        }
    }
    
}
