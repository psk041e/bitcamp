// 팀 관련 기능을 모아 둔 클래스
package bitcamp.java106.pms.controller;

import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.util.Console;
import java.util.Scanner;

public class TeamController {
    // 이 클래스를 사용하기 전에 App 클래스에서 준비한 Scanner 객체를
    // keyScan 변수에 저장하라!
    public static Scanner keyScan; // 외부에서 접근 해야 하는것만 공개한다.

    static Team[] teams = new Team[1000]; 
    static int teamIndex = 0;

    static int getTeamIndex(String name) { 
        // 내부에서 쓰는 메소드 -> 공개하지 않는다.
        for (int i = 0; i < teamIndex; i++) {
            if (teams[i] == null) continue; 
            if (name.equals(teams[i].name.toLowerCase())) {
                return i; 
            }
        }
        return -1; 
        // -1이라는 인덱스 값은 없다. -> -1 을 못 찾았다는 의미로 사용한다.
    }
    public static void onTeamAdd() { 
        // 당장 App이라는 클래스에서 사용하기 때문에 공개해준다.
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
    
    public static void onTeamList() {
        System.out.println("[팀 목록]");
        for (int i = 0; i < teamIndex; i++) {
            if (teams[i] == null) continue; 
            System.out.printf("%s, %d, %s ~ %s\n", 
            teams[i].name, teams[i].maxQty,
            teams[i].startDate, teams[i].endDate );
        }
    }

    public static void onTeamView(String name) {
        // 어떤 메소드를 호출해야 하는데 그 메소드의 코드를 실행해야 하는데
        // 참조를 하지 않고 파라미터를 받아오면 사용가능하다(?)
        System.out.println("[팀 정보 조회]");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        int i = getTeamIndex(name);

        if (i == -1) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            Team team = teams[i];
            System.out.printf("팀명 : %s\n", team.name);
            System.out.printf("설명 : %s\n", team.description);
            System.out.printf("최대인원 : %d\n", team.maxQty);
            System.out.printf("기간 : %s ~ %s\n",
                team.startDate, team.endDate);
        }
    }

    public static void onTeamUpdate(String name) {
        // 어떤 메소드를 호출해야 하는데 그 메소드의 코드를 실행해야 하는데
        // 참조를 하지 않고 파라미터를 받아오면 사용가능하다(?)
        System.out.println("[팀 정보 변경]");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }

        int i = getTeamIndex(name);

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

    public static void onTeamDelete(String name) {
        // 어떤 메소드를 호출해야 하는데 그 메소드의 코드를 실행해야 하는데
        // 참조를 하지 않고 파라미터를 받아오면 사용가능하다(?)
        System.out.println("[팀 정보 삭제]");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
       int i = getTeamIndex(name);

        if (i == -1) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                teams[i] = null;
                System.out.println("삭제하였습니다.");
            }
        }
    }
}