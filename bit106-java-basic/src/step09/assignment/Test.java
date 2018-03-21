package step09.assignment;

import java.util.Calendar;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("?…„, ?›”, ?¼(?˜ˆ: 2018 3 21)? ");
        int year = keyScan.nextInt(); // nextInt()?Š” ?…? ¥ê°’ì„ êµ¬ë¶„?•  ?ˆ˜ ?ˆ?Š” ì½”ë“œë¥? ë§Œë‚˜ë©? ?½ê¸°ë?? ë©ˆì¶”ê³? ê°’ì„ ë¦¬í„´?•œ?‹¤.
        int month = keyScan.nextInt();  // => ?…? ¥ê°’ì„ êµ¬ë¶„?•  ?ˆ˜ ?ˆ?Š” ì½”ë“œ : ê³µë°±, ì¤„ë°”ê¿?, ?ƒ­ (ë³´í†µ enter) 
        int day = keyScan.nextInt();
        
        Calendar c = Calendar.getInstance();
        
        // c.set(Calendar.YEAR, year);
        // c.set(Calendar.MONTH, month - 1);
        // c.set(Calendar.DATE, day);
        c.set(year, month-1, day, 0, 0, 0);
        
        String[] weeks = {"", "?¼", "?›”", "?™”", "?ˆ˜", "ëª?", "ê¸?", "?† "};
        
        // int i = c.get(Calendar.DAY_OF_WEEK);
        // System.out.printf("?š”?¼: %s?š”?¼\n", weeks[i]);
        System.out.printf("?š”?¼: %s?š”?¼\n", weeks[c.get(Calendar.DAY_OF_WEEK)]);
        System.out.printf("ì£¼ì°¨: %dì£¼ì°¨\n", c.get(Calendar.WEEK_OF_MONTH));
        System.out.printf("?¼ì°?: %d?¼ì°?\n", c.get(Calendar.DAY_OF_WEEK));
    }

}
