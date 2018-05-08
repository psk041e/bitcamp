// 프로퍼티 호출 - 객체 주입
package bitcamp.java106.step04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam02 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step04/application-context-02.xml");
        
        System.out.println(iocContainer.getBean("c1"));
        System.out.println(iocContainer.getBean("c2"));
        // 의존 객체를 만들어놓고 주입할수 있다.
        // 셋터메서드 순서는 신경쓰지 마라 값이 들어갔는지를 확인해라!
        
    }

}





