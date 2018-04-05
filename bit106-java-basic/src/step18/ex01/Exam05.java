// Reflection API : 클래스 로딩과 인스턴스 생성
package step18.ex01;


public class Exam05 {
    static class A {
        void m() {
            System.out.println("Hello!");
        }
    }
    
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("step18.ex01.Exam05$A");
        
        
        // 타입(클래스) 정보만 있다면 인스턴스 생성할 수 있다.
        A obj = (A) clazz.newInstance(); // A 클래스 객체를 리턴한다.
        obj.m();
        // 클래스 정보만 알고 있다면 클래스 정보를 로딩해서 인스턴스를 만들 수 있다.
        // => 클래스 이름만 알면 언제든지 어느 클래스든지 다 인스턴스를 생성할수 있다.
        
    
    }        
        
}
