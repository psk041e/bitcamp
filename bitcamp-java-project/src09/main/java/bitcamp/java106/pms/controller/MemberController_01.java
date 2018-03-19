// 이 클래스는 회원 관련 기능을 모아 둔 클래스이다.
package bitcamp.java106.pms.controller;

import java.util.Scanner;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.util.Console;

public class MemberController_01 {
    public static Scanner keyScan;

    static Member[] members = new Member[1000];
    static int memberIndex = 0;

    static int getMemberIndex(String id) {
        for (int i = 0; i < memberIndex; i++) {
            if (members[i] == null) continue;
            if (id.equals(members[i].id.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    // public static void service(String name, String option) {
    //     if (menu.equals("member/add")) {
    //         onMemberAdd();
    //     } else if (menu.equals("member/list")) {
    //         onMemberList();
    //     } else if (menu.equals("member/view")) {
    //         onMemberView(option);                
    //     } else if (menu.equals("member/update")) {
    //         onMemberUpdate(option);                
    //     } else if (menu.equals("member/delete")) {
    //         onMemberDelete(option);                
    //     } else {
    //         System.out.println("명령어가 올바르지 않습니다.");
    //     }
    // }
    
    public static void onMemberAdd() {
        System.out.println("[회원 정보 등록]");
        Member member = new Member();
        System.out.print("아이디? ");
        member.id = keyScan.nextLine();
        System.out.print("이메일? ");
        member.email = keyScan.nextLine();
        System.out.print("암호? ");
        member.password = keyScan.nextLine();
        members[memberIndex++] = member;
    }
    public static void onMemberList() {
        System.out.println("[회원 목록]");
        for (int i = 0; i < memberIndex; i++) {
            if (members[i] == null) continue;
            System.out.printf("%s, %s, %s\n", 
            members[i].id, members[i].email, members[i].password);
        }
    }
    public static void onMemberView(String id) {
        System.out.println("[회원 정보 조회]");
        if (id == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            return;
        }
       
        int i = getMemberIndex(id);
        
        if (i == -1) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            Member member = members[i];
            System.out.printf("아이디 : %s\n", member.id);
            System.out.printf("이메일 : %s\n", member.email);
            System.out.printf("암호 : %s\n", member.password);
        }
    }
    public static void onMemberUpdate(String id) {
        System.out.println("[회원 정보 업데이트]");
        if (id == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            return;
        }
        
        int i = getMemberIndex(id);

        if (i == -1) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            Member member = members[i];
            Member updateMember = new Member();
            System.out.printf("아이디(%s)? ", member.id);
            updateMember.id = keyScan.nextLine();
            System.out.printf("이메일(%s)? ", member.email);
            updateMember.email = keyScan.nextLine();            
            System.out.printf("암호? ", member.password);
            updateMember.password = keyScan.nextLine();
            members[i] = updateMember;
            System.out.println("변경하였습니다.");
        }
    }
    public static void onMemberDelete(String id) {
        System.out.println("[회원 정보 삭제]");
        if (id == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            return;
        }

        int i = getMemberIndex(id);
        
        if (i == -1) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            if(Console.confirm("정말 삭제하시겠습니까?")) {
                members[i] = null;
                System.out.println("삭제하였습니다.");
            }
        }
    }




}