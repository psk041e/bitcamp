// Singleton ?¨?΄
// => κ°μ²΄λ₯? ? κ°λ§ ??±?  ? ?κ²? λ§λ? ?€κ³? κΈ°λ² (Calenderκ°? ?΄??κ°μ? λ°©μ?Όλ‘? ??΄??€.)
package step09.singleton;

public class Test {

    public static void main(String[] args) {
        // Singleton? ? ?©?μ§? ??? ?΄??€? ?Έ?€?΄?€ λ§λ€κΈ?
        Car c1 = new Car();
        Car c2 = new Car();
        Car c3 = new Car();
        // ?΄? κ²? ?Έ?€?΄?€ ??±? ? ??΄ ??€.
        
        System.out.println("-----------------");
        
        // Car2 ?΄??€? ??±?λ₯? ? κ·Όν  ? ?κΈ? ?λ¬Έμ ?ΈμΆν  ? ??€.
        // Car2 c1 = new Car2(); // μ»΄ν?Ό ?€λ₯?!
        
        
        Car2 x1 = Car2.getInstance();
        Car2 x2 = Car2.getInstance();
        Car2 x3 = Car2.getInstance();
        if (x1 == x2) System.out.println("x1 == x2");
        if (x2 == x3) System.out.println("x2 == x3");
        
        
        
    }
}
