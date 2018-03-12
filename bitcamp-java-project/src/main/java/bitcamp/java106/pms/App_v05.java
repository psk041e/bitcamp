package bitcamp.java106.pms;



import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

// ver 0.1 - 명령 입력 프롬프트를 출력한다.
// ver 0.2 - 사용자 입력을 받아 출력한다.
// ver 0.3 - 사용자로부터 입력 받는 것을 무한 반복한다.
// ver 0.4 - quit 명령어 입력 시 반복문을 종료한다.

public class App_v05 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        while(true) {   // jvm을 강제로 멈추기 전까지는 멈추지 않는다.
            System.out.print("명령> ");
            String input = keyScan.nextLine();
            // 리턴하는 문자열에 대해서 아예 가공을 하면 따로 할필요가 없다.
            
            if (input.toLowerCase().equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if(input.equals("help")) {
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue; 
                // 반복문은 여기까지, 반복 조건비교문으로 다시가서 실행하라
            }


            System.out.println(input);
            
        }

    }
}