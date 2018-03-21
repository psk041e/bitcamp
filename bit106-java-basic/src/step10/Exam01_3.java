// String - mutable(Î∞îÍ? ?àò ?ûà?äî) vs immutable(Î∞îÍ? ?àò ?óÜ?äî) Í∞ùÏ≤¥ -> ?ã§Î•? ?ñ∏?ñ¥?óê?Ñú?èÑ ?Ç¨?ö©?ïú?ã§.
// Î©îÎ™®Î¶¨Í? ?ïúÎ≤? Í≥†Ï†ï?êòÎ©? Î∞îÍ??àò ?óÜ?ñ¥?ïº ?îÑÎ°úÍ∑∏?û® ?ã§?ñâ?ù¥ Îπ†Î•¥?ã§. Í∑∏Îûò?Ñú Í∏∞Î≥∏?†Å?úºÎ°? immutableÍ∞ùÏ≤¥?ù∏ Í≤ΩÏö∞Í∞? Ï¢ãÎã§.
package step10;

public class Exam01_3 {
    public static void main(String[] args) {
        // String Í∞ùÏ≤¥?äî ?†Ñ?òï?†Å?ù∏ immutable Í∞ùÏ≤¥?ù¥?ã§.
        // Ï¶?, ?ïú Î≤? Í∞ùÏ≤¥?óê Í∞íÏùÑ ?ã¥?úºÎ©? Î≥?Í≤ΩÌï† ?àò ?óÜ?ã§.
        
        String s1 = new String("Hello");
        
        // String ?Å¥?ûò?ä§?óê?Ñú ?†úÍ≥µÌïò?äî ?ñ¥?ñ§ Î©îÏÑú?ìúÎ•? ?ò∏Ï∂úÌïò?ì†Ïß? Í∞ÑÏóê 
        // ?õê?ûò?ùò ?ç∞?ù¥?Ñ∞Î•? Î≥?Í≤ΩÌïòÏß? ?ïä?äî?ã§.
        // ?ã§Îß?, ?ÉàÎ°? String Í∞ùÏ≤¥Î•? ÎßåÎì§ ÎøêÏù¥?ã§.
        String s2 = s1.replace('l', 'x');
        System.out.printf("%s : %s\n", s1, s2); // ?õêÎ≥∏Ï? Î∞îÎ?åÏ? ?ïä?äî?ã§.
        
        String s3 = s1.concat(", world!");
        System.out.printf("%s : %s\n", s1, s3); // ?õêÎ≥∏Ï? Î∞îÎ?åÏ? ?ïä?äî?ã§.
        
        // StringBuffer?äî mutable Í∞ùÏ≤¥?ù¥?ã§.
        // ?õê?ûò?ùò Î¨∏Ïûê?ó¥?ùÑ Î≥?Í≤ΩÌïòÍ≥? ?ã∂?ùÑ ?ïå ?Ç¨?ö©?ïò?äî ?Å¥?ûò?ä§?ù¥?ã§.
        StringBuffer buf = new StringBuffer("Hello");
        //                                   01234
        buf.replace(2, 4, "xx"); // replace?Ç¨?ö©Î≤ïÏù¥ Ï°∞Í∏à ?ã§Î•¥Îã§. ?ÅùÎ≤àÌò∏?äî Î∞îÍæ∏Í≥†Ïã∂?? Î¨∏Ïûê ?ã§?ùå?ùò ?ù∏?ç±?ä§Î•? ?ç®Ï§??ã§.
        System.out.println(buf); // ?õêÎ≥∏ÏùÑ Î∞îÍæº?ã§.
        
        // StringÍ∞ùÏ≤¥ Í∞íÏùÑ Î∞îÍæ∏Í≤? ?êòÎ©? Í∞ùÏ≤¥Î•? Í≥ÑÏÜç ?Éù?Ñ±?êò?Ñú Î©îÎ™®Î¶¨Î?? ?Ç≠ÎπÑÌïò?äî ?àòÍ∞? ?ûà?ã§
        // ?î∞?ùº?Ñú Í∞ùÏ≤¥?ùò Í∞íÏùÑ Î∞îÍæ∏Í≥? ?ã∂?úºÎ©? StringBufferÎ•? ?Ç¨?ö©?ï¥?Ñú Î∞îÍøîÏ£ºÎäîÍ≤ÉÏù¥ Ï¢ãÎã§.
        
        // StringBuffer ?Ç¨?ö©?ãú Ï£ºÏùò?Ç¨?ï≠!
        // StringBuffer?ùò ?Ç¥?ö©Î¨ºÏùÑ ÎπÑÍµê?ï† ?ïå equals()Î•? ?Ç¨?ö©?ï¥Î¥êÏïº ?Üå?ö©?óÜ?ã§.
        // == ?ó∞?Ç∞?ûê?? Í∞ôÏ? Í≤∞Í≥ºÎ•? Ï∂úÎ†•?ïú?ã§.
        StringBuffer b1 = new StringBuffer("Hello");
        StringBuffer b2 = new StringBuffer("Hello");
        if (b1.equals(b2)) 
            System.out.println("b1 == b2");
        else
            System.out.println("b1 != b2");
        
        // ?ï¥Í≤∞Ï±Ö?
        // => StringBuffer?óê?Ñú String?ùÑ Í∫ºÎÇ¥ ÎπÑÍµê?ïò?ùº!
        if (b1.toString().equals(b2.toString())) 
            System.out.println("b1.toString() == b2.toString()");
        else
            System.out.println("b1.toString() != b2.toString()");
        
    }
}
