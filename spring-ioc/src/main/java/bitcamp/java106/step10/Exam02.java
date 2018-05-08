// 클래스를 이용하여 스프링 설정하기 - @Configuration 애노테이션
package bitcamp.java106.step10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam02 {

    public static void main(String[] args) {
        // 패키지 명을 지정하면 
        // 해당 패키지의 모든 클래스르 찾아 @Component, @Service, @Controlelr, @Repository
        // 애노테이션이 붙은 클래스에 대해 객체를 자동 생성한다.
        // 또한,
        // @Configuration 애노테이션이 붙은 클래스를 찾아
        // 그 클래스에 @Bean 애노테이션이 붙은 메서드를 호출하여 그 리턴 값을 저장한다.
        // 그래서 이 방법도 많이 쓴다.
        // 패키지를 지정하면 이 패키지를 다 훑어서 @Configuration
        // 설정 정보를 갖고 있는 
        // 콕 찝어서 이 클래스가 
        // 이 패키지에서 @Configuration이 붙은 모든 클래스를 찾아라 
        // -> 이것이 설정 정보를 담고 있는 클래스임을 선포하는 것이다.
        ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(
                        "bitcamp.java106.step10"); // 패키지명을 줄 수도 있다.
        
        BeanUtils.printBeanNames(iocContainer);
        
        /* 결과: car3는 @Bean이 붙지 않았기 때문에 출력되지 않는다.
            appConfig02
            car
            engine
            car2
        */
    }

}





