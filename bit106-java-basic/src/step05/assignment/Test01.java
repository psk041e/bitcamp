package step05.assignment;

import java.util.Scanner;
public class Test01 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("밑변의 길이? ");
        int len = keyScan.nextInt();

        int count = 1;
        while (count <= len) {
            int spaceCnt = 1;
            int spaceLen = len - count;
//            while (starCnt <= count) {
//                System.out.print("*");
//                starCnt++;
//            }
            System.out.println();
            count++;

        }



    }
}