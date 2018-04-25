// 스레드 만들기 I - Runnable 인터페이스 구현 + Thread
package step24.ex03;

public class Exam02 {
    
    public static void main(String[] args) {

        new Thread(new Runnable() { // 스레드가 실행할 코드를 가지고 있다.
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("===> "+ i);
                }
            }
        }).start();
        
        // "main" 스레드는 Thread와 상관없이 병행하여 실행한다.
        for (int i = 0; i < 1000; i++) {
            System.out.println(">>>> " + i);
        }
        
    }

}
