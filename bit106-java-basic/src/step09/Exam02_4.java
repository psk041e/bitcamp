// ?¸?Š¤?„´?Š¤ ë©”ì„œ?“œ?? ?´?˜?Š¤ ë©”ì„œ?“œ?˜ ?™œ?š© - Date ?´?˜?Š¤
package step09;

import java.util.Date;

public class Exam02_4 {
    public static void main(String[] args) {
        Date d1 = new Date();
        
        // ?¸?Š¤?„´?Š¤ ë©”ì„œ?“œ ?™œ?š©
        System.out.println(d1.getYear() + 1900);
        System.out.println(d1.getMonth() + 1);
        System.out.println(d1.getDate());
        
        // ?Š¤?ƒœ?‹± ë©”ì„œ?“œ ?™œ?š©
        long millis = Date.parse("Sat, 12 Aug 1995 13:30:00 GMT");
        System.out.println(millis);
        
        // ?‹¤ë¬´ì—?„œ?Š” java.util.Date ???‹  ?´ ?´?˜?Š¤?˜ ??‹ ?´?˜?Š¤?¸
        // java.sql.Date?„ ?“°ê¸°ë„ ?•œ?‹¤.
        // ?´ ?´?˜?Š¤?Š” ?‚ ì§? ?°?´?„°ë¥? ë¬¸ì?—´ë¡? ?‹¤ë£? ?•Œ yyyy-MM-dd ?˜•?‹?œ¼ë¡? ?‹¤ë£¬ë‹¤.
        
        
        // ?Š¤?ƒœ?‹± ë©”ì„œ?“œ ?™œ?š©
        long currMillis = System.currentTimeMillis();
                
        // ?ƒ?„±? ?™œ?š©
        java.sql.Date today = new java.sql.Date(currMillis);
        
        // ?¸?Š¤?„´?Š¤ ë©”ì„œ?“œ ?™œ?š©
        String str = today.toString();
        System.out.println(str);
        
        // ?Š¤?ƒœ?‹± ë©”ì„œ?“œ ?™œ?š©
        java.sql.Date d = java.sql.Date.valueOf("2018-03-21");
    }
}
