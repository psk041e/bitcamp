package bitcamp.java106.step13.ex02;

import org.springframework.stereotype.Component;

@Component
public class Y {
    
    public Y() {
        System.out.println("Y 객체 생성됨");
    }
    public void m2() {
        System.out.println("Y.m2()");
    }
}
