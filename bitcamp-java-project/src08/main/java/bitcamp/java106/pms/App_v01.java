package bitcamp.java106.pms;

import bitcmap.java101.pms.controller.MemberController;
import bitcamp.java106.pms.controller.TeamController;
import bitcamp.java106.pms.util.Console;
import java.util.Scanner;

// ver 0.1 - 팀관리 기능(메서드)을 별도의 클래스로 옮긴다.
//           => => controller.TeamController 클래스 추가

public class App_v01 {
    static Scanner keyScan = new Scanner(System.in);
    static String option = null; 
    // public static String option = null; 
    // -> 쌍방참조가 되어 파일을 수정할 때 서로 무한으로 영향을 받는 일이 생긴다.
    
    static void onQuit() {
        System.out.println("안녕히 가세요!");
    }
    
    static void onHelp() {
        System.out.println("도움말");
        System.out.println("팀 등록 명령 : team/add");
        System.out.println("팀 조회 명령 : team/list");
        System.out.println("팀 상세조회 명령 : team/view 팀명");
        System.out.println("회원 등록 명령 : member/add");
        System.out.println("회원 조회 명령 : member/list");
        System.out.println("회원 상세조회 명령 : member/view 아이디");
        System.out.println("종료 : quit");
    }
 
    public static void main(String[] args) {
        // 클래스를 사용하기 전에 필수 값을 설정한다.
        TeamController.keyScan = keyScan;
        MemberController.keyScan = keyScan;
        Console.keyScan = keyScan;
        // 자신이 가지고 있는 keyScan을 컨트롤러의 keyScan에 넘겨준다.
        while(true) {   
            String[] arr = Console.prompt();
            String menu = arr[0];
            if (arr.length ==2) {
                option = arr[1];
            } else {
                option = null;
            }
            if (menu.equals("quit")) {
                onQuit();
                break;
            } else if(menu.equals("help")) {
                onHelp();
            } else if (menu.equals("team/add")) {
                TeamController.onTeamAdd();                
            } else if (menu.equals("team/list")) {
                TeamController.onTeamList();                
            } else if (menu.equals("team/view")) {
                TeamController.onTeamView(option);
            } else if (menu.equals("team/update")) {
                TeamController.onTeamUpdate(option);
            } else if (menu.equals("team/delete")) {
                TeamController.onTeamDelete(option);
            } else if (menu.equals("member/add")) {
                MemberController.onMemberAdd();
            } else if (menu.equals("member/list")) {
                MemberController.onMemberList();
            } else if (menu.equals("member/view")) {
                MemberController.onMemberView(option);
            } else if (menu.equals("member/update")) {
                MemberController.onMemberUpdate(option);
            } else if (menu.equals("member/delete")) {
                MemberController.onMemberDelete(option);
            } else {
                System.out.println("명령어가 올바르지 않습니다.");
            }
            System.out.println();
        }
    }
}