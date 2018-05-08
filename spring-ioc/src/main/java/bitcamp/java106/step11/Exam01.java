// 클래스를 이용하여 스프링 설정하기
package bitcamp.java106.step11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam01 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(AppConfig01.class);
        
        BeanUtils.printBeanNames(iocContainer);
        
        // 클래스에 애노테이션을 
        // 근래 들어서 xml 보다 이 방법을 많이 쓴다.
        // 그러나 실무에 들어가면 예전에 쓰던 방법들이 많을수 있다.
        // 
        /* 결과: b패키지의 클래스들이 제외되었다.
            appConfig01
            a
            c
            car
            engine
            car2
        */
        
        // micro service
        // 자잘한 것들을 여러개 실행하는 방법
        // ex) node.js, spring boot(xml이 아닌 클래스의 애노테이션을 통해서 설정한다.)
        
        
        System.out.println(iocContainer.getBean("car")); // 아무 값도 저장되어 있지 않다.
    }

}





