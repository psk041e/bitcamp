// 의존 객체 주입 자동화하기 - 필수 의존 객체와 선택 의존 객체 (required=false)
package bitcamp.java106.step08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam06 {
    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step08/application-context-06.xml");
        
        System.out.println(iocContainer.getBean("c1"));
      
        // required를 설정해주지 않으면 다음과 같은 에러가 난다.
        // {@org.springframework.beans.factory.annotation.Autowired(required=true)}
        
    }

}





