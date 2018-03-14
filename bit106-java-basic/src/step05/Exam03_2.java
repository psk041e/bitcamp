// 흐름 제어문 - break와 continue
package step05;

import java.util.Scanner;

public class Exam03_2 {
    public static void main(String[] args) {
        int count = 0;
        int sum = 0;

        // 1부터 100까지 합은?
        while (count < 100) {
            count++;
            sum += count;
        }

        System.out.printf("count=%d, sum=%d\n", count, sum);
        // 버그 : - 실행을 마비시키는 버그
        //        - 문법적으로 문제없고, 실행할때 문제가 있는것이 아닌데 
        //          원하는대로 실행이 되지 않는다.
        //          논리적 오류 -> logic -> 코드의 흐름 -> 로직이 잘못되었다.
        // 원하는 결과를 뽑아내기 위해 전개해 나가는 방식을 로직이라 표현한다.

        // 버그 -> 프로그램을 실행하는 과정에서 발생하는 오류
        //          메모리 할당과 반환 또는 오버플로우 등으로 인한 크래쉬,
        //          구현상의 실수나 착각, 헛손질에 따른 오작동도 포함한다.
        //          한마디로 원하던 결과가 나오지 않으면 버그.

        System.out.println("----------------------------");

        // continue 사용 전
        // 1부터 100까지의 짝수의 합은?
        count = 0;
        sum = 0;
        while (count < 100) {
            count++;
            if (count % 2 == 0) { // 짝수만 더한다.
                sum += count;
            }
        }
        System.out.printf("count=%d, sum=%d\n", count, sum);

        System.out.println("----------------------------");
        
        // continue 사용 후
        // 1부터 100까지의 짝수의 합은?
        count = 0;
        sum = 0;
        while (count < 100) {
            count++;
            if (count % 2 == 1)
                continue; // 다음 문장을 실행하지 않고 즉시 조건 검사로 이동한다.
            sum += count;
        }
        System.out.printf("count=%d, sum=%d\n", count, sum);
        
        System.out.println("----------------------------");


        // break 사용 전
        // 1부터 100까지의 카운트를 하는데 단 합은 50까지만 계산한다.
        count = 0;
        sum = 0;
        while (count < 100) {
            count++;
            if (count > 50) // 50 넘어가면 합을 수행하지 않는다.
                continue;
            sum += count;
        }
        System.out.printf("count=%d, sum=%d\n", count, sum);

        System.out.println("----------------------------");

        
        // break 사용 후
        // 1부터 99까지 카운트를 하는데 단 합은 50까지만 한다.
        count = 0;
        sum = 0;
        while (count < 100) {
            count++;
            if (count > 50) 
                break; // 반복문을 나간다.
            sum += count;
        }
        System.out.printf("count=%d, sum=%d\n", count, sum);

    }
}
