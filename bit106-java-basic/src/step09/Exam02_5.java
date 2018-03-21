// ?¸?Š¤?„´?Š¤ ë©”ì„œ?“œ?? ?´?˜?Š¤ ë©”ì„œ?“œ?˜ ?™œ?š© - Calendar ?´?˜?Š¤
package step09;

import java.util.Calendar;
import java.util.Date;

public class Exam02_5 {
    public static void main(String[] args) throws Exception {
        // Calendar ?´?˜?Š¤?˜ ?ƒ?„±??Š” protectedë¡? ? ‘ê·¼ì´ ? œ?•œ?˜?–´ ?ˆê¸? ?•Œë¬¸ì—
        // ?‹¤ë¥? ?Œ¨?‚¤ì§??—?„œ ì§ì ‘ ?ƒ?„±?ë¥? ?˜¸ì¶œí•  ?ˆ˜ ?—†?‹¤. -> Car2?´?˜?Š¤ ì°¸ê³ 
        // Calendar c = new Calendar(); //ì»´íŒŒ?¼ ?˜¤ë¥?!
        
        // ?˜¤?Š˜ ?‚ ì§? ë°? ?‹œê°? ? •ë³´ë?? ???¥?•œ ê°ì²´ë¥? ë§Œë“¤?–´ ë¦¬í„´?•œ?‹¤.
        // ?‹¬? ¥?? ê·¸ë ˆê³ ë¦¬?•ˆ ?‹¬? ¥?„ ?‚¬?š©?•œ?‹¤.(GMT)
        Calendar c = Calendar.getInstance();
        
        // ?¸?Š¤?„´?Š¤ ë©”ì„œ?“œ ?™œ?š© (ctrl?ˆ„ë¥? ?›„ Calendar ?´ë¦??•˜ë©? ?…„?„,?›”,?¼,?š”?¼ ?“±?„ ì¶œë ¥?•´ì£¼ëŠ” ?ˆ«?ë¥? ë³¼ìˆ˜?ˆ?‹¤.)
        System.out.println(c.get(1)); // ?…„?„ë¥? ë½‘ì•„ì£¼ê²Œ?” get?´?¼?Š” ë©”ì„œ?“œê°? ?‚´?¥?˜?–´?ˆ?‹¤.
        System.out.println(c.get(2) + 1); // ?›”(0 ~ 11)
        System.out.println(c.get(5)); // ?¼
        System.out.println(c.get(7)); // ?š”?¼(1 ~ 7) ?† ?š”?¼: ì£¼ë§(ì£¼ì˜ ë§ˆì?ë§‰ë‚ ), ?¼?š”?¼: ì£¼ì˜ ì²«ì§¸?‚ 
        System.out.println(c.get(4)); // ê·? ?‹¬?˜ ëª‡ë²ˆì§? ì£?
        System.out.println(c.get(10)); // ?‹œ(0 ~ 11)
        System.out.println(c.get(11)); // ?‹œ(24?‹œ ê¸°ì?)
        System.out.println(c.get(12)); // ë¶?
        System.out.println(c.get(13)); // ì´?
        
        // ?ƒ?ˆ˜?˜ ?™œ?š© -> step08?˜ Exam01_6ì°¸ê³ 
        // ?ˆ«?ë¥? ?•”ê¸°í•˜ê¸? ?˜?“¤?‹¤ -> ?‚´ë¶?? ?œ¼ë¡? ?ƒ?ˆ˜ê°? ? •?˜?˜?–´?ˆ?‹¤.
        System.out.println(c.get(Calendar.YEAR)); // ?…„?„ë¥? ë½‘ì•„ì£¼ê²Œ?” get?´?¼?Š” ë©”ì„œ?“œê°? ?‚´?¥?˜?–´?ˆ?‹¤.
        System.out.println(c.get(Calendar.MONTH) + 1); // ?›”(0 ~ 11)
        System.out.println(c.get(Calendar.DATE)); // ?¼
        System.out.println(c.get(Calendar.DAY_OF_WEEK)); // ?š”?¼(1 ~ 7) ?† ?š”?¼: ì£¼ë§(ì£¼ì˜ ë§ˆì?ë§‰ë‚ ), ?¼?š”?¼: ì£¼ì˜ ì²«ì§¸?‚ 
        System.out.println(c.get(Calendar.WEEK_OF_MONTH)); // ê·? ?‹¬?˜ ëª‡ë²ˆì§? ì£?
        System.out.println(c.get(Calendar.HOUR)); // ?‹œ(0 ~ 11)
        System.out.println(c.get(Calendar.HOUR_OF_DAY)); // ?‹œ(24?‹œ ê¸°ì?)
        System.out.println(c.get(Calendar.MINUTE)); // ë¶?
        System.out.println(c.get(Calendar.SECOND)); // ì´?
        
        
    }
}





