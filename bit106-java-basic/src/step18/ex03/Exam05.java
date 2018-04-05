// 메서드 정보 추출 - static 메서드 호출
package step18.ex03;

import java.lang.reflect.Method;

public class Exam05 {
    // 스태틱 메서드
    public static void plus(int a, int b) { 
        System.out.printf("합계: % d\n", a + b);
    }
    
    // 인스턴스 메서드 (인스턴스를 사용하지 않는 메서드는 인스턴스 메서드로 사용하지 않는것이 좋다.)
    public void minus(int a, int b) {
        System.out.printf("빼기: % d\n", a - b);
    }
    
    
    public static void main(String[] args) throws Exception {
        Class clazz = Exam05.class;
        
        // 메서드 호출 방법
        // invoke(객체, 아규먼트, ...);
        //

        // 1) 스태틱 메서드를 찾아 호출하기
        Method m = clazz.getMethod("plus", int.class, int.class);
        
        // => 스태틱 메서드이기 때문에 인스턴스는 지정할 필요가 없다.
        m.invoke(null, 10, 20); 
        // 첫번째 파라미터는 인스턴스 주소 -> static 메서드이기 때문에 주소가 없다.
        // 그 뒤는 넘겨줄 파라미터 값 -> int두개
        
        // 코딩을 짜지 않아도 원하는 메서드를 마음대로 호출할 수 있다.
        
        // 2) 인스턴스 메서드를 찾아 호출하기
        m = clazz.getMethod("minus", int.class, int.class);
        
        // => 인스턴스 메서드를 호출할 때는 반드시 인스턴스 주소를 넘겨야 한다.
        // m.invoke(null, 10, 10); // 실행 오류!
        
        Exam05 obj = new Exam05();
        m.invoke(obj, 10, 20);
        
    }

}
