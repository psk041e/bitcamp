// 팀 멤버 관리 기능을 모아둔 클래스
package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;

public class TeamMemberController {
    
    Scanner keyScan;
    TeamDao teamDao; // 자체적으로 만들지 않도록 해주고 생성할때 반드시 넘기도록 한다.
    MemberDao memberDao;
    
    //TeamDao teamDao = new TeamDao();
    // App에서 한번만 new해주어야 한다.
    
    public TeamMemberController(Scanner scanner, TeamDao teamDao, MemberDao memberDao) {
        this.keyScan = scanner;
        this.teamDao = teamDao;
        this.memberDao = memberDao;
    }
    
    public void service(String menu, String option) {
        if (menu.equals("team/member/add")) {
            this.onTeamMemberAdd(option);
        } else if (menu.equals("team/member/list")) {
            this.onTeamMemberList(option);
        } else if (menu.equals("team/member/delete")) {
            this.onTeamMemberDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    void onTeamMemberAdd(String teamName) {
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
            return; // void 이기 때문에 return 다음에 값을 주지 않는다.
        }
        
        System.out.println("[팀 멤버 추가]");
        System.out.print("추가할 멤버의 아이디는? ");
        String memberId = keyScan.nextLine();
        
        Member member = memberDao.get(memberId);
        if (member == null) {
            System.out.printf("%s 회원은 없습니다.\n", memberId);
            return;
        }
            
        if (team.isExist(memberId)) {
            System.out.println("이미 등록된 회원입니다.");
            return;
        } 
        
        team.addMember(member);
        
    }

    // 팀 멤버 목록
    void onTeamMemberList(String teamName) { 
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(teamName); // 팀 이름으로 팀 정보를 찾는다.
        if (team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
            return; // void 이기 때문에 return 다음에 값을 주지 않는다.
        }
        
        System.out.println("[팀 멤버 목록]");
        System.out.print("회원들: ");
        
        Member[] members = team.getMembers();
        
        for (int i = 0; i < members.length; i++) {
            if (members[i] == null) continue;
            System.out.printf("%s, ", members[i].getId());
        }
        System.out.println();
    }

    
    void onTeamMemberDelete(String teamName) {
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
            return;
        }
        
        System.out.print("삭제할 팀원은? ");
        String memberId = keyScan.nextLine();
        
        if (!team.isExist(memberId)) {
            System.out.println("이 팀의 회원이 아닙니다.");
            
        }
        System.out.println("[팀 멤버 삭제]");
    }
}

// ver 15 - 팀 멤버를 등록, 조회, 삭제할 수 있는 기능 추가.