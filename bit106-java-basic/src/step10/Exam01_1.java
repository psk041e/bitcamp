// String - "Hello" vs new String("Hello")
package step10;

public class Exam01_1 {
    public static void main(String[] args) {
        // String ?Έ?€?΄?€λ₯? ??±?? λ°©λ²
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        // => ?΄?©λ¬Όμ ??Ό?¬λΆ?λ₯? κ²??¬?μ§? ?κ³? λ¬΄μ‘°κ±? ?Έ?€?΄?€λ₯? ??±??€.
        // => κ°?λΉμ?κ°? ?λ©? κ°?λΉμ? μ»¬λ ?°? ??΄ ? κ±°λ?€.
        if (s1 == s2) 
            System.out.println("s1 == s2");
        else
            System.out.println("s1 != s2");
        
        
        
        // string constant pool (?? ???₯) λ©λͺ¨λ¦? ??­? String ?Έ?€?΄?€λ₯? ??±?? λ°©λ²
        // -> java8 specification > 2.5.2. Java Virtual Machine Stacks μ°Έκ³ 
        String x1 = "Hello";
        String x2 = "Hello";
        // => ?΄?©λ¬Όμ΄ κ°μΌλ©? κΈ°μ‘΄ ?Έ?€?΄?€? μ£Όμλ₯? λ¦¬ν΄??€.
        //    μ¦? λ©λͺ¨λ¦? ? ?½? ??΄ μ€λ³΅ ?°?΄?°λ₯? κ°λ ?Έ?€?΄?€λ₯? ??±?μ§? ???€.
        // => JVM?΄ ??  ?κΉμ? λ©λͺ¨λ¦¬μ ? μ§???€. (κ°?λΉμ? μ»¬λ ?°? κ΄?λ¦¬λ???΄ ???€.)
        if (x1 == x2) 
            System.out.println("x1 == x2");
        else
            System.out.println("x1 != x2");
        
        
        
    }
}
