// ?¸?Š¤?„´?Š¤ ë©”ì„œ?“œ?? ?´?˜?Š¤?˜ ë©”ì„œ?“œ ?™œ?š© - wrapper ?´?˜?Š¤
package step09;

public class Exam02_2 {
    public static void main(String[] args) throws Exception{
        Integer i1 = new Integer(100);
        Integer i2 = new Integer(200);
        Integer i3 = new Integer(300);
        
        // ?¸?Š¤?„´?Š¤ ë©”ì„œ?“œ ?‚¬?š©
        System.out.println(i2.compareTo(i1));
        System.out.println(i2.compareTo(i3));
        
        int v1 = i2.intValue(); // i2?— ?“¤?–´?ˆ?Š” ê°’ì„ ?¸?Š¸ê°’ìœ¼ë¡? ë½‘ì•„?„œ ë¦¬í„´?•´ì¤??‹¤.
        System.out.println(v1);
        
        // ?Š¤?ƒœ?‹± ë©”ì„œ?“œ = ?´?˜?Š¤ ë©”ì„œ?“œ ?‚¬?š©
        int v2 = Integer.parseInt("1280");
        String s1 = Integer.toBinaryString(77);
        String s2 = Integer.toOctalString(77);
        String s3 = Integer.toString(77);
        System.out.printf("77 = %s, %s, %s\n", s1, s2, s3);
        
        Integer x1 = Integer.valueOf("44");// ë¬¸ì?—´?´ ?ˆ?Š” ?ˆ˜ë¥? 10ì§„ìˆ˜ë¡? ê°„ì£¼?•œ?‹¤
        Integer x2 = Integer.valueOf("44", 16);// 16ì§„ìˆ˜?¼ê³? ???¥?•œ?‹¤.
        System.out.printf("%d, %d\n", x1, x2);
        
        float f = Float.parseFloat("3.14f");
        boolean b = Boolean.parseBoolean("true");
        System.out.printf("%f, %b\n", f, b);
       
    }

}
