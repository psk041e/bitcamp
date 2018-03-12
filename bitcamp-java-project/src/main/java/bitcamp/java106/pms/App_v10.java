package bitcamp.java106.pms;



import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.domain.Member;
import java.util.Scanner;

// ver 0.1 - 명령 입력 프롬프트를 출력한다.
// ver 0.2 - 사용자 입력을 받아 출력한다.
// ver 0.3 - 사용자로부터 입력 받는 것을 무한 반복한다.
// ver 0.4 - quit 명령어 입력 시 반복문을 종료한다.
// ver 0.5 - help 명령을 구현한다.
// ver 0.6 - team/add 명령을 구현한다. (웹 어플리케이션을 개발할때 / 사용)
// ver 0.7 - team/list 명령을 구현한다.
// ver 0.8 - team/view 명령을 구현한다.
    // 1단계: 입력 값에서 명령어와 검색어를 구분한다.
    // 2단계: 기능이나 코드가 바뀌면 그에 따라 적절히 변수명도 바뀔 필요가 있다.
    // 3단계: 입력 값에서 검색어를 별도의 변수에 저장한다.
    // 4단계: 팀명이 없으면 안내문구를 출력한다.
    // 5단계: 팀명으로 배열을 뒤져 팀 정보를 찾는다.
    // 6단계: 팀명으로 검색할때 대소문자를 구분하지 않는다.
    // 7단계: 팀명이 일치하는 팀이 없으면 안내문구를 출력한다.
// ver 0.9 - member/add 명령을 구현한다.
    // 회원 정보를 담을 새로운 데이터타입을 정의한다. => Member.java
    // 여러 회원 정보를 저장할 레퍼런스 배열을 준비한다.
// ver 1.0 - member/list 명령을 구현한다.

public class App_v10 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        Team[] teams = new Team[1000]; 
        // 팀 객체의 주소를  1000개 받는것
        // 아직 팀 정보를 받을 객체는 만들어지지 않았다.
        int teamIndex = 0;

        Member[] members = new Member[1000];
        int memberIndex = 0;

        while(true) {   // jvm을 강제로 멈추기 전까지는 멈추지 않는다.
            System.out.print("명령> ");
            String[] arr = keyScan.nextLine().toLowerCase().split(" ");
            // 리턴하는 문자열에 대해서 아예 가공을 하면 따로 할필요가 없다.
            String menu = arr[0];
            // 입력 받은 문자열을 공백을 기준으로 잘라서 명령과 검색어로 구분한다.
            // 일단 다음으로 진행하기 전에 기존의 기능이 잘 되는지 확인하라!
            String option = null; // 문자열 없음!
            if (arr.length ==2) {
                option = arr[1];
            }

            if (menu.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if(menu.equals("help")) {
                System.out.println("도움말");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");

                // 반복문은 여기까지, 반복 조건비교문으로 다시가서 실행하라
            } else if (menu.equals("team/add")) {
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

                // 팀 정보가 담겨있는 객체의 주소를 배열에 보관한다.
                teams[teamIndex++] = team;
                // teamIndex++;

                
            } else if (menu.equals("team/list")) {
                System.out.println("[팀 목록]");
                for (int i = 0; i < teamIndex; i++) {
                    System.out.printf("%s, %d, %s ~ %s\n", 
                    teams[i].name, teams[i].maxQty,
                    teams[i].startDate, teams[i].endDate );
                }
                
            } else if (menu.equals("team/view")) {
                System.out.println("[팀 정보 조회]");
                if (option == null) {
                    System.out.println("팀명을 입력하시기 바랍니다.");
                    System.out.println();
                    continue;
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
            } else if (menu.equals("member/add")) {
                System.out.println("[회원 정보 입력]");
                Member member = new Member();
                System.out.print("아이디? ");
                member.id = keyScan.nextLine();
        
                System.out.print("이메일? ");
                member.email = keyScan.nextLine();
        
                System.out.print("암호? ");
                member.password = keyScan.nextLine();

                // 회원 정보가 담겨있는 객체의 주소를 배열에 보관한다.
                members[memberIndex++] = member;
                // memberIndex++;

            } else if (menu.equals("member/list")) {
                System.out.println("[회원 목록]");
                for (int i = 0; i < memberIndex; i++) {
                    System.out.printf("%s, %s, %s\n", 
                    members[i].id, members[i].email, members[i].password);
                }
            }


            System.out.println();
            
        }
    }
}