// Exception 예외 던지고 받기
package step21.ex04;

public class Exam01 {
    
    static void m1() {
        m2();
    }
    
    static void m2() {
        m3();
    }
    
    static void m3() {
        m4();
    }
    
    static void m4() {
        System.out.println("m4() 실행됨!");
    }
    
    public static void main(String[] args) {
        m1();
    }
}
