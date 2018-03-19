package bitcamp.java106.pms;

import java.util.Scanner;

import bitcamp.java106.pms.util.Console;
import bitcamp.java106.pms.controller.TeamController_01;
import bitcamp.java106.pms.controller.MemberController_01;
// ver 0.2 - 회원 관리 기능을 별도의 클래로 옮긴다.
//           => controller.MemberController 클래스 추가
// ver 0.1 - 팀 관리 기능(메서드)을 별도의 클래스로 옮긴다.
//           => controller.TeamController 클래스 추가
//           사용자 입력 기능을 별도의 클래스로 옮긴다.
//           => util.Connsole 클래스 추가
public class App_v02 {
    // 클래스 변수 = 스태틱 변수
    // => 클래스 안에서 어디에서나 사용할 수 있는 변수이다.
    static Scanner keyScan = new Scanner(System.in);
    static String option = null;

    
    static void onQuit() {
        System.out.println("안녕히 가십시오!");
    }
    static void onHelp() {
        System.out.println("[도움말]");
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
        TeamController_01.keyScan = keyScan;
        MemberController_01.keyScan = keyScan;
        Console.keyScan = keyScan;
        while (true) {
            String[] arr = Console.prompt();
            String menu = arr[0];
            if (arr.length == 2) {
                option = arr[1];
            } else {
                option = null;
                // # 초기화 해주기
                // 이 전의 입력값이 team/view a 인경우 
                // option에 a값이 들어가는데 
                // 그 후 다시 검색어 없이 team/view만 입력
                // 해 주었을 때 option에 앞전에 넣었던
                // a가 그대로 있어서 
                // "팀명을 입력해 주시기 바랍니다." 라는 
                // 안내가 뜨지 않고 a에 대한 팀정보 조회를 하게 된다.
                // 따라서 option값이 들어가지 않으면
                // 반복문을 돌릴 때 마다 초기화를 해 주어야 한다.
            }
            if (menu.equals("quit")) {
                onQuit();
                break;
            } else if (menu.equals("help")) {
               onHelp();
            } else if (menu.equals("team/add")) {
               TeamController_01.onTeamAdd();
            } else if (menu.equals("team/list")) {
                TeamController_01.onTeamList();          
            } else if (menu.equals("team/view")) {
                TeamController_01.onTeamView(option);
            } else if (menu.equals("team/update")) {
                TeamController_01.onTeamUpdate(option);
            } else if (menu.equals("team/delete")) {
                TeamController_01.onTeamDelete(option);
            } else if (menu.equals("member/add")) {
               MemberController_01.onMemberAdd();
            } else if (menu.equals("member/list")) {
                MemberController_01.onMemberList();
            } else if (menu.equals("member/update")) {
                MemberController_01.onMemberUpdate(option);
            } else if (menu.equals("member/delete")) {
                MemberController_01.onMemberDelete(option);
            } else if (menu.equals("member/view")) {
                MemberController_01.onMemberView(option);
            } else {
                System.out.println("명령어가 올바르지 않습니다.");
            }
            System.out.println();
        }
    }
}