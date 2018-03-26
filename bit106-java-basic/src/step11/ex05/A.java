package step11.ex05;

public class A {
    int v1;
    
    static {
        System.out.println("A클래스의 static{} 실행!"); 
        // static블록 A클래스가 로딩되는 시점에 실행된다.
    }
}
