// ?Έ?€?΄?€ λ©μ??? ?΄??€ λ©μ?? ??© - Math ?΄??€
package step09;

public class Exam02_3 {
    public static void main(String[] args) throws Exception {
        // Math ?΄??€? ?? κ΄?? ¨ λ©μ?λ₯? λͺ¨μ? ?΄??€?΄?€.
        // ? μ²? λ©μ?κ°? "?΄??€ λ©μ?=?€??± λ©μ?"?΄?€.
        
        // => ? ??κ°? κ³μ°
        System.out.println(Math.abs(-200));
        
        // => ceil() : ??Όλ―Έν°λ‘? μ£Όμ΄μ§? λΆ????? ?΄ λ°λ‘ ? ?° ? ? κ°μ λ¦¬ν΄
        // => floor() : ??Όλ―Έν°λ‘? μ£Όμ΄? λΆ????? ? λ°λ‘ λ°? ??? ? ? κ°μ λ¦¬ν΄
        System.out.println(Math.ceil(3.28)); // 4
        System.out.println(Math.floor(3.28)); // 3
        System.out.println(Math.ceil(-3.28)); // -3
        System.out.println(Math.floor(-3.28)); // -4
        
        // => 2? 7?Ή κ°μ ?κ³? ?Ά? ?
        System.out.println(Math.pow(2, 7));
        
        // => λ°μ¬λ¦Όν?¬ ? ? κ°? λ¦¬ν΄
        System.out.println(Math.round(3.14));
        System.out.println(Math.round(3.54));
        
        
    }
}





