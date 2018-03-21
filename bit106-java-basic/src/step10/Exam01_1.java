// String - "Hello" vs new String("Hello")
package step10;

public class Exam01_1 {
    public static void main(String[] args) {
        // String ?¸?Š¤?„´?Š¤ë¥? ?ƒ?„±?•˜?Š” ë°©ë²•
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        // => ?‚´?š©ë¬¼ì˜ ?™?¼?—¬ë¶?ë¥? ê²??‚¬?•˜ì§? ?•Šê³? ë¬´ì¡°ê±? ?¸?Š¤?„´?Š¤ë¥? ?ƒ?„±?•œ?‹¤.
        // => ê°?ë¹„ì?ê°? ?˜ë©? ê°?ë¹„ì? ì»¬ë ‰?„°?— ?˜?•´ ? œê±°ëœ?‹¤.
        if (s1 == s2) 
            System.out.println("s1 == s2");
        else
            System.out.println("s1 != s2");
        
        
        
        // string constant pool (?ƒ?ˆ˜ ???¥) ë©”ëª¨ë¦? ?˜?—­?— String ?¸?Š¤?„´?Š¤ë¥? ?ƒ?„±?•˜?Š” ë°©ë²•
        // -> java8 specification > 2.5.2. Java Virtual Machine Stacks ì°¸ê³ 
        String x1 = "Hello";
        String x2 = "Hello";
        // => ?‚´?š©ë¬¼ì´ ê°™ìœ¼ë©? ê¸°ì¡´ ?¸?Š¤?„´?Š¤?˜ ì£¼ì†Œë¥? ë¦¬í„´?•œ?‹¤.
        //    ì¦? ë©”ëª¨ë¦? ? ˆ?•½?„ ?œ„?•´ ì¤‘ë³µ ?°?´?„°ë¥? ê°–ëŠ” ?¸?Š¤?„´?Š¤ë¥? ?ƒ?„±?•˜ì§? ?•Š?Š”?‹¤.
        // => JVM?´ ??‚  ?•Œê¹Œì? ë©”ëª¨ë¦¬ì— ?œ ì§??œ?‹¤. (ê°?ë¹„ì? ì»¬ë ‰?„°?˜ ê´?ë¦¬ë??ƒ?´ ?•„?‹ˆ?‹¤.)
        if (x1 == x2) 
            System.out.println("x1 == x2");
        else
            System.out.println("x1 != x2");
        
        
        
    }
}
