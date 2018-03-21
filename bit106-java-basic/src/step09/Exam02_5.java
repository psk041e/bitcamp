// ?��?��?��?�� 메서?��?? ?��?��?�� 메서?��?�� ?��?�� - Calendar ?��?��?��
package step09;

import java.util.Calendar;
import java.util.Date;

public class Exam02_5 {
    public static void main(String[] args) throws Exception {
        // Calendar ?��?��?��?�� ?��?��?��?�� protected�? ?��근이 ?��?��?��?�� ?���? ?��문에
        // ?���? ?��?���??��?�� 직접 ?��?��?���? ?��출할 ?�� ?��?��. -> Car2?��?��?�� 참고
        // Calendar c = new Calendar(); //컴파?�� ?���?!
        
        // ?��?�� ?���? �? ?���? ?��보�?? ???��?�� 객체�? 만들?�� 리턴?��?��.
        // ?��?��?? 그레고리?�� ?��?��?�� ?��?��?��?��.(GMT)
        Calendar c = Calendar.getInstance();
        
        // ?��?��?��?�� 메서?�� ?��?�� (ctrl?���? ?�� Calendar ?���??���? ?��?��,?��,?��,?��?�� ?��?�� 출력?��주는 ?��?���? 볼수?��?��.)
        System.out.println(c.get(1)); // ?��?���? 뽑아주게?�� get?��?��?�� 메서?���? ?��?��?��?��?��?��.
        System.out.println(c.get(2) + 1); // ?��(0 ~ 11)
        System.out.println(c.get(5)); // ?��
        System.out.println(c.get(7)); // ?��?��(1 ~ 7) ?��?��?��: 주말(주의 마�?막날), ?��?��?��: 주의 첫째?��
        System.out.println(c.get(4)); // �? ?��?�� 몇번�? �?
        System.out.println(c.get(10)); // ?��(0 ~ 11)
        System.out.println(c.get(11)); // ?��(24?�� 기�?)
        System.out.println(c.get(12)); // �?
        System.out.println(c.get(13)); // �?
        
        // ?��?��?�� ?��?�� -> step08?�� Exam01_6참고
        // ?��?���? ?��기하�? ?��?��?�� -> ?���??��?���? ?��?���? ?��?��?��?��?��?��.
        System.out.println(c.get(Calendar.YEAR)); // ?��?���? 뽑아주게?�� get?��?��?�� 메서?���? ?��?��?��?��?��?��.
        System.out.println(c.get(Calendar.MONTH) + 1); // ?��(0 ~ 11)
        System.out.println(c.get(Calendar.DATE)); // ?��
        System.out.println(c.get(Calendar.DAY_OF_WEEK)); // ?��?��(1 ~ 7) ?��?��?��: 주말(주의 마�?막날), ?��?��?��: 주의 첫째?��
        System.out.println(c.get(Calendar.WEEK_OF_MONTH)); // �? ?��?�� 몇번�? �?
        System.out.println(c.get(Calendar.HOUR)); // ?��(0 ~ 11)
        System.out.println(c.get(Calendar.HOUR_OF_DAY)); // ?��(24?�� 기�?)
        System.out.println(c.get(Calendar.MINUTE)); // �?
        System.out.println(c.get(Calendar.SECOND)); // �?
        
        
    }
}





