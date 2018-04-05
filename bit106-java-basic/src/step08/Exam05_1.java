// 변수의 초기화 - 자동 초기화
package step08;

public class Exam05_1 {
    static class A {
        static int a;
        int b;
    }
    public static void main(String[] args) {
        int c;
        
        // 클래스 변수는 생성되는 순간 0으로 자동 초기화된다.
        System.out.println(A.a);
        
        A obj1 = new A();
        
        // 인스턴스 변수는 생성되는 순간 0으로 자동 초기화된다.
        System.out.println(obj1.b);
        
        // 로컬 변수는 자동 초기화 되지 않는다.
        // 반드시 사용 전에 값을 저장해야 한다.
        // System.out.println(c); // 컴파일 오류!
    }
}
