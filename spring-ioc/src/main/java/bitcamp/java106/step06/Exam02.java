// 팩토리 메서드 호출 - static 메서드 호출 응용
package bitcamp.java106.step06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam02 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step05/application-context-02.xml");
        
        System.out.println(iocContainer.getBean("d1"));
        // 클래스의 스태틱 메서드를 호출해서 그 리턴값을 저장할 때 팩토리 메서드를 사용한다.
        
    }

}





