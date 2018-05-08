// 의존 객체 주입 자동화하기 - 같은 타입의 의존 객체가 여러 개 있을 때; @Qualifier 애노테이션
package bitcamp.java106.step08;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam07 {
    public static void main(String[] args) {
        // @Qualifier 애노테이션을 붙이면,
        // 같은 타입의 객체가 여러 개 있다 하더라도 그 중에 지정된 이름을 갖는 객체가 주입된다.
        // 그러나, 막상 실행을 하면 Engine 객체가 여러 개 있다고 실행 오류가 발생한다.
        // 이유는?
        // => @Qualifier 애노테이션을 처리할 BeanPostProcessor가 없기 때문이다.
        // 해결책?
        // => @Qualifier 애노테이션을 처리할 BeanPostProcessor를 등록하면 된다.
        //
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step08/application-context-07.xml");
        
        System.out.println(iocContainer.getBean("c1"));
        System.out.println("-------------------------------");
        
        
        // @Qualifier("e2")작성전: 에러가난다.
        // org.springframework.beans.factory.NoUniqueBeanDefinitionException
        // expected single matching bean but found 2: e1,e2
        // => 한개만 들어가야 하는데 두개가 존재하니까 어떤것을 꼽아야 할지 모르겠다.
        // bean이 한개만 존재해야 하는데 한개가 아니다
        //  
        
        BeanUtils.printBeanNames(iocContainer);
        /* 결과:
        [생성된 빈의 이름 목록]
         org.springframework.context.annotation.internalConfigurationAnnotationProcessor
         org.springframework.context.annotation.internalAutowiredAnnotationProcessor
         org.springframework.context.annotation.internalRequiredAnnotationProcessor
         org.springframework.context.annotation.internalCommonAnnotationProcessor
         org.springframework.context.event.internalEventListenerProcessor
         org.springframework.context.event.internalEventListenerFactory
         c1
         e1
         e2
         */
        
        // 메모리 아까워하지 말아라!
        // 객체를 일일이 등록하게되면 
        // 나중에 업그레이드 했을 때 xml태그를 계속 바꿔줘야 하기 때문에 유지보수가 번거롭다.
        // spring이 6.0이 되는 경우 없어지거나 새로 생기는 객체가 있을 것이다.
        // 이런 경우에 개발자의 번거로움을 주지 않기 위해 <context:annotation-config/>를 사용한다.
        
    }

}





