/*
> java -classpath bin bitcamp.java106.pms.App
팀명? 비트비트
설명? 자바 프로젝트 팀
최대인원? 5
시작일? 2018-05-05
종료일? 2018-08-20
-----------------------
팀명: 비트비트
설명:
자바 프로젝트 팀
최대인원: 5명
일자: 2018-05-05 ~ 2018-08-20
*/

package bitcamp.java106.pms;
// next() 와 nextLine()의 차이
public class App {
    public static void main(String[] args){
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);

        System.out.print("팀명? ");
        String teamName = keyScan.nextLine();
        System.out.print("설명? ");
        String description = keyScan.nextLine();
        System.out.print("최대인원? ");
        int maxQty = keyScan.nextInt();
        keyScan.nextLine(); // 숫자 뒤에 줄바꿈 코드르르 읽는다.
                            // 일고 난 뒤에 아무것도 안하기 때문에
                            // 일종의 줄바꿈 코드를 제거하는 효과가 있다.
        System.out.print("시작일? ");
        String startDate = keyScan.nextLine();
        System.out.print("종료일? ");
        String endDate = keyScan.nextLine();

        System.out.println("-------------------------");
        System.out.println("팀명 : " + teamName);
        System.out.println("설명 : \n" + description);
        System.out.println("최대인원 : " + maxQty);
        System.out.println("일자 : " + startDate + " ~ " + endDate);


    }
}

//  