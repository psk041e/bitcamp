// 객체 생성 정책 - singleton, prototype (request와 session은 웹이 아니기 때문에 테스트할 수 없다.)
package bitcamp.java106.step02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam03 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step02/application-context-03.xml");
        
        BeanUtils.printBeanList(iocContainer);
        
        // 빈의 아이디로 객체를 꺼내기
        // scope=singleton : 객체를 한 개만 생성해서 공유한다.
        Car obj1 = (Car) iocContainer.getBean("car1");
        Car obj2 = (Car) iocContainer.getBean("car1");
        if (obj1 == obj2) System.out.println("obj1 == obj2");
        // 같은 객체를 리턴한다.
        // 기본적으로 싱글톤일 경우 미리 객체를 만들어놓는다.
        
        Car obj3 = (Car) iocContainer.getBean("car2");
        Car obj4 = (Car) iocContainer.getBean("car2");
        if (obj3 == obj4) System.out.println("obj3 == obj4");
        
        // prototype 객체는 getBean()을 호출할 때 마다 생성된다.
        Car obj5 = (Car) iocContainer.getBean("car3");
        Car obj6 = (Car) iocContainer.getBean("car3");
        if (obj5 != obj6) System.out.println(obj5 != obj6);
        
        // 로그인이 끝날때까지 유지된다?
        // 객체를 한개 만들어놓고 그 객체를 계속 쓰는 것이 IoC타입의 목표이다.
        // 따라서 singleton으로 쓰는것이 기본인 것이다.
        // prototype은 특별한 일이 아니면 설정할 일이 없다.
        // 직접 new를 사용하는 것보다는 편하기 때문에 prototype을 사용한다.
        
    }

}





