// 이 클래스는 명령창에서 사용할 기능을 모아 둔 클래스이다.
package bitcamp.java106.pms.util;

import java.util.Scanner;

public class Console { // 메소드를 분류
    // 이 클래스를 사용하기 전에 반드시 Scanner 객체를 설정하라! 
    public static Scanner keyScan;

    public static boolean confirm(String message) {
        // 유틸리티 : 일상에서 늘 사용하는 것들 
        // => 따로 분리시켜서 관리하는 것이 낫다.
        // (영어에서는 전기, 수도를 유틸리티라 표현한다.)
        System.out.printf("%s (y/N)", message);
        String input = keyScan.nextLine().toLowerCase();
        if (input.equals("y"))
            return true;
        else 
            return false;
    }

    public static String[] prompt() {
        System.out.print("명령> ");
        return keyScan.nextLine().toLowerCase().split(" ");
    }
}