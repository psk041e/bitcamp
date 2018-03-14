package step06;

import java.util.Scanner;

public class Exam01_1 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("밑변 길이? ");
        int len = keyScan.nextInt();

        // 별 길이, 별변수, 공백길이, 공백변수

        int starLen = 1;
        while (starLen <= len) {
            int spaceCnt = 1;
            int spaceLen = (len - starLen) / 2;
            while (spaceCnt <= spaceLen) {
                System.out.print(" ");
                spaceCnt++;
            }

            int starCnt = 1;
            while (starCnt <= starLen) {
                System.out.print("*");
                starCnt++;
            }
            System.out.println();
            starLen +=2; // *****공백수를 2개씩 줄여야한다*****
        }
    }
}