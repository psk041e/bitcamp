// 예외 처리 후 마무리 작업 - finally 블럭
package step21.ex03;

import java.io.IOException;
import java.sql.SQLException;

public class Exam05_1 {

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
    
    public static void main(String[] args) {
        try {
            m(2); // 여기서 예외가 발생하는 순간 실행하지 않고 예외로 넘어간다.
            System.out.println("try");
        } catch (RuntimeException | SQLException | IOException e) {
            System.out.println("catch 1");
        } catch (Exception e) {
            System.out.println("catch 2");
        } finally {
            // 정상적으로 실행하든, 아니면 예외가 발생하여 catch 블록을 실행하든
            // finally 블록은 무조건 실행한다.
            // 즉 try ~ catch 블록을 나가기 전에 반드시 실행한다.
            System.out.println("finally");
        }
    }

}
