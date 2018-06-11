package bitcamp.java106.step13.ex01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Caller { 
    @Autowired X x;
    @Autowired Y y;
    @Autowired Z z;
    
    public void test() {
        System.out.println("test()..... 시작");
        x.m();
        y.m();
        z.m();
        System.out.println("test()..... 끝");
    }
}
