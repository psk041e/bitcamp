// 프로퍼티 에디터 - String ==> Engine객체 ; 변환기 사용하여 처리하기
package bitcamp.java106.step07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java106.BeanUtils;

public class Exam04 {

    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step07/application-context-04.xml");
        
        System.out.println(iocContainer.getBean("c1"));
        
        // engine 객체 추가 전↓
        /* 결과: Failed to convert property value of type => 에러가난다.
            Car()
            CustomDateEditor.setValue()
            CustomDateEditor.setAsText()
            CustomDateEditor.setValue()
            CustomDateEditor.getValue()
        */
        
        // engine 객체 추가후 → 제대로된 결과가 나온다.
        
        System.out.println("-----------------------");
        
        BeanUtils.printBeanNames(iocContainer); // 현재 bean컨테이너가 어떤 값의 어떤 객체를 갖고 있는지 호출
    }

}





