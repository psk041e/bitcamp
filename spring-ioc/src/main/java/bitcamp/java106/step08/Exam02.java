// 의존 객체 주입 자동화하기 - 셋터에 @Autowired 애노테이션 붙이기 
package bitcamp.java106.step08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam02 {
// AutowiredAnnotationBeanPost(이후에)Processor: bean을 생성한 이후에 AutowiredAnnotation을 처리하는 처리기 (사후작업)
    // ex) BeanPre: 사전작업
    public static void main(String[] args) {
        // @Autowired 애노테이션을 처리할 객체를 등록해야만 
        // 의존객체가 자동으로 주입된다.
        // [동작원리]
        // 1) 스프링 IoC 컨테이너는 객체를 만든다.
        // 2) 프로퍼티 값을 설정한다.
        // 3) 객체 생성 후 @Autowired 애노테이션을 처리한다.
        //    => 단, @Autowired 애노테이션을 읽고 처리할 객체가 등록되어 있어야 한다.
        //    => 궁금한것이 있다!
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step08/application-context-02.xml");
        
        // Car 객체를 꺼내 Engine 객체가 주입되었는지 확인해보자!
        System.out.println(iocContainer.getBean("c1"));
        
        /* @Autowired 애노테이션 처리객체 등록 전 결과:
            Car()
            Car.setModel()
            Car.setMaker()
            Car.setCc()
            Car.setAuto()
            Car [model=티코, maker=비트자동차, cc=890, auto=true, createdDate=null, engine=null]
        */
        
        /* @Autowired 애노테이션 처리객체 등록 후 결과:
        Car()
        Car.setEngine() ○
        Car.setModel()
        Car.setMaker()
        Car.setCc()
        Car.setAuto()
        Car [model=티코, maker=비트자동차, cc=890, auto=true, createdDate=null, engine=Engine [maker=비트자동차, valve=16, cylinder=4]]
        */        
                
    }

}





