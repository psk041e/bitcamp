package bitcamp.java106.pms;

import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.domain.Member;
import java.util.Scanner;

public class App {

    public static void main(String[] args){
        Scanner keyScan = new Scanner(System.in);
        
        Team[] team = new Team[100];
        Member[] member = new Member[100];

        // int i = 0;

        // for (i = 0; i < 100; i++) {
        team[0] = new Team();
        member[0] = new Member();
        // }


        System.out.print("명령> ");
        String help = keyScan.nextLine();
        


        if (help.equals("help")){
            System.out.println("----------------------");
            System.out.println("팀 등록 명령 : team/add");
            System.out.println("팀 조회 명령 : team/list");
            System.out.println("팀 상세조회 명령 : team/view 팀명");
            System.out.println("회원 등록 명령 : member/add");
            System.out.println("회원 조회 명령 : member/list");
            System.out.println("회원 상세조회 명령 : member/view 아이디");
            System.out.println("종료 : quit");
            System.out.println("----------------------");
        
            

        System.out.print("명령1> ");
        String comm = keyScan.nextLine();
        
        while(!comm.equals("quit")){

            
            if(comm.equals("team/add")) {
                System.out.print("팀명? ");
                team[0].name = keyScan.nextLine();
                System.out.print("설명? ");
                team[0].description = keyScan.nextLine();
                System.out.print("최대인원? ");
                team[0].maxQty = keyScan.nextInt();
                keyScan.nextLine();
                System.out.print("시작일? ");
                team[0].startDate = keyScan.nextLine();
                System.out.print("종료일? ");
                team[0].endDate = keyScan.nextLine();

            } else if (comm.equals("team/list")) {
                for (int i = 0; i < 1; i++) {
                    System.out.printf("%s, %d, %s ~ %s\n",
                    team[i].name, team[i].maxQty,
                    team[i].startDate, team[i].endDate);
                }

            } else if (comm.equals("team/view")) {
                System.out.println("팀명을 입력하시기 바랍니다.");

            } else if (comm.equals("team/view " + team[0].name)) {
                System.out.println("팀명: " + team[0].name);
                System.out.println("설명: " + team[0].description);
                System.out.println("최대인원: " + team[0].maxQty);                                
                System.out.println("기간: " + team[0].startDate 
                                    + " ~ " + team[0].endDate);
                
            } else if (comm.equals("member/add")) {
                System.out.print("아이디? ");
                member[0].id = keyScan.nextLine();
                System.out.print("이메일? ");
                member[0].email = keyScan.nextLine();
                System.out.print("암호? ");
                member[0].pw = keyScan.nextLine();

            } else if (comm.equals("member/list")) {
                for (int i = 0; i < 1; i++) {
                    System.out.printf("%s, %s ~ %s\n",
                    member[i].id, member[i].email, member[i].pw);
                }

            } else if (comm.equals("member/view")) {
                System.out.println("아이디를 입력하시기 바랍니다.");

            } else if (comm.equals("member/view " + member[0].id)) {
                System.out.println("아이디: " + member[0].id);
                System.out.println("이메일: " + member[0].email);
                System.out.println("암호: " + member[0].pw);

            } else {
                System.out.println("명령어가 올바르지 않습니다.");

            }
            System.out.print("명령2> ");
            comm = keyScan.nextLine();
    } //while 
    System.out.println("안녕히 가세요!");
} //if
    else {
        System.out.println("알맞은 입력이 아닙니다. 프로그램을 종료합니다.");
}
    

}
}
