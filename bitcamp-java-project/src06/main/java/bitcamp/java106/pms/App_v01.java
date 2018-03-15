package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.domain.Member;
import java.util.Scanner;

// ver 0.1 - 팀 변경, 회원 변경 기능 추가

public class App_v01 {
    static Scanner keyScan = new Scanner(System.in);
    
    static Team[] teams = new Team[1000]; 
    static int teamIndex = 0;
    static Member[] members = new Member[1000];
    static int memberIndex = 0;
    static String option = null; 
    
    static String[] prompt() {
        System.out.print("명령> ");
        return keyScan.nextLine().toLowerCase().split(" ");
    }

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
    
    static void onTeamAdd() {
        System.out.println("[팀 정보 입력]");
        Team team = new Team();
        System.out.print("팀명? ");
        team.name = keyScan.nextLine();
    
        System.out.print("설명? ");
        team.description = keyScan.nextLine();
    
        System.out.print("최대인원? ");
        team.maxQty = keyScan.nextInt();
        keyScan.nextLine(); 
    
        System.out.print("시작일? ");
        team.startDate = keyScan.nextLine();
    
        System.out.print("종료일? ");
        team.endDate = keyScan.nextLine();
    
        teams[teamIndex++] = team;
    }
    
    static void onTeamList() {
        System.out.println("[팀 목록]");
        for (int i = 0; i < teamIndex; i++) {
            System.out.printf("%s, %d, %s ~ %s\n", 
            teams[i].name, teams[i].maxQty,
            teams[i].startDate, teams[i].endDate );
        }
    }

    static void onTeamView() {
        System.out.println("[팀 정보 조회]");
        if (option == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        Team team = null;
        for (int i = 0; i < teamIndex; i++) {
            if (option.equals(teams[i].name.toLowerCase())) {
                team = teams[i];
                break;
            }
        }
        if (team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            System.out.printf("팀명 : %s\n", team.name);
            System.out.printf("설명 : %s\n", team.description);
            System.out.printf("최대인원 : %d\n", team.maxQty);
            System.out.printf("기간 : %s ~ %s\n",
                team.startDate, team.endDate);
        }
    }

    static void onTeamUpdate() {
        System.out.println("[팀 정보 변경]");
        if (option == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }

        Team team = null;
        int i;  // i : 현재 업데이트 할 팀 주소가 들어있다.
        for (i = 0; i < teamIndex; i++) {
            if (option.equals(teams[i].name.toLowerCase())) {
                team = teams[i];
                break;
            }
        }

        if (team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            Team updateTeam = new Team(); 
            // 유지보수를 하기위해 새로 객체를 만들어 주어야 한다.
            System.out.printf("팀명(%s)? ", team.name);
            updateTeam.name = keyScan.nextLine();
            System.out.printf("설명(%s)? ", team.description);
            updateTeam.description = keyScan.nextLine();
            System.out.printf("최대인원(%d)? ", team.maxQty);
            updateTeam.maxQty = keyScan.nextInt();
            keyScan.nextLine();
            System.out.printf("시작일(%s)? ", team.startDate);
            updateTeam.startDate = keyScan.nextLine();
            System.out.printf("종료일(%s)? ", team.endDate);
            updateTeam.endDate = keyScan.nextLine();
            teams[i] = updateTeam;
            System.out.println("변경하였습니다.");

        }
    }

    static void onTeamDelete() {

    }

    static void onMemberAdd() {
        System.out.println("[회원 정보 입력]");
                Member member = new Member();
                System.out.print("아이디? ");
                member.id = keyScan.nextLine();
        
                System.out.print("이메일? ");
                member.email = keyScan.nextLine();
        
                System.out.print("암호? ");
                member.password = keyScan.nextLine();

                members[memberIndex++] = member;
    }

    static void onMemberList() {
        System.out.println("[회원 목록]");
        for (int i = 0; i < memberIndex; i++) {
            System.out.printf("%s, %s, %s\n", 
            members[i].id, members[i].email, members[i].password);
        }
    }

    static void onMemberView() {
        System.out.println("[회원 정보 조회]");
        if (option == null) {
            System.out.println("회원 아이디를 입력하시기 바랍니다.");
            return; 
        }
        Member member = null;
        for (int i = 0; i < memberIndex; i++) {
            if (option.equals(members[i].id.toLowerCase())) {
                member = members[i];
                break;
            }
        }
        if (member == null) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            System.out.printf("아이디 : %s\n", member.id);
            System.out.printf("이메일 : %s\n", member.email);
            System.out.printf("암호 : %s\n", member.password);
        }
    }

    static void onMemberUpdate() {
        System.out.println("[회원 정보 조회]");
        if (option == null) {
            System.out.println("회원 아이디를 입력하시기 바랍니다.");
            return; 
        }
        Member member = null;
        int i;
        for (i = 0; i < memberIndex; i++) {
            if (option.equals(members[i].id.toLowerCase())) {
                member = members[i];
                break;
            }
        }
        if (member == null) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
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

    static void onMemberDelete() {

    }
 
    public static void main(String[] args) {
        while(true) {   
            String[] arr = prompt();
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
                onTeamAdd();                
            } else if (menu.equals("team/list")) {
                onTeamList();                
            } else if (menu.equals("team/view")) {
                onTeamView();
            } else if (menu.equals("team/update")) {
                onTeamUpdate();
            } else if (menu.equals("team/delete")) {
                onTeamDelete();
            } else if (menu.equals("member/add")) {
                onMemberAdd();
            } else if (menu.equals("member/list")) {
               onMemberList();
            } else if (menu.equals("member/view")) {
                onMemberView();
            } else if (menu.equals("member/update")) {
                onMemberUpdate();
            } else if (menu.equals("member/delete")) {
                onMemberDelete();
            } else {
                System.out.println("명령어가 올바르지 않습니다.");
            }
            System.out.println();
        }
    }
}