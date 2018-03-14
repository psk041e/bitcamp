// 메서드 : 리팩토링
package step06;

import java.util.Scanner;

public class Exam01_3 {

    // 스페이스를 출력하는 코드들을
    // 관리하기 쉽도록 별도의 블록에 모아 놓는다. 
    // 그리고 그 블록에 대해 이름을 붙인다.
    // => 이렇게 정의한 블록을 "메서드(method)" 또는
    //    "함수(function)"
    public static void printSpaces(int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(" ");
        }
    }

    public static void printStars(int len) {
        for (int i = 0; i < len; i++) {
            System.out.print("*");
        }
    }

    // 코드를 유지보수 하기 쉽도록 가능한 기능 별로 묶어 둔다.
    // 그래서 Exam01_2에 있던 코드 중에서 공백을 계산하는 코드를
    // 별도의 블록으로 분리하여 이름을 부여한다.
    public static int getSpaceLength(int totalStar, int displayStar) {
        return (totalStar - displayStar) / 2;
    }

    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("밑변의 길이? ");
        int len = keyScan.nextInt();

        for (int starLen = 1; starLen <= len; starLen += 2) {
            // 출력할 페이스의 개수를 계산하는 코드를
            // 블록에 묶어 놓고 이름을 부여해두고 사용하면
            // 코드를 이해하기가 더 쉽다.
            printSpaces(getSpaceLength(len, starLen));
            printStars(starLen);
            System.out.println();
            
        }

        // 코드를 유지보수하기 쉽게하자
        // 코드를 간결하게 짜면 한눈에 어떤 코드인지 알아보지 못한다.
        // 자바의 목적은 소스코드의 유지보수를 하기 위함이다.
        // 속도를 위함이 아니다.
        // 소스코드를 읽기가 더 편하다면 길이가 더 늘어나고, 속도가 지연이 되더라도
        // 가독성이 좋아진다면 리팩토링해라!
        // 리팩토링의 목적 -> 코드가 조직화가 잘 되어있다면 주석을 달지 않아도 된다.
        // 코드자체를 읽으면 그 자체가 이해되는것이 중요하다.

        // 메소드의 목적은 코드를 기능별로, 의미있게 묶어두는것,
        // 필요할때 반복적으로 사용할수 있는 것이다.
        // Exam01_1.java 와 Exam01_3.java 비교해보기
        
    }
}