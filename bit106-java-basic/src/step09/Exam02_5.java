// ?Έ?€?΄?€ λ©μ??? ?΄??€ λ©μ?? ??© - Calendar ?΄??€
package step09;

import java.util.Calendar;
import java.util.Date;

public class Exam02_5 {
    public static void main(String[] args) throws Exception {
        // Calendar ?΄??€? ??±?? protectedλ‘? ? κ·Όμ΄ ? ???΄ ?κΈ? ?λ¬Έμ
        // ?€λ₯? ?¨?€μ§??? μ§μ  ??±?λ₯? ?ΈμΆν  ? ??€. -> Car2?΄??€ μ°Έκ³ 
        // Calendar c = new Calendar(); //μ»΄ν?Ό ?€λ₯?!
        
        // ?€? ? μ§? λ°? ?κ°? ? λ³΄λ?? ???₯? κ°μ²΄λ₯? λ§λ€?΄ λ¦¬ν΄??€.
        // ?¬? ₯?? κ·Έλ κ³ λ¦¬? ?¬? ₯? ?¬?©??€.(GMT)
        Calendar c = Calendar.getInstance();
        
        // ?Έ?€?΄?€ λ©μ? ??© (ctrl?λ₯? ? Calendar ?΄λ¦??λ©? ??,?,?Ό,??Ό ?±? μΆλ ₯?΄μ£Όλ ?«?λ₯? λ³Όμ??€.)
        System.out.println(c.get(1)); // ??λ₯? λ½μμ£Όκ²? get?΄?Ό? λ©μ?κ°? ?΄?₯??΄??€.
        System.out.println(c.get(2) + 1); // ?(0 ~ 11)
        System.out.println(c.get(5)); // ?Ό
        System.out.println(c.get(7)); // ??Ό(1 ~ 7) ? ??Ό: μ£Όλ§(μ£Όμ λ§μ?λ§λ ), ?Ό??Ό: μ£Όμ μ²«μ§Έ? 
        System.out.println(c.get(4)); // κ·? ?¬? λͺλ²μ§? μ£?
        System.out.println(c.get(10)); // ?(0 ~ 11)
        System.out.println(c.get(11)); // ?(24? κΈ°μ?)
        System.out.println(c.get(12)); // λΆ?
        System.out.println(c.get(13)); // μ΄?
        
        // ??? ??© -> step08? Exam01_6μ°Έκ³ 
        // ?«?λ₯? ?κΈ°νκΈ? ??€?€ -> ?΄λΆ?? ?Όλ‘? ??κ°? ? ???΄??€.
        System.out.println(c.get(Calendar.YEAR)); // ??λ₯? λ½μμ£Όκ²? get?΄?Ό? λ©μ?κ°? ?΄?₯??΄??€.
        System.out.println(c.get(Calendar.MONTH) + 1); // ?(0 ~ 11)
        System.out.println(c.get(Calendar.DATE)); // ?Ό
        System.out.println(c.get(Calendar.DAY_OF_WEEK)); // ??Ό(1 ~ 7) ? ??Ό: μ£Όλ§(μ£Όμ λ§μ?λ§λ ), ?Ό??Ό: μ£Όμ μ²«μ§Έ? 
        System.out.println(c.get(Calendar.WEEK_OF_MONTH)); // κ·? ?¬? λͺλ²μ§? μ£?
        System.out.println(c.get(Calendar.HOUR)); // ?(0 ~ 11)
        System.out.println(c.get(Calendar.HOUR_OF_DAY)); // ?(24? κΈ°μ?)
        System.out.println(c.get(Calendar.MINUTE)); // λΆ?
        System.out.println(c.get(Calendar.SECOND)); // μ΄?
        
        
    }
}





