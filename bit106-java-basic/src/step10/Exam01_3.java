// String - mutable(λ°κ? ? ??) vs immutable(λ°κ? ? ??) κ°μ²΄ -> ?€λ₯? ?Έ?΄??? ?¬?©??€.
// λ©λͺ¨λ¦¬κ? ?λ²? κ³ μ ?λ©? λ°κ?? ??΄?Ό ?λ‘κ·Έ?¨ ?€??΄ λΉ λ₯΄?€. κ·Έλ? κΈ°λ³Έ? ?Όλ‘? immutableκ°μ²΄?Έ κ²½μ°κ°? μ’λ€.
package step10;

public class Exam01_3 {
    public static void main(String[] args) {
        // String κ°μ²΄? ? ?? ?Έ immutable κ°μ²΄?΄?€.
        // μ¦?, ? λ²? κ°μ²΄? κ°μ ?΄?Όλ©? λ³?κ²½ν  ? ??€.
        
        String s1 = new String("Hello");
        
        // String ?΄??€?? ? κ³΅ν? ?΄?€ λ©μ?λ₯? ?ΈμΆν? μ§? κ°μ 
        // ??? ?°?΄?°λ₯? λ³?κ²½νμ§? ???€.
        // ?€λ§?, ?λ‘? String κ°μ²΄λ₯? λ§λ€ λΏμ΄?€.
        String s2 = s1.replace('l', 'x');
        System.out.printf("%s : %s\n", s1, s2); // ?λ³Έμ? λ°λ?μ? ???€.
        
        String s3 = s1.concat(", world!");
        System.out.printf("%s : %s\n", s1, s3); // ?λ³Έμ? λ°λ?μ? ???€.
        
        // StringBuffer? mutable κ°μ²΄?΄?€.
        // ??? λ¬Έμ?΄? λ³?κ²½νκ³? ?Ά? ? ?¬?©?? ?΄??€?΄?€.
        StringBuffer buf = new StringBuffer("Hello");
        //                                   01234
        buf.replace(2, 4, "xx"); // replace?¬?©λ²μ΄ μ‘°κΈ ?€λ₯΄λ€. ?λ²νΈ? λ°κΎΈκ³ μΆ?? λ¬Έμ ?€?? ?Έ?±?€λ₯? ?¨μ€??€.
        System.out.println(buf); // ?λ³Έμ λ°κΎΌ?€.
        
        // Stringκ°μ²΄ κ°μ λ°κΎΈκ²? ?λ©? κ°μ²΄λ₯? κ³μ ??±?? λ©λͺ¨λ¦¬λ?? ?­λΉν? ?κ°? ??€
        // ?°?Ό? κ°μ²΄? κ°μ λ°κΎΈκ³? ?Ά?Όλ©? StringBufferλ₯? ?¬?©?΄? λ°κΏμ£Όλκ²μ΄ μ’λ€.
        
        // StringBuffer ?¬?©? μ£Όμ?¬?­!
        // StringBuffer? ?΄?©λ¬Όμ λΉκ΅?  ? equals()λ₯? ?¬?©?΄λ΄μΌ ??©??€.
        // == ?°?°??? κ°μ? κ²°κ³Όλ₯? μΆλ ₯??€.
        StringBuffer b1 = new StringBuffer("Hello");
        StringBuffer b2 = new StringBuffer("Hello");
        if (b1.equals(b2)) 
            System.out.println("b1 == b2");
        else
            System.out.println("b1 != b2");
        
        // ?΄κ²°μ±?
        // => StringBuffer?? String? κΊΌλ΄ λΉκ΅??Ό!
        if (b1.toString().equals(b2.toString())) 
            System.out.println("b1.toString() == b2.toString()");
        else
            System.out.println("b1.toString() != b2.toString()");
        
    }
}
