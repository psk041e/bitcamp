// ?��?��?��?�� 메서?��?? ?��?��?�� 메서?��?�� ?��?�� - Date ?��?��?��
package step09;

import java.util.Date;

public class Exam02_4 {
    public static void main(String[] args) {
        Date d1 = new Date();
        
        // ?��?��?��?�� 메서?�� ?��?��
        System.out.println(d1.getYear() + 1900);
        System.out.println(d1.getMonth() + 1);
        System.out.println(d1.getDate());
        
        // ?��?��?�� 메서?�� ?��?��
        long millis = Date.parse("Sat, 12 Aug 1995 13:30:00 GMT");
        System.out.println(millis);
        
        // ?��무에?��?�� java.util.Date ???�� ?�� ?��?��?��?�� ?��?�� ?��?��?��?��
        // java.sql.Date?�� ?��기도 ?��?��.
        // ?�� ?��?��?��?�� ?���? ?��?��?���? 문자?���? ?���? ?�� yyyy-MM-dd ?��?��?���? ?��룬다.
        
        
        // ?��?��?�� 메서?�� ?��?��
        long currMillis = System.currentTimeMillis();
                
        // ?��?��?�� ?��?��
        java.sql.Date today = new java.sql.Date(currMillis);
        
        // ?��?��?��?�� 메서?�� ?��?��
        String str = today.toString();
        System.out.println(str);
        
        // ?��?��?�� 메서?�� ?��?��
        java.sql.Date d = java.sql.Date.valueOf("2018-03-21");
    }
}
