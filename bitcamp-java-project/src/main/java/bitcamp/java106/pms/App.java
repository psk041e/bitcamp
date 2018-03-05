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
        String team = keyScan.nextLine();
        System.out.print("설명? ");
        String explan = keyScan.nextLine();
        System.out.print("최대인원? ");
        int mem = keyScan.nextInt();
        System.out.print("시작일? ");
        String start = keyScan.next();
        System.out.print("종료일? ");
        String end = keyScan.next();

        System.out.println("-------------------------");
        System.out.println("팀명: " + team + "\n설명:\n" + explan 
             + "\n최대인원: " + mem + "명\n" + "일자: " + start + " ~ " + end);



    }
}