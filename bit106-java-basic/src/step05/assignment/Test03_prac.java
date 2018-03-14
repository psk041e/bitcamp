package step05.assignment;

import java.util.Scanner;

public class Test03_prac {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("밑변 길이? ");
        int len = keyScan.nextInt();

        // 공백 + 별 까지만 찍으면 된다 그 뒤의 공백은 신경쓰지 않아도 된다.
        System.out.println();
        // 변수 선언 -> 별, 별 길이, 공백, 공백 길이
        // 공백 먼저 찍어준 후 별 개수대로 찍어준다.
        // 공백 개수를 구해 길이만큼 공백을 찍어준다.
        // 1부터 시작해야 개수만큼 찍을 수 있다.

        // while문은 입력받은 길이와 별의 길이가 같아질때까지 반복한다.
        // 별 길이 
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
            starLen += 2;
        }


    }
}