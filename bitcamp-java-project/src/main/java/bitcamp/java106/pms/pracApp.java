package bitcamp.java106.pms;


import bitcamp.java106.pms.domain.Team;
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
// ver 1.1 - member/view 명령을 구현한다.
// ver 1.2 - 명령어를 잘못 입력했을 때 안내 문구를 출력한다.
public class pracApp {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        Team[] teams = new Team[1000];
        int teamIndex = 0;

        while(true) {
           System.out.print("명령> ");
            String input = keyScan.nextLine().toLowerCase();
            
            
            if (input.toLowerCase().equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if (input.toLowerCase().equals("help")) {
                System.out.println("-------------------------------------");
                System.out.println("[도움말]");
                System.out.println("명령> help");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println("-----------------------");
                
            } else if (input.toLowerCase().equals("team/add")) {
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
                
            } else if (input.toLowerCase().equals("team/list")) {
                for (int i = 0; i < teamIndex; i++) {
                    System.out.printf("%s, %d, %s ~ %s\n",
                    teams[i].name, teams[i].maxQty, 
                    teams[i].startDate, teams[i].endDate);
                }
            }
            
            
            System.out.println();
        
        
        
        }



    }
}