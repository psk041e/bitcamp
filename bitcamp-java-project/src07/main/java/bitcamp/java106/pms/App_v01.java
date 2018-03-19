package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.domain.Member;
import java.util.Scanner;

// ver 0.1 - 팀명으로 배열에서 팀 정보를 찾는 코드를 함수로 분리한다.
//           => getTeamIndex() 추가
//           회원아이디로 배열에서 회원 정보를 찾는 코드를 함수로 분리한다.
//           => getMemberIndex() 추가

public class App_v01 {
    static Scanner keyScan = new Scanner(System.in);
    
    static Team[] teams = new Team[1000]; 
    static int teamIndex = 0;
    static Member[] members = new Member[1000];
    static int memberIndex = 0;
    static String option = null; 
    
    static int getTeamIndex(String name) {
        for (int i = 0; i < teamIndex; i++) {
            if (teams[i] == null) continue; 
            if (name.equals(teams[i].name.toLowerCase())) {
                return i; 
            }
        }
        return -1; 
        // -1이라는 인덱스 값은 없다. -> -1 을 못 찾았다는 의미로 사용한다.
    }

    static int getMemberIndex(String id) {
        for (int i = 0; i < memberIndex; i++) {
            if (members[i] == null) continue;
            if (id.equals(members[i].id.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }


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
            if (teams[i] == null) continue; 
             // 뒤의 문장을 출력하지 않고 다시 for문을 실행한다.
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
            // 값을 리턴하면 안되기 때문에 return 명령만 작성한다.
            // 의미 => 즉시 이 위치에서 메서드 실행을 멈추고, 
            //         이전 위치로 돌아간다.
            // 정보조회 기능의 맨 마지막에 오면 continue; 를 메인메소드에서 
            // 사용할 수 있겠지만 중간에 있으므로 return으로 이전 위치로 돌아간다.
        }
        int i = getTeamIndex(option);
        // getTeamIndex 메소드에서 리턴된 i값을 새로운 i에 집어넣는다. 

        if (i == -1) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            Team team = teams[i];
            // teams[i] 를 바로 출력해주어도 되지만
            // 새로 선언주는 것이 작성하기에 편하다.
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
            // 값을 리턴하면 안되기 때문에 return 명령만 작성한다.
            // 의미 => 즉시 이 위치에서 메서드 실행을 멈추고, 
            //         이전 위치로 돌아간다.
            // 정보조회 기능의 맨 마지막에 오면 continue; 를 메인메소드에서 
            // 사용할 수 있겠지만 중간에 있으므로 return으로 이전 위치로 돌아간다.
        }

        int i = getTeamIndex(option);

        if (i == -1) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            Team team = teams[i];
            Team updateTeam = new Team(); 
            // 유지보수를 하기위해 새로 객체를 만들어 주어야 한다.
            System.out.printf("팀명(%s)? ", team.name);
            updateTeam.name = keyScan.nextLine();
            System.out.printf("설명(%s)? ", team.description);
            updateTeam.description = keyScan.nextLine();
            System.out.printf("최대인원? ", team.maxQty);
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
        System.out.println("[팀 정보 삭제]");
        if (option == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
       int i = getTeamIndex(option);

        if (i == -1) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            System.out.print("정말 삭제하시겠습니까?(y/N) ");
            // N가 대문자로 쓰이는 경우 보통 아무 값도 입력하지
            // 않았을때 N으로 인식하고 삭제 명령을 실행하지 않는다.
            // 만약 입력하지 않고 그냥 enter를 치면 yes를 입력한것과 똑같다.
            String input = keyScan.nextLine().toLowerCase();
            if (input.equals("y")) {
                teams[i] = null;
                System.out.println("삭제하였습니다.");
            }
        }
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
            if (members[i] == null) continue;
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
    
        int i = getMemberIndex(option);

        if (i == -1) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            Member member = members[i];
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
        
        int i = getMemberIndex(option);

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

    static void onMemberDelete() {
        System.out.println("[회원 정보 삭제]");
        if (option == null) {
            System.out.println("회원 아이디를 입력하시기 바랍니다.");
            return; 
        }
        
        int i = getMemberIndex(option);

        if (i == -1) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            System.out.print("정말 삭제하시겠습니까?(y/N) ");
            // 만약 입력하지 않고 그냥 enter를 치면 yes를 입력한것과 똑같다.
            String input = keyScan.nextLine().toLowerCase();
            if (input.equals("y")) {
                members[i] = null;
                System.out.println("삭제하였습니다.");
            }
        }
    }
 
    public static void main(String[] args) {
        while(true) {   
            String[] arr = prompt();
            String menu = arr[0];
            if (arr.length ==2) {
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