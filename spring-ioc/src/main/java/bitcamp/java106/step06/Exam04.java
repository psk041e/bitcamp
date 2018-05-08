// 팩토리 메서드 호출 - 인스턴스 메서드 호출
package bitcamp.java106.step06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam04 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step06/application-context-04.xml");
        
        System.out.println(iocContainer.getBean("c1"));
        
    }

}





