// ?Έ?€?΄?€ λ©μ??? ?΄??€ λ©μ?? ??© - Date ?΄??€
package step09;

import java.util.Date;

public class Exam02_4 {
    public static void main(String[] args) {
        Date d1 = new Date();
        
        // ?Έ?€?΄?€ λ©μ? ??©
        System.out.println(d1.getYear() + 1900);
        System.out.println(d1.getMonth() + 1);
        System.out.println(d1.getDate());
        
        // ?€??± λ©μ? ??©
        long millis = Date.parse("Sat, 12 Aug 1995 13:30:00 GMT");
        System.out.println(millis);
        
        // ?€λ¬΄μ?? java.util.Date ???  ?΄ ?΄??€? ?? ?΄??€?Έ
        // java.sql.Date? ?°κΈ°λ ??€.
        // ?΄ ?΄??€? ? μ§? ?°?΄?°λ₯? λ¬Έμ?΄λ‘? ?€λ£? ? yyyy-MM-dd ???Όλ‘? ?€λ£¬λ€.
        
        
        // ?€??± λ©μ? ??©
        long currMillis = System.currentTimeMillis();
                
        // ??±? ??©
        java.sql.Date today = new java.sql.Date(currMillis);
        
        // ?Έ?€?΄?€ λ©μ? ??©
        String str = today.toString();
        System.out.println(str);
        
        // ?€??± λ©μ? ??©
        java.sql.Date d = java.sql.Date.valueOf("2018-03-21");
    }
}
