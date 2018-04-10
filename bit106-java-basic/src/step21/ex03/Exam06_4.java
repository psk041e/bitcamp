// 예외 처리 후 마무리 작업 - try-with-resources
package step21.ex03;

import java.io.FileReader;
import java.util.Scanner;

public class Exam06_4 {
    
    static class A {}
    
    static class B implements AutoCloseable {
        public void close() throws Exception {
            System.out.println("B 클래스의 자원을 해제하였습니다.");
        }
    }
    
    static void m() throws Exception {
    
        try (
                // A 클래스는 AutoCloseable 구현체가 아니기 때문에 여기에 선언할 수 없다!
                //A obj = new A(); // 컴파일 오류!
                
                B obj2 = new B(); // OK! 반드시 이 안에서 객체를 만들어야 한다. 이 밖에서 하면 에러가 난다.
            ){
            System.out.println("try 블록 실행....");
        }
        // finally 블록에서 B의 close()를 호출하지 않아도,
        // 자동으로 호출될 것이다. 실행하여 확인하라!
    }
    
    public static void main(String[] args) throws Exception {
        m();
    }

}
