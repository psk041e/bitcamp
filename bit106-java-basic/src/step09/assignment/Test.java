package step09.assignment;

import java.util.Calendar;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("?, ?, ?Ό(?: 2018 3 21)? ");
        int year = keyScan.nextInt(); // nextInt()? ?? ₯κ°μ κ΅¬λΆ?  ? ?? μ½λλ₯? λ§λλ©? ?½κΈ°λ?? λ©μΆκ³? κ°μ λ¦¬ν΄??€.
        int month = keyScan.nextInt();  // => ?? ₯κ°μ κ΅¬λΆ?  ? ?? μ½λ : κ³΅λ°±, μ€λ°κΏ?, ?­ (λ³΄ν΅ enter) 
        int day = keyScan.nextInt();
        
        Calendar c = Calendar.getInstance();
        
        // c.set(Calendar.YEAR, year);
        // c.set(Calendar.MONTH, month - 1);
        // c.set(Calendar.DATE, day);
        c.set(year, month-1, day, 0, 0, 0);
        
        String[] weeks = {"", "?Ό", "?", "?", "?", "λͺ?", "κΈ?", "? "};
        
        // int i = c.get(Calendar.DAY_OF_WEEK);
        // System.out.printf("??Ό: %s??Ό\n", weeks[i]);
        System.out.printf("??Ό: %s??Ό\n", weeks[c.get(Calendar.DAY_OF_WEEK)]);
        System.out.printf("μ£Όμ°¨: %dμ£Όμ°¨\n", c.get(Calendar.WEEK_OF_MONTH));
        System.out.printf("?Όμ°?: %d?Όμ°?\n", c.get(Calendar.DAY_OF_WEEK));
    }

}
