// 클래스를 이용하여 스프링 설정하기
package bitcamp.java106.step10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam01 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(AppConfig01.class); // 클래스 이름 지정
        // 클래스 안에 Annotation으로 config하겠다.
        
        BeanUtils.printBeanNames(iocContainer);
        
        /* 결과: getCar -> 메서드 이름대로 결과가 나온다.
        [생성된 빈의 이름 목록]
                org.springframework.context.annotation.internalConfigurationAnnotationProcessor
                org.springframework.context.annotation.internalAutowiredAnnotationProcessor
                org.springframework.context.annotation.internalRequiredAnnotationProcessor
                org.springframework.context.annotation.internalCommonAnnotationProcessor
                org.springframework.context.event.internalEventListenerProcessor
                org.springframework.context.event.internalEventListenerFactory
                appConfig01
                getCar
        */
    }

}





