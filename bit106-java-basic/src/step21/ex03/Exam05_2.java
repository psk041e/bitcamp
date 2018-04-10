// 예외 처리 후 마무리 작업 - finally 블럭
package step21.ex03;

import java.io.IOException;
import java.sql.SQLException;

public class Exam05_2 {

    // 메서드에서 발생되는 모든 예외를 나열하기
    static void m(int i) 
            throws Exception, RuntimeException, SQLException, IOException {
        if (i < 0)
            return; // 음수일때는 예외를 던지지 않는다.
        
        if (i == 0)
            throw new Exception(); 
        else if (i == 1)
            throw new RuntimeException();
        else if (i == 2)
            throw new SQLException();
        else 
            throw new IOException();
    }
    
    static void test1() throws Exception { // 예외는 호출자에게 위임하였다.
        try {
            m(-1);
        } finally {
            // try 블럭을 나가기 전에 무조건 실행해야 할 작업이 있다면
            // catch 블록이 없어도 finally 블록만 사용할 수 있다.
            System.out.println("정상적인 실행일 때!");
        }
    }
    
    static void test2() throws Exception { // 예외는 호출자에게 위임하였다.
    try {
        m(0);
    } finally {
        System.out.println("Exception 예외가 발생했을 때!");
    }
}
    
    public static void main(String[] args) {
        
        try { test1(); } catch (Exception e) {}
        try { test2(); } catch (Exception e) {}
        
        
    }

}
