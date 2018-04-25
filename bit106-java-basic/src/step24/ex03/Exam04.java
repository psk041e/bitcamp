// Runnable 인터페이스 구현 + Thread - 익명 클래스로 구현하기
package step24.ex03;

public class Exam04 {
    
    public static void main(String[] args) {
        // 스레드에서 실행할 코드를 별도의 클래스로 분리하기
        // => java.lang.Runnable 인터페이스 구현
        class MyRunnable implements Runnable { // 스레드가 실행할 코드를 가지고 있다.
            @Override
            public void run() {
                // 별도로 분리해서 병행으로 (동시에, but 실제로 동시는 아님) 실행할 코드를 두는 곳!
                for (int i = 0; i < 1000; i++) {
                    System.out.println("===> "+ i);
                }
            }
        }
        
        // 스레드 실행하기
        // => Runnalbe 구현체를 Thread에 실어서 실행한다.
        // => start()를 호출하여 기존 스레드에서 분리하여 스레드를 실행시킨다.
        Thread t = new Thread(new MyRunnable());
        t.start(); // 실행 흐름을 분리한 후 즉시 리턴한다.
        
        // "main" 스레드는 Thread와 상관없이 병행하여 실행한다.
        for (int i = 0; i < 1000; i++) {
            System.out.println(">>>> " + i);
        }
        
    }

}
