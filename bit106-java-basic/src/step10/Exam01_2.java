// String - ë¬¸ìž?—´ ë¹„êµ
package step10;

public class Exam01_2 {
    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        String s3 = "Hello";
        // ?¸?Š¤?„´?Š¤?˜ ì£¼ì†Œê°? ?•„?‹Œ ?¸?Š¤?„´?Š¤?˜ ?°?´?„°ê°? ê°™ì?ì§? ë¹„êµ?•  ?•Œ?Š”
        // equals()?¼?Š” ë©”ì„œ?“œë¥? ?‚¬?š©?•˜?¼!
        if (s1.equals(s2)) 
            System.out.println("s1ê³? s2?Š” ê°™ë‹¤.");
        else
            System.out.println("s1ê³? s2?Š” ?‹¤ë¥´ë‹¤.");
        
        if (s1.equals(s3)) 
            System.out.println("s1ê³? s3?Š” ê°™ë‹¤.");
        else
            System.out.println("s1ê³? s3?Š” ?‹¤ë¥´ë‹¤.");
        
        // => ì£¼ì†Œê°’ì— ?ƒê´??—†?´ ?‚´?š©ë¬¼ì? ëª¨ë‘ ê°™ë‹¤.
        
    }
}
