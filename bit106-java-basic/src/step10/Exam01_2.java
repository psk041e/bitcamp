// String - λ¬Έμ?΄ λΉκ΅
package step10;

public class Exam01_2 {
    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        String s3 = "Hello";
        // ?Έ?€?΄?€? μ£Όμκ°? ?? ?Έ?€?΄?€? ?°?΄?°κ°? κ°μ?μ§? λΉκ΅?  ??
        // equals()?Ό? λ©μ?λ₯? ?¬?©??Ό!
        if (s1.equals(s2)) 
            System.out.println("s1κ³? s2? κ°λ€.");
        else
            System.out.println("s1κ³? s2? ?€λ₯΄λ€.");
        
        if (s1.equals(s3)) 
            System.out.println("s1κ³? s3? κ°λ€.");
        else
            System.out.println("s1κ³? s3? ?€λ₯΄λ€.");
        
        // => μ£Όμκ°μ ?κ΄???΄ ?΄?©λ¬Όμ? λͺ¨λ κ°λ€.
        
    }
}
