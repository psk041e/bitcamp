// 팀 작업 관리 기능을 모아둔 클래스
// * 객체지향은 보수적으로 해라 -> 공개할 것이 아니면 일단 private해라
package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;

public class TaskController {
    
    Scanner keyScan;
    TeamDao teamDao; 
    TaskDao taskDao;
    MemberDao memberDao;
    TeamMemberDao teamMemberDao;
    
    public TaskController(Scanner scanner, TeamDao teamDao, 
            TaskDao taskDao, MemberDao memberDao, TeamMemberDao teamMemberDao) {
        this.keyScan = scanner;
        this.teamDao = teamDao;
        this.taskDao = taskDao;
        this.memberDao = memberDao;
        this.teamMemberDao = teamMemberDao;
    } // 내가 만든 클래스를 잘못 쓰지 않도록 제약을 가해주어야 프로그램을 안정적으로 만들 수 있다.
      // TaskController.java와 App.java을 서로 다른 개발자가 개발하는 경우
      // App.java를 만드는 개발자가 반드시 입력받아야 하는 값을 무시하고 개발할 수 있다.
      // 따라서 생성자에서 값을 꼭 넣어주도록 만들면
      // App.java를 만드는 개발자는 객체를 생성할 때
      // TaskController taskController = new TaskController(keyScan, teamDao);
      // 의 괄호 안에 들어가는 값에 대해 한번 더 생각하고 신중하게 집어넣게 된다.
    
