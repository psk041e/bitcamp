// 익명 객체
package bitcamp.java106.step02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam04 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step02/application-context-04.xml");
        
        BeanUtils.printBeanList(iocContainer);
        // 빈의 이름을 지정하지 않을 경우 클래스 명을 이름으로 사용한다.
        // =>bitcamp.java106.step02.Car#0 = bitcamp.java106.step02.Car
        // 이름이 없이 객체를 만들라고 하면 그 클래스 이름과 #뒤에 익명객체 수만큼 0부터 번호가 붙는다.
        
        BeanUtils.printBeanAliases(iocContainer, "bitcamp.java106.step02.Car#0");
        BeanUtils.printBeanAliases(iocContainer, "bitcamp.java106.step02.Car#1");
        BeanUtils.printBeanAliases(iocContainer, "bitcamp.java106.step02.Car#2");
        BeanUtils.printBeanAliases(iocContainer, "bitcamp.java106.step02.Car#3");
        
        BeanUtils.printBeanAliases(iocContainer, "bitcamp.java106.step02.Engine#0");
        BeanUtils.printBeanAliases(iocContainer, "bitcamp.java106.step02.Engine#1");
        BeanUtils.printBeanAliases(iocContainer, "bitcamp.java106.step02.Engine#2");
        
        // 0번째 익명객체 별명은 클래스 이름과 같다.
        // 나머지 익명객체들의 별명은 없다.
        // 객체에 이름을 부여하지 않았다는 것은 이름으로 찾을일이 없다는 의미이다.
        // => 그러면 뭐로 찾는다? 타입으로 찾는다!
        
    }

}





