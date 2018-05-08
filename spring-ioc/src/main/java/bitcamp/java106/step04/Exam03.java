// 프로퍼티 호출 - 객체 주입 시 객체 생성 순서
package bitcamp.java106.step04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam03 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step04/application-context-03.xml");
        
        //결과
        //셋터메서드의 파라미터값중에서 String이나 int의 타입이 있는지를 검사하고
        // 
    }

}





