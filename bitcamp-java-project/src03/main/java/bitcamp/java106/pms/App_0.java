package bitcamp.java106.pms;
// 기존의 소스코드
public class App_0 {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);

        System.out.print("팀명? ");
        String teamName = keyScan.nextLine();
        System.out.print("설명? ");
        String description = keyScan.nextLine();
        System.out.print("최대인원? ");
        int maxQty = keyScan.nextInt();
        keyScan.nextLine();
        System.out.print("시작일? ");
        String startDate = keyScan.nextLine();
        System.out.print("종료일? ");
        String endDate = keyScan.nextLine();

        System.out.println("-----------------------");

        System.out.print("팀명: ");
        System.out.println(teamName);
        System.out.println("설명: ");
        System.out.println(description);
        System.out.print("최대인원: ");
        System.out.print(maxQty);
        System.out.println("명");
        System.out.print("일자: ");
        System.out.print(startDate);
        System.out.print(" ~ ");
        System.out.print(endDate);


    }
}