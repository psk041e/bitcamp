// Wrapper ?΄??€ - wrapper κ°μ²΄? κ°? λΉκ΅
package step10;

public class Exam02_3 {
    public static void main(String[] args) {
        Integer obj1 = new Integer(100); // Heap ? ?Έ?€?΄?€ ??±
        Integer obj2 = new Integer(100); // Heap ? ?Έ?€?΄?€ ??±
        if (obj1 == obj2) // ?Έ?€?΄?€? μ£Όμ λΉκ΅
            System.out.println("obj1 == obj2");
        else
            System.out.println("obj1 != obj2");
        
        Integer obj3 = 100; // constant pool ? ??±
        Integer obj4 = 100; // constant pool ? ??±? κΈ°μ‘΄ μ£Όμ λ¦¬ν΄
        if (obj3 == obj4) // ?Έ?€?΄?€? μ£Όμκ°? κ°λ€.
            System.out.println("obj3 == obj4");
        else
            System.out.println("obj3 != obj4");
        
        int i = 100;
        Integer obj5 = new Integer(100);
        if (i == obj5) // obj5κ°? auto-unboxing ? ????¬ int?? intλ₯? λΉκ΅??€.
                       // ?°?°?? ?κ°κ? κ°μ? μ’λ₯κ°? ??λ©? ???  ? ??€.
            System.out.println("i == obj5");
        else
            System.out.println("i != obj5");
        
        
        
        
    }
}
