// 팀 멤버 관리 기능을 모아둔 클래스
package bitcamp.java106.pms.controller;

import java.util.Scanner;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;

public class TeamMemberController {
    
    Scanner keyScan;
    TeamDao teamDao; // 자체적으로 만들지 않도록 해주고 생성할때 반드시 넘기도록 한다.
    MemberDao memberDao;
    TeamMemberDao teamMemberDao;
    
    //TeamDao teamDao = new TeamDao();
    // App에서 한번만 new해주어야 한다.
    
    public TeamMemberController(Scanner scanner, TeamDao teamDao, 
            MemberDao memberDao, TeamMemberDao teamMemberDao) {
        this.keyScan = scanner;
        this.teamDao = teamDao;
        this.memberDao = memberDao;
        this.teamMemberDao = teamMemberDao;
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
            
        if (teamMemberDao.isExist(teamName, memberId)) {
            System.out.println("이미 등록된 회원입니다.");
            return;
        } 
        
        teamMemberDao.addMember(teamName, memberId);
        
    }

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
        
        String[] members = teamMemberDao.getMembers(teamName);
        
        for (int i = 0; i < members.length; i++) {
            if (members[i] == null) continue;
            System.out.printf("%s, ", members[i]);
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
        
        if (!teamMemberDao.isExist(teamName, memberId)) {
            System.out.println("이 팀의 회원이 아닙니다.");
            return;
        }
        
        teamMemberDao.deleteMember(teamName, memberId);
        
        System.out.println("[팀 멤버 삭제]");
        System.out.println("삭제하였습니다.");
    }
}


// ver 18 - ArrayList가 적용된 TeamMemberDao를 사용한다.
// ver 17 - TeamMemberDao 클래스르 사용하여 팀 멤버의 아이디를 관리한다.
// ver 15 - 팀 멤버를 등록, 조회, 삭제할 수 있는 기능 추가.