package step09.assignment;

import java.util.Calendar;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("년, 월, 일(예: 2018 3 21)? ");
        int year = keyScan.nextInt(); // nextInt()는 입력값을 구분할 수 있는 코드를 만나면 읽기를 멈추고 값을 리턴한다.
        int month = keyScan.nextInt();  // => 입력값을 구분할 수 있는 코드 : 공백, 줄바꿈, 탭 (보통 enter) 
        int day = keyScan.nextInt();
        
        Calendar c = Calendar.getInstance();
        
        // c.set(Calendar.YEAR, year);
        // c.set(Calendar.MONTH, month - 1);
        // c.set(Calendar.DATE, day);
        c.set(year, month-1, day, 0, 0, 0);
        
        String[] weeks = {"", "일", "월", "화", "수", "목", "금", "토"};
        
        // int i = c.get(Calendar.DAY_OF_WEEK);
        // System.out.printf("요일: %s요일\n", weeks[i]);
        System.out.printf("요일: %s요일\n", weeks[c.get(Calendar.DAY_OF_WEEK)]);
        System.out.printf("주차: %d주차\n", c.get(Calendar.WEEK_OF_MONTH));
        System.out.printf("일차: %d일차\n", c.get(Calendar.DAY_OF_WEEK));
    }

}
