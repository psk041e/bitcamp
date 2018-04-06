package bitcamp.java106.pms;

import java.sql.Date;
import java.util.HashMap;
import java.util.Scanner;

import bitcamp.java106.pms.context.ApplicationContext;
import bitcamp.java106.pms.controller.BoardController;
import bitcamp.java106.pms.controller.ClassroomController;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.controller.MemberController;
import bitcamp.java106.pms.controller.TaskController;
import bitcamp.java106.pms.controller.TeamController;
import bitcamp.java106.pms.controller.TeamMemberController;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;

public class App {
    
    static ApplicationContext iocContainer;
    
    static Scanner keyScan = new Scanner(System.in);
    public static String option = null; 
    
    static void onQuit() {
        System.out.println("안녕히 가세요!");
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

    public static void main(String[] args) throws Exception {
    
        // 기본 객체 준비
        HashMap<String,Object> defaultBeans = new HashMap<>();
        defaultBeans.put("java.util.Scanner", keyScan);
        
        // 기본 객체와 함께 @Component가 붙은 클래스의 객체를 준비한다.
        iocContainer = new ApplicationContext(
                "bitcamp.java106.pms", defaultBeans);
        
        // 테스트용 데이터를 준비하도록 다음 메서드를 호출한다.
        prepareMemberData();
        prepareTeamData();
        
        Console.keyScan = keyScan;

        while (true) {
            String[] arr = Console.prompt();

            String menu = arr[0];
            if (arr.length == 2) {
                option = arr[1];
            } else {
                option = null;
            }

            if (menu.equals("quit")) {
                onQuit();
                break;
            } else if (menu.equals("help")) {
                onHelp();
            } else {
                int slashIndex = menu.lastIndexOf("/"); // 맨 끝에서부터 /인덱스를 찾아라
                String controllerKey = menu.substring(0, slashIndex); // 0부터 slashIndex 바로 전까지 잘라라
                Controller controller = (Controller) iocContainer.getBean(controllerKey);
                
                if (controller != null) {
                    controller.service(menu, option); 
                // controller에 담겨져 있는것은 입력받은 option에대한 XxxCnotroller의 주소이다.
                }else {
                    System.out.println("명령어가 올바르지 않습니다.");
                }
            } }
    }
    
    static void prepareMemberData() {
        MemberDao memberDao = (MemberDao) iocContainer.getBean(
                "bitcamp.java106.pms.dao.MemberDao");
        
        Member member = new Member();
        member.setId("aaa");
        member.setEmail("aaa@test.com");
        member.setPassword("1111");
        
        memberDao.insert(member);
        
        member = new Member();
        member.setId("bbb");
        member.setEmail("bbb@test.com");
        member.setPassword("1111");
        
        memberDao.insert(member);
        
        member = new Member();
        member.setId("ccc");
        member.setEmail("ccc@test.com");
        member.setPassword("1111");
        
        memberDao.insert(member);
        
        member = new Member();
        member.setId("ddd");
        member.setEmail("ddd@test.com");
        member.setPassword("1111");
        
        memberDao.insert(member);
        
        member = new Member();
        member.setId("eee");
        member.setEmail("eee@test.com");
        member.setPassword("1111");
        
        memberDao.insert(member);
        
    }
    static void prepareTeamData() {
        
        TeamDao teamDao = (TeamDao) iocContainer.getBean(
                "bitcamp.java106.pms.dao.TeamDao");
        TeamMemberDao teamMemberDao = (TeamMemberDao) iocContainer.getBean(
                "bitcamp.java106.pms.dao.TeamMemberDao");
        
        Team team = new Team();
        team.setName("t1");
        team.setMaxQty(5);
        team.setStartDate(Date.valueOf("2018-1-1"));
        team.setEndDate(Date.valueOf("2018-5-30"));
        teamDao.insert(team);
        teamMemberDao.addMember("t1", "aaa");
        teamMemberDao.addMember("t1", "bbb");
        teamMemberDao.addMember("t1", "ccc");
        
        team = new Team();
        team.setName("t2");
        team.setMaxQty(5);
        team.setStartDate(Date.valueOf("2018-2-1"));
        team.setEndDate(Date.valueOf("2018-6-30"));
        teamMemberDao.addMember("t2", "ccc");
        teamMemberDao.addMember("t2", "ddd");
        teamMemberDao.addMember("t2", "eee");
        teamDao.insert(team);
    }
    
}

// ver 15 - TeamDao MemberDao를 다루는 메뉴 추가.