// "팀 관련 기능"을 모아 둔 클래스
package bitcamp.java106.pms.controller;

import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;
import java.util.Scanner;

public class TeamController_01 {
    // 이 클래스를 사용하기 전에 App 클래스에서 준비한 Scanner 객체를
    //  keyScan 변수에 저장하라!
    public static Scanner keyScan;
    static Team[] teams = new Team[1000];
    static int teamIndex = 0;    
    
    // static void service(String menu, String name) {
    //     if (menu.equals("team/add")) {
    //         onTeamAdd();
    //      } else if (menu.equals("team/list")) {
    //          onTeamList();          
    //      } else if (menu.equals("team/view")) {
    //          onTeamView(name);
    //      } else if (menu.equals("team/update")) {
    //          onTeamUpdate(name);
    //      } else if (menu.equals("team/delete")) {
    //          onTeamDelete(name);
    //      } else {
    //          System.out.println("명령어가 올바르지 않습니다.");
    //      }
    // }

    static int getTeamIndex(String name) {
        for (int i = 0; i < teamIndex; i++) {
            if (teams[i] == null) continue;
            if (name.equals(teams[i].name.toLowerCase())) {
                return i;
            }
        }
        return -1;    
    }

    public static void onTeamAdd() {
        System.out.println("[팀 정보 등록]");
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
            // 뒤의 문장을 출력하지 않고 다시 for문을 실행한다.
            System.out.printf("%s, %d, %s ~ %s\n",
            teams[i].name, teams[i].maxQty,
             teams[i].startDate, teams[i].endDate);
        }            
    }
    public static void onTeamView(String name) {
        System.out.println("[팀 정보 조회]");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return;
            // 값을 리턴하면 안되기 때문에 return 명령만 작성한다.
            // 의미 => 즉시 이 위치에서 메서드 실행을 멈추고, 
            //         이전 위치로 돌아간다.
            // 정보조회 기능의 맨 마지막에 오면 continue; 를 메인메소드에서 
            // 사용할 수 있겠지만 중간에 있으므로 return으로 이전 위치로 돌아간다.
        }

        int i = getTeamIndex(name);
        // getTeamIndex 메소드에서 리턴된 i값을 새로운 i에 집어넣는다. 
    
        if (i == -1) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            Team team = teams[i];
            // teams[i] 를 바로 출력해주어도 되지만
            // 새로 선언주는 것이 작성하기에 편하다.
            System.out.printf("팀명: %s\n", team.name);
            System.out.printf("설명: %s\n", team.description);
            System.out.printf("최대인원: %d\n", team.maxQty);
            System.out.printf("기간: %s ~ %s\n", 
            team.startDate, team.endDate);
        }
    }
    public static void onTeamUpdate(String name) {
        System.out.println("[팀 정보 변경]");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return;
            // 값을 리턴하면 안되기 때문에 return 명령만 작성한다.
            // 의미 => 즉시 이 위치에서 메서드 실행을 멈추고, 
            //         이전 위치로 돌아간다.
            // 정보조회 기능의 맨 마지막에 오면 continue; 를 메인메소드에서 
            // 사용할 수 있겠지만 중간에 있으므로 return으로 이전 위치로 돌아간다.
        }

        int i = getTeamIndex(name);
        
        if (i == -1) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            Team team = teams[i];
            Team updateTeam = new Team();
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
    public static void onTeamDelete(String name) {
        System.out.println("[팀 정보 삭제]");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return;
            // 값을 리턴하면 안되기 때문에 return 명령만 작성한다.
            // 의미 => 즉시 이 위치에서 메서드 실행을 멈추고, 
            //         이전 위치로 돌아간다.
            // 정보조회 기능의 맨 마지막에 오면 continue; 를 메인메소드에서 
            // 사용할 수 있겠지만 중간에 있으므로 return으로 이전 위치로 돌아간다.
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