package step05.assignment;

import java.util.Scanner;

public class Test01_prac {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        System.out.print("밑변의 길이? ");
        int len = keyScan.nextInt();

        System.out.println();
        int count = 1;
        while (count <= len) {
            int starCnt = 1;
            while (starCnt <= count) {
                System.out.print("*");
                starCnt++;    
                continue;
            }
            System.out.println();
            count++;
        }


        
    }
}