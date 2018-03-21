package step09.assignment;

import java.util.Calendar;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("?��, ?��, ?��(?��: 2018 3 21)? ");
        int year = keyScan.nextInt(); // nextInt()?�� ?��?��값을 구분?�� ?�� ?��?�� 코드�? 만나�? ?��기�?? 멈추�? 값을 리턴?��?��.
        int month = keyScan.nextInt();  // => ?��?��값을 구분?�� ?�� ?��?�� 코드 : 공백, 줄바�?, ?�� (보통 enter) 
        int day = keyScan.nextInt();
        
        Calendar c = Calendar.getInstance();
        
        // c.set(Calendar.YEAR, year);
        // c.set(Calendar.MONTH, month - 1);
        // c.set(Calendar.DATE, day);
        c.set(year, month-1, day, 0, 0, 0);
        
        String[] weeks = {"", "?��", "?��", "?��", "?��", "�?", "�?", "?��"};
        
        // int i = c.get(Calendar.DAY_OF_WEEK);
        // System.out.printf("?��?��: %s?��?��\n", weeks[i]);
        System.out.printf("?��?��: %s?��?��\n", weeks[c.get(Calendar.DAY_OF_WEEK)]);
        System.out.printf("주차: %d주차\n", c.get(Calendar.WEEK_OF_MONTH));
        System.out.printf("?���?: %d?���?\n", c.get(Calendar.DAY_OF_WEEK));
    }

}
