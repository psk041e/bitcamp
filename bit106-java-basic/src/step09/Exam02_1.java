// ?¸?Š¤?„´?Š¤ ë©”ì„œ?“œ?? ?´?˜?Š¤ ë©”ì„œ?“œ?˜ ?™œ?š© - String ?´?˜?Š¤ 
package step09;
// ?¸?Š¤?„´?Š¤ ë©”ì„œ?“œ -> ?¸?Š¤?„´?Š¤ê°? ?ˆ?–´?•¼ë§Œì´ ?‘?—…?„ ?ˆ˜?–‰?•˜?Š” ë©”ì„œ?“œ
// ?¸?Š¤?„´?Š¤ë¥? ?‚¬?š©?•˜ì§? ?•Š?Š” ë©”ì„œ?“œ?¼ë©? static?„ ë¶™ì—¬?•¼ ?•œ?‹¤.
public class Exam02_1 {
    public static void main(String[] args) throws Exception {
        String s1 = new String("Hello"); 
        //                      01234
        
        
        // s1 ?¸?Š¤?„´?Š¤(s1 ? ˆ?¼?Ÿ°?Š¤ê°? ê°?ë¦¬í‚¤?Š” ?¸?Š¤?„´?Š¤)?˜ ê°’ì„ ì¡°íšŒ?•˜?Š” ë©”ì„œ?“œ ?‚¬?š©
        // ?”°?¼?„œ ?´ ë©”ì„œ?“œë¥? ?˜¸ì¶œí•˜? ¤ë©? ë°˜ë“œ?‹œ String ?¸?Š¤?„´?Š¤?˜ ì£¼ì†Œë¥? ì¤˜ì•¼ ?•œ?‹¤.
        // ?¸?Š¤?„´?Š¤ ë©”ì†Œ?“œ?Š” ë°˜ë“œ?‹œ ?¸?Š¤?„´?Š¤ ì£¼ì†Œë¥? ì£¼ì–´?•¼ ?‚¬?š©ê°??Š¥?•˜?‹¤.
        char c = s1.charAt(1);
        System.out.println(c);
        
        // ?ˆ„ê°? ?’¤?—?ˆ?Š” ë¬¸ì?—´?¸ì§?, ?•?—?ˆ?Š” ë¬¸ì?—´?¸ì§?ë¥? ?ˆ«?ë¡? ?•Œ? ¤ì¤??‹¤.
        System.out.println(s1.compareTo("Helli"));
        System.out.println(s1.compareTo("Hello")); // ê°™ì?ê°’ì´?ƒ ?•„?‹ˆ?ƒ -> 0 ?¸ê°? ?•„?‹Œê°?
        System.out.println(s1.compareTo("Hellu"));
        
        System.out.println(s1.contains("ll"));
        System.out.println(s1.contains("ee"));
        
        // ?‘ ë¬¸ì?—´?„ ?—°ê²°í•˜?—¬ ?„¸ ë¬¸ì?—´?„ ë§Œë“¤?!
         String s2 = s1.concat(", world!");
         System.out.println(s1); // ê¸°ì¡´ ?¸?Š¤?„´?Š¤?˜ ê°’ì? ë³?ê²½í•˜ì§? ?•Š?Š”?‹¤.
         System.out.println(s2); // ?ƒˆë¡œìš´ ë¬¸ì?—´?„ ë§Œë“ ?‹¤. => Hello, world!
         
         // ?‘ ?¸?Š¤?„´?Š¤?— ?“¤?–´ ?ˆ?Š” ë¬¸ì?—´?´ ê°™ì? ì§? ë¹„êµ?•  ?•Œ, true/falseê°’ìœ¼ë¡? ?‚˜???‚¸?‹¤.  
         System.out.println(s1.equals("aaa"));
         System.out.println(s1.equals("Hello"));
         
         // ?¸?Š¤?„´?Š¤?— ?“¤?–´?ˆ?Š” ë¬¸ì ì½”ë“œë¥? ë°”ì´?Š¸ ë°°ì—´ë¡? ë§Œë“¤?–´ ë¦¬í„´?•œ?‹¤.
         String s3 = new String("ABCê°?ê°?");
         // => ?¸?Š¤?„´?Š¤?— ?“¤?–´ ?ˆ?Š” ê°? ë¬¸ìë¥? ë°”ì´?Š¸ ë°°ì—´?— ???¥?•  ?•Œ 
         //    ?¸ì½”ë”© ë¬¸ìì§‘í•©?„ ì§?? •?•˜ì§? ?•Š?œ¼ë©? JVM?˜ ê¸°ë³¸ ë¬¸ìì§‘í•©?œ¼ë¡? ?¸ì½”ë”© ?•œ?‹¤. 
         //    ?´?´ë¦½ìŠ¤?—?„œ JVM?„ ?‹¤?–‰?•˜ë©? JVM?? ê¸°ë³¸?œ¼ë¡? UTF-8 ë¬¸ì?‘œë¥? ?‚¬?š©?•˜?—¬
         //    ë°”ì´?Š¸ ë°°ì—´?— ì½”ë“œ ê°’ì„ ???¥?•œ?‹¤.
         byte[] bytes = s3.getBytes(); // ë°”ì´?Š¸ ë°°ì—´ë¡? ë§Œë“¤?–´?¼
         for (int i = 0; i < bytes.length; i++)
             System.out.printf("%x", bytes[i]);
         System.out.println();
           
         // ?‹¤ë¥? ?¸?Š¤?„´?Š¤ ë©”ì„œ?“œë¥? ?‚¬?š©?•˜?—¬ ë°”ì´?Š¸ ë°°ì—´?„ ì¶”ì¶œ?•´ë³´ì
         bytes  = s3.getBytes("EUC-KR");
         for (int i = 0; i < bytes.length; i++)
             System.out.printf("%x,", bytes[i]);
         System.out.println();
         
         // String ?´?˜?Š¤?—?„ ?Š¹? • ?¸?„œ?„´?Š¤ê°? ?•„?‹Œ ?¼ë°? ëª©ì ?œ¼ë¡? 
         // ë¬¸ì?—´?„ ?‹¤ë£? ?ˆ˜ ?ˆ?Š” ë©”ì„œ?“œë¥? ? œê³µí•œ?‹¤.
         // ì¦?, "?´?˜?Š¤ ë©”ì„œ?“œ = ?Š¤?ƒœ?‹± ë©”ì„œ?“œ"

         // => ?˜•?‹?„ ê°–ì¶˜ ë¬¸ì?—´?„ ë§Œë“¤ê¸?
         String s4 = String.format("%s?‹˜ ë°˜ê°‘?Šµ?‹ˆ?‹¤.", "?™ê¸¸ë™");
         System.out.println(s4);
         
      // => êµ¬ë¶„??? ë¬¸ì?—´?“¤?„ ?ŒŒ?¼ë¯¸í„°ë¡? ë°›ì•„?„œ ?ƒˆ ë¬¸ì?—´?„ ë§Œë“ ?‹¤.
         String s5 = String.join(":", "?™ê¸¸ë™", "?„êº½ì •", "?œ ê´??ˆœ");
         System.out.println(s5);
         
         // => primitive ê°’ì„ ë¬¸ì?—´ë¡? ë§Œë“ ?‹¤.
         String s6 = String.valueOf(true);
         String s7 = String.valueOf(3.14f);
         String s8 = String.valueOf(100);
         System.out.println(s6);
         System.out.println(s7);
         System.out.println(s8);
         
         
    }
        
        
        
}

