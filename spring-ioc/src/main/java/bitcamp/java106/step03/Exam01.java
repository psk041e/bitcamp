// 생성자 호출
package bitcamp.java106.step03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam01 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step03/application-context-01.xml");
        
        BeanUtils.printBeanNames(iocContainer);
        // 생성자를 호출하는 방법
        // 파라미터 값이 들어가는 순서는 index로 지정할 수 있다.
        
    }

}





