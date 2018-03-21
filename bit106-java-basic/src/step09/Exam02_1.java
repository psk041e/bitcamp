// ?Έ?€?΄?€ λ©μ??? ?΄??€ λ©μ?? ??© - String ?΄??€ 
package step09;
// ?Έ?€?΄?€ λ©μ? -> ?Έ?€?΄?€κ°? ??΄?Όλ§μ΄ ??? ???? λ©μ?
// ?Έ?€?΄?€λ₯? ?¬?©?μ§? ?? λ©μ??Όλ©? static? λΆμ¬?Ό ??€.
public class Exam02_1 {
    public static void main(String[] args) throws Exception {
        String s1 = new String("Hello"); 
        //                      01234
        
        
        // s1 ?Έ?€?΄?€(s1 ? ?Ό?°?€κ°? κ°?λ¦¬ν€? ?Έ?€?΄?€)? κ°μ μ‘°ν?? λ©μ? ?¬?©
        // ?°?Ό? ?΄ λ©μ?λ₯? ?ΈμΆν? €λ©? λ°λ? String ?Έ?€?΄?€? μ£Όμλ₯? μ€μΌ ??€.
        // ?Έ?€?΄?€ λ©μ?? λ°λ? ?Έ?€?΄?€ μ£Όμλ₯? μ£Όμ΄?Ό ?¬?©κ°??₯??€.
        char c = s1.charAt(1);
        System.out.println(c);
        
        // ?κ°? ?€??? λ¬Έμ?΄?Έμ§?, ???? λ¬Έμ?΄?Έμ§?λ₯? ?«?λ‘? ?? €μ€??€.
        System.out.println(s1.compareTo("Helli"));
        System.out.println(s1.compareTo("Hello")); // κ°μ?κ°μ΄? ??? -> 0 ?Έκ°? ??κ°?
        System.out.println(s1.compareTo("Hellu"));
        
        System.out.println(s1.contains("ll"));
        System.out.println(s1.contains("ee"));
        
        // ? λ¬Έμ?΄? ?°κ²°ν?¬ ?Έ λ¬Έμ?΄? λ§λ€?!
         String s2 = s1.concat(", world!");
         System.out.println(s1); // κΈ°μ‘΄ ?Έ?€?΄?€? κ°μ? λ³?κ²½νμ§? ???€.
         System.out.println(s2); // ?λ‘μ΄ λ¬Έμ?΄? λ§λ ?€. => Hello, world!
         
         // ? ?Έ?€?΄?€? ?€?΄ ?? λ¬Έμ?΄?΄ κ°μ? μ§? λΉκ΅?  ?, true/falseκ°μΌλ‘? ????Έ?€.  
         System.out.println(s1.equals("aaa"));
         System.out.println(s1.equals("Hello"));
         
         // ?Έ?€?΄?€? ?€?΄?? λ¬Έμ μ½λλ₯? λ°μ΄?Έ λ°°μ΄λ‘? λ§λ€?΄ λ¦¬ν΄??€.
         String s3 = new String("ABCκ°?κ°?");
         // => ?Έ?€?΄?€? ?€?΄ ?? κ°? λ¬Έμλ₯? λ°μ΄?Έ λ°°μ΄? ???₯?  ? 
         //    ?Έμ½λ© λ¬Έμμ§ν©? μ§?? ?μ§? ??Όλ©? JVM? κΈ°λ³Έ λ¬Έμμ§ν©?Όλ‘? ?Έμ½λ© ??€. 
         //    ?΄?΄λ¦½μ€?? JVM? ?€??λ©? JVM?? κΈ°λ³Έ?Όλ‘? UTF-8 λ¬Έμ?λ₯? ?¬?©??¬
         //    λ°μ΄?Έ λ°°μ΄? μ½λ κ°μ ???₯??€.
         byte[] bytes = s3.getBytes(); // λ°μ΄?Έ λ°°μ΄λ‘? λ§λ€?΄?Ό
         for (int i = 0; i < bytes.length; i++)
             System.out.printf("%x", bytes[i]);
         System.out.println();
           
         // ?€λ₯? ?Έ?€?΄?€ λ©μ?λ₯? ?¬?©??¬ λ°μ΄?Έ λ°°μ΄? μΆμΆ?΄λ³΄μ
         bytes  = s3.getBytes("EUC-KR");
         for (int i = 0; i < bytes.length; i++)
             System.out.printf("%x,", bytes[i]);
         System.out.println();
         
         // String ?΄??€?? ?Ή?  ?Έ??΄?€κ°? ?? ?Όλ°? λͺ©μ ?Όλ‘? 
         // λ¬Έμ?΄? ?€λ£? ? ?? λ©μ?λ₯? ? κ³΅ν?€.
         // μ¦?, "?΄??€ λ©μ? = ?€??± λ©μ?"

         // => ??? κ°μΆ λ¬Έμ?΄? λ§λ€κΈ?
         String s4 = String.format("%s? λ°κ°?΅??€.", "?κΈΈλ");
         System.out.println(s4);
         
      // => κ΅¬λΆ??? λ¬Έμ?΄?€? ??Όλ―Έν°λ‘? λ°μ? ? λ¬Έμ?΄? λ§λ ?€.
         String s5 = String.join(":", "?κΈΈλ", "?κΊ½μ ", "? κ΄??");
         System.out.println(s5);
         
         // => primitive κ°μ λ¬Έμ?΄λ‘? λ§λ ?€.
         String s6 = String.valueOf(true);
         String s7 = String.valueOf(3.14f);
         String s8 = String.valueOf(100);
         System.out.println(s6);
         System.out.println(s7);
         System.out.println(s8);
         
         
    }
        
        
        
}

