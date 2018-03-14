// 흐름 제어문 - 중첩된 반복문 탈출
package step05;

import java.util.Scanner;

public class Exam03_3 {
    public static void main(String[] args) {
        int x = 2, y = 1;

        // 5 * 5 까지만 출력하라!
        // 라벨명: 반복문1 { 반복문2 {break 라벨명;}}
        // 
        myloop: 
        while (x <= 9) { // 보통 실무에서 쓰는 형태, myloop에서 한줄을 띈다.
            while (y <= 9) {
                System.out.printf("%d * %d = %d\n", x, y, x * y);

                if (x == 5 && y == 5) 
                    // break; // 이 break는 자신이 소속된 가장 가까운 반복문을 나간다.
                    break myloop; // myloop 라벨에 소속된 문장을 나간다.
                y++;
            }
            System.out.println();
            x++;
            y = 1;
        }



    }
}
