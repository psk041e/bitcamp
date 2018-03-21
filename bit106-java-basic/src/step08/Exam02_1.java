// 인스턴스 메서드와 클래스 메서드
package step08;

public class Exam02_1 {
    static class A {
        // 1) 클래스 메서드 
        //    => static 이 붙은 메서드
        //    => 클래스 이름으로 호출할 수 있다.
        //    => "스태틱 메서드"라고도 부른다.
        static void m1() {
            System.out.println("m1()");
        }
  
        // 2) 인스턴스 메서드
        //    => static 이 붙지 않은 메서드
        //    => 인스턴스 주소가 있어야만 호출할 수 있다.
        void m2() {
            System.out.println("m2()");
            // 인스턴스 주소를 줬는데(this에) 사용하지 않는 변수는 인스턴스 주 소를 줄 필요가 없다 -> 그 메소드는static메서드로 만들엊버려야한다.
            // 인스턴스 주소는 메모리를 할당하는데 그것을 사용하지 않고 아무것도 하지않으면 static으로 선언해야 한다.
        }
    }
    public static void main(String[] args) {
        // 클래스 메서드 호출
        // 문법) 클래스명.메서드명();
        A.m1(); // OK!
        // A.을 했을 때 미리보기창의 아이콘에 s가 붙은것은 static이다. 사용할수 있는것을 말한다.
        
        // => 인스턴스 메서드는 클래스 이름으로 호출할 수 없다.
        // A.m2(); // 컴파일 오류!
        
        A obj1 = new A();
        
        obj1.m1(); // OK! 그런데, 이렇게 하지 말라!
                   // 물론 "클래스 메서드"를 인스턴스 주소를 사용하여 호출할 수 있지만,
                   // *****다른 개발자가 그냥 "인스턴스 메서드"인줄 착각할 수 있기 때문에*****
                   // *****이렇게 호출하지 말기를 권고한다!!*****
        
        obj1.m2(); // OK! 인스턴스 메서드는 반드시 인스턴스 주소를 사용하여 호출해야 한다.!
        
        A obj2 = null;
        obj2.m2(); // 컴파일은 OK! 실행은 오류!
                   // 왜? obj2 변수에 들어 있는 인스턴스 주소가 무효하기 때문이다.
                   // 인스턴스 주소가 존재하지 않는다. -> 유효하지 않은 주소를 넘겨주면 실행할때 에러가 난다.
        
       
    }
}



