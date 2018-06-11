// AOP(Aspect-Oriented Programming) - AOP 필터 적용 전
package bitcamp.java106.step13.ex01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01 { 
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java106/step13/ex01/application-context-01.xml");
        
        String[] names = iocContainer.getBeanDefinitionNames(); // 저장할 때 배열로 이름 저장
        for (String name : names) {
            System.out.println(iocContainer.getBean(name).getClass().getName());
        }
        System.out.println("----------------------------------");
        
        Caller caller = (Caller) iocContainer.getBean(Caller.class);
        caller.test();
    }

}