    public void service(String menu, String option) {
        if (option == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(option);
        // 입력 받은 option값(team)과 동일한 팀명이 있는 배열이 존재한다면 
        // 그 배열의 값을 리턴하라
        
        
        
        if (team == null) {
            System.out.printf("'%s' 팀은 존재하지 않습니다.", option);
            return; 
        }
        
        if (menu.equals("task/add")) {
            this.onTaskAdd(team);
        } else if (menu.equals("task/list")) {
            this.onTaskList(team);
        } else if (menu.equals("task/view")) {
             this.onTaskView(team);
        } else if (menu.equals("task/update")) {
             this.onTaskUpdate(team);
        } else if (menu.equals("task/delete")) {
            this.onTaskDelete(team);
        } else if (menu.equals("task/state")) {
             this.onTaskState(team);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    private void onTaskAdd(final Team team) { 
        // 파라미터 값을 받을 때 한번 값이 고정된다.
        // 당장 이 변수에 있는 주소값을 바꾸지 못한다.
        // 작업을 만들 때 어느 팀에 소속된 작업이냐?
        // 혹시나 변경할 것을 딱딱하게, 보수적으로, 유연성 없이 막아버리는 것이다.
        // 파라미터 변수를 혹시 자신이 아닌 다른 개발자가 손대지 못하게 하기 위해, 오류를 막기 위해 사용한다.
        
        Task task = new Task(team); 

        System.out.println("[팀 작업 추가]");
        System.out.print("작업명? ");
        task.setTitle(keyScan.nextLine());
        
        System.out.print("시작일? ");
        String str = keyScan.nextLine(); 
        // 입력하지 않고 그냥 enter를 치더라도 String객체를 만들어낸다.
        // null이 아니다. -> 빈 문자열
        // 따라서 문자 길이가 없으면 팀 시작일을 사용하고 입력받은 값이 있으면 그 입력값을 Date형으로 집어넣는다.
        if (str.length() == 0) {
            task.setStartDate(team.getStartDate());
            // 입력받은 날짜값이 없다면 원래의 날짜값으로 출력한다.
        } else {
            Date date = Date.valueOf(str); 
            // String형으로 받은 데이터를 Date타입의 데이터로 형변환 해
            // Date 타입의 변수에 넣어준다.
            if (date.getTime() < team.getStartDate().getTime()) { 
                // getTime() - 날짜를 밀리초로 비교해준다.
                //             => Date object가 "January 1, 1970, 00:00:00 GMT"부터 
                //                몇 밀리초나 지났는지 리턴해주는 역할을 하는 것 이다.
                // 입력받은 날짜값과 팀 시작일의 날짜값을 밀리초롤 비교해서
                // 입력받은 시작일이 팀 시작일 보다 이전이면 팀 시작일을 넣어준다.
                task.setStartDate(team.getStartDate());
            } else {
                task.setStartDate(date);
            }
        }
        
        System.out.print("종료일? ");
        str = keyScan.nextLine();
        if (str.length() == 0) {
            task.setEndDate(team.getEndDate());
        } else {
            Date date = Date.valueOf(str);
            if (date.getTime() > team.getEndDate().getTime()) { 
                // 날짜를 밀리초로 비교해준다.
                // 팀 종료일이 입력받은 날짜보다 이후이면 팀 종료일을 넣어준다.
                task.setEndDate(team.getEndDate());
            } else {
                task.setEndDate(date);
            }
        }
        
        System.out.print("작업자 아이디? ");
        String memberId = keyScan.nextLine();
        if (memberId.length() != 0) {
            // task.setWorker(null); // 아무 값도 들어오지 않으면 어차피 null값이 저장되어 있으므로  != 연산을 사용한다.
                                     // 레퍼런스 변수는 아무런 값도 넣지 않으면 모두 null로 초기화 된다.
                                     // -> 사용자가 아무런 값도 입력하지 않았을때는 문제가 없다.
                                     // but! 사용자가 어떤 값을 집어넣었을때 검사를 해 주어야 한다.  
            if (!teamMemberDao.isExist(team.getName(), memberId)) {
                System.out.printf("'%s'는 팀의 회원이 아닙니다. 이 작업자는 비워두겠습니다.\n", memberId);
            } else {
                task.setWorker(this.memberDao.get(memberId));
            }
        }
        
        // System.out.println(task);
        // 어떤 클래스도 상속받지 않은 모든 클래스는 Object 클래스를 상속받게 된다.
        // println()에 String이 아닌 객체를 넘기면,
        // println()에서 내부적으로 그 객체에 대해 toString()을 호출하여 그 리턴값을 출력한다.
        // 따라서 위의 코드는 아래와 같은 결과를 가진다.
        // System.out.println(task.toString());
        // 이 리턴값이 마음에 들지 않는다면 재정의 해라.
        // -> 보통 인스턴스 내부 데이터를 문자열로 리턴하도록 변경한다.
        
        taskDao.insert(task);
    }

    private void onTaskList(final Team team) { 
        System.out.println("[팀 작업 목록]");
        
        Task[] tasks = taskDao.list(team.getName());
        
        /*
        for (int i = 0; i < tasks.length; i++) {
            Task task = tasks[i];
        }
        */
        for (Task task : tasks) { // 반복문을 돌때마다 tasks배열에서 값을 하나 꺼내서 task변수에 저장한다.
                                  // 배열의 처음부터 끝까지 순차적으로 접근할때 사용하기 좋다.
                                  // 단! 배열의 인덱스 번호를 알 수 없다. 
            System.out.printf("%d,%s,%s,%s,%s\n",
                    task.getNo(), task.getTitle(),
                    task.getStartDate(), task.getEndDate(),
                    (task.getWorker() == null)?
                            "-" : task.getWorker().getId());
            // 조건 연산자 (삼항 연산자) -> 이 연산을 수행하기 위해 항이 3개 필요하다.
        }
        System.out.println();
    }

    private void onTaskView(final Team team) { 
        System.out.println("[작업 정보]");
        System.out.print("작업 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine());
        
        
        Task task = taskDao.get(team.getName(), taskNo);
        // 지정된 팀의 특정 작업을 가져와야 하므로 두개의 값이 필요하다.
        
        if (task == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다.\n",
                    team.getName(), taskNo);
            return;
        }
        
        System.out.printf("작업명: %s\n", task.getTitle());
        System.out.printf("시작일: %s\n", task.getStartDate());
        System.out.printf("종료일: %s\n", task.getEndDate());
        System.out.printf("작업자: %s\n", 
                (task.getWorker() == null) ? "-" : task.getWorker().getId());
        System.out.printf("작업상태: %s\n", getStateLabel(task.getState()));
        
    }

    private void onTaskUpdate(final Team team) {
        System.out.println("[팀 작업 변경]");
        System.out.print("변경할 작업의 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine());
        
        Task originTask = taskDao.get(team.getName(), taskNo);
        if (originTask == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다.\n",
                    team.getName(), taskNo);
            return;
        }
        
        Task task = new Task(team); 
        task.setNo(originTask.getNo());
        
        System.out.printf("작업명(%s)? ", originTask.getTitle());
        String str = keyScan.nextLine();
        if (str.length() == 0) {
            task.setTitle(originTask.getTitle());
        } else {
            task.setTitle(str);
        }
        
        System.out.printf("시작일(%s)? ", originTask.getStartDate());
        str = keyScan.nextLine(); 
        if (str.length() == 0) {
            task.setStartDate(originTask.getStartDate());
        } else {
            Date date = Date.valueOf(str);
            if (date.getTime() < team.getStartDate().getTime()) { // 날짜를 밀리초로 비교해준다.
                task.setStartDate(team.getStartDate());
            } else {
                task.setStartDate(date);
            }
        }
        
        System.out.printf("종료일(%s)? ", originTask.getEndDate());
        str = keyScan.nextLine();
        if (str.length() == 0) {
            task.setEndDate(originTask.getEndDate());
        } else {
            Date date = Date.valueOf(str);
            if (date.getTime() > team.getEndDate().getTime()) { // 날짜를 밀리초로 비교해준다.
                task.setEndDate(team.getEndDate());
            } else {
                task.setEndDate(date);
            }
        }
        
        System.out.printf("작업자 아이디(%s)? ", 
                (originTask.getWorker() == null) ? 
                        "-" : originTask.getWorker().getId());
        String memberId = keyScan.nextLine();
        if (memberId.length() == 0) {
            task.setWorker(originTask.getWorker());
        } else {
            if (!teamMemberDao.isExist(team.getName(), memberId)) {
                System.out.printf("'%s'는 팀의 회원이 아닙니다. 이 작업자는 비워두겠습니다.\n", memberId);
            } else {
                task.setWorker(this.memberDao.get(memberId));
            }
        }
        
        if (Console.confirm("변경하시겠습니까?")) {
            taskDao.update(task);
            System.out.println("변경하였습니다.");
        } else {
            System.out.println("취소하였습니다.");
        }
        
        // System.out.println(task);
        // 어떤 클래스도 상속받지 않은 모든 클래스는 Object 클래스를 상속받게 된다.
        // 이 클래스의 객체를 출력하려 할 때,
        // 
    }
    
    private void onTaskDelete(final Team team) {
        System.out.println("[팀 작업 삭제]");
        System.out.print("삭제할 작업의 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine());
        
        Task task = taskDao.get(team.getName(), taskNo);
        if (task == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다.\n",
                    team.getName(), taskNo);
            return;
        }
        
        if (Console.confirm("삭제하시겠습니까?")) {
            taskDao.delete(task.getNo());
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("취소하였습니다.");
        }
    }
    
    private void onTaskState(final Team team) { 
        System.out.println("[작업 진행 상태]");
        System.out.print("상태를 변경할 작업의 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine()); 
        // 작업 상태를 String형으로 입력받아 int형으로 형변환해서 변수에 넣어준다.
        
        
        Task task = taskDao.get(team.getName(), taskNo);
        // 지정된 팀의 특정 작업을 가져와야 하므로 두개의 값이 필요하다.
        
        
        if (task == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다.\n",
                    team.getName(), taskNo);
            return;
        }
        
        System.out.printf("'%s' 작업의 상태: %s\n",
                task.getTitle(), getStateLabel(task.getState()));
        
        System.out.print("변경할 상태?(0:작업대기, 1:작업중, 9: 작업완료) ");
        int state = Integer.parseInt(keyScan.nextLine());
        
        if (state == Task.READY || state == Task.WORKING ||
                state == Task.COMPLETE) {
            task.setState(state);
            System.out.printf("작업 상태를 '%s'로 변경하였습니다.\n",
                    getStateLabel(state));
        } else {
            System.out.println("올바르지 않은 값입니다. 이전 상태를 유지합니다!");
        }
        
    }
    
    // 다음 메서드와 같이 인스턴스 변수를 사용하지 않는 메서드라면,
    // static을 붙여 클래스 메서드로 만들라!
        public static String getStateLabel(int state) {
            switch (state) { // 문자열을 반환하기 때문에 break;는 필요 없다.
            case Task.READY: return "작업대기";
            case Task.WORKING: return "작업중";
            case Task.COMPLETE: return "작업완료";
            default:
                return null;
            }
        }
}

// ver 17 - 클래스 생성
// ver 15 - 팀 멤버를 등록, 조회, 삭제할 수 있는 기능 추가.