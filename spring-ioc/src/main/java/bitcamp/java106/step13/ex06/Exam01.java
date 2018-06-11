// AOP(Aspect-Oriented Programming) - AOP 필터 적용 위치
package bitcamp.java106.step13.ex06;

import org.springframework.context.support.ClassPathXmlApplicationContext;

// AOP?
// => 기존의 코드를 손대지 않고 특정 기능을 삽입하는 기술
// => 메서드 호출 앞뒤로 코드를 삽입할 수 있다.
// => 일종의 필터를 추가하는 기술이다.
//
// AOP 적용 방법
// => AOP 관련 의존 라이브러리 가져온다.
//    - mvnrepository.com 에서 "aspectjweaver-04"로 검색한다.
//    - build.gradle 에 등록
//    - "gradle eclipse" 실행
//    - 프로젝트 리프래시.
// => 필터 클래스를 정의한다.
// => XML 또는 자바 코드로 필터를 설정한다.
//
// AOP 용어:
// => Advice        : 메서드(join point) 호출 앞뒤에 삽입될 코드이다. 필터 객체이다.
//                  : 예) MyAdvice
// => Join Point    : Advice가 들어갈 메서드
// //               : 예) m() 메서드
// => Pintcut       : Advice를 삽입할 위치 정보이다.
//                  : 예) execution(* bitcamp.java106.step13.ex02.*.*(..))
// => Target Object : Advice를 삽입할 대상 객체이다.
//                  : 예) X, Y, C 클래스
// => Aspect        : 어느 pointcut에 어떤 advice를 삽입할 것인지 가리키는 정보이다.
//                  : 예) 설정 정보
//
public class Exam01 { 
    
    public static void main(String[] args) {
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext(
                        "bitcamp/java106/step13/ex05/application-context-01.xml");
        
        String[] names = iocContainer.getBeanDefinitionNames(); // 저장할 때 배열로 이름 저장
        System.out.println("---------------------------------------");
        for (String name : names) {
            System.out.println(iocContainer.getBean(name).getClass().getName());
        }
        System.out.println("----------------------------------");
        
        try {
            Caller caller = (Caller) iocContainer.getBean(Caller.class);
            caller.test();
        } catch (Exception e) {
            System.err.println("오류 발생!");
        }
    }

}
