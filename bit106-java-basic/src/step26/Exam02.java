package step26;

import step19.ex01.ApplicationContext;

public class Exam02 {
    
    public static void main(String[] args) {
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(
                "bitcamp/java106/step02/application-context-02.xml");
        
        BeanUtils.printBeanList(iocContainer);
        
        // 빈의 아이디로 객체를 꺼내기
        Car c1 = (Car) iocContainer.getBean("c1");
        Car c2 = (Car) iocContainer.getBean("c2");
        
        // 빈의 별명이 지정된 경우 별명으로도 객체를 꺼낼 수 있다.
        Car c3 = (Car) iocContainer.getBean("c3");
        if (c2 == c3) System.out.println("c2 == c3");
        
        System.out.println("----------------");
        
        
    }
}
