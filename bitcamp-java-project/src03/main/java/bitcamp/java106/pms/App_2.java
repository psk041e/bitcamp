package bitcamp.java106.pms;

// 컴파일러에게 클래스의 위치 정보를 알려준다.
// => 컴파일한 후 import 명령은 제거된다.
//    즉 .class 파일에 포함되지 않는다.
// => 그러니 import 문장이 많으면 .class 파일이 커지지 않을까 걱정말라!
import java.util.Scanner;
import bitcamp.java106.pms.domain.Team;

// 2단계: 배열 적용
public class App_2 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        // 팀 정보를 받을 메모리 준비
        Team[] team = new Team[5];
        team[0] = new Team();

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

        System.out.println("-----------------------");

        System.out.printf("%s, %d명, %s ~ %s\n",
        team[0].name, team[0].maxQty,
        team[0].startDate, team[0].endDate);


    }
}