// 의존 객체 주입 자동화하기 - 생성자를 이용하여 의존 객체 주입 -> 이것을 더 선호한다. 
// 그러나 실무에 가면 셋터에 꼽거나 인스턴스 변수에 꼽는것을 많이 볼 것이다!
package bitcamp.java106.step08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam05 {
    public static void main(String[] args) {
        // @Autowired 애노테이션을 인스턴스 변수에 붙여도 된다.
        // => 그러면 의존 객체를 직접 변수에 주입한다.
        // => 셋터를 호출하지 않는다.
        //    즉 셋터가 없어도 된다. 현업에 가면 이 방식을 가장 많이 보게 될 것이다.
        // => 인스턴스 변수에 직접 의존 객체를 주입한다는 것은
        //    캡슐화, 즉 외부에서 직접 인스턴스 변수에 접근하는 것을 막는 기법, 를
        //    위배하는 측면이 있기 때문에
        //    ★ 이 방식은 "객체지향을 파괴하는 방식"이라는 비난을 받는다.★
        //  
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step08/application-context-05.xml");
        
        // Car 객체를 꺼내 Engine 객체가 주입되었는지 확인해보자!
        System.out.println(iocContainer.getBean("c1"));
        
        /* 결과:
            Engine()
            Car2()
            Car [model=티코, maker=비트자동차, cc=890, auto=true, createdDate=null, 
                        engine=Engine [maker=비트자동차, valve=16, cylinder=4]]
        */
        
    }

}





