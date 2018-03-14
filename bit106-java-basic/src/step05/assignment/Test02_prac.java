package step05.assignment;

import java.util.Scanner;

public class Test02_prac {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("밑변 길이? ");
        int len = keyScan.nextInt();

        System.out.println();

        // 마름모 윗부분
        int count = 1;
        while (count <= len) {
            int starCnt = 1;
            while (starCnt <= count) {
                System.out.print("*");
                starCnt++;
            }
            System.out.println();
            count++;
        }

        // 마름모 아랫부분
        count = len - 1;
        while (count >= 1) {
            int starCnt = 1;
            while (starCnt <= count) {
                System.out.print("*");
                starCnt++;
            }
            System.out.println();
            count--;
        }
    }
}