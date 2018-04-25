// 멀티 스레드 적용 후
package step24.ex01;

public class Exam02 { // 두개의 코드를 왔다갔다 하며 실행시킨다.
    // 동시에 실행되는 것처럼 보인다.
    
    static class MyThread extends Thread {
        @Override
        public void run() {
            // 기존 실행 흐름과 분리하여 따로 실행시킬 코드를 이 메서드에 둔다.
            for (int i = 0; i < 1000; i++) {
                System.out.println("==> " + i);
            }
        }
    }
    public static void main(String[] args) {
        // 코드 실행 라인을 새로 만들어 따로 실행한다.
        new MyThread().start(); 
        // 객체를 생성한 후 바로 시작
        // 자바 버추얼 머신이 이 Thread의 run메서드를 부른다.
        
        for (int i = 0; i < 1000; i++) {
            System.out.println(">>> " + i);
        }
    }
}

// main() 메서드를 실행하는 기본 실행 흐름에서 새로운 실행 흐름으로 분기하고 싶다면, 
// Thread 클래스에 분기해서 실행할 코드를 담으면 된다.
// 그러면 두 개의 실행 흐름이 서로 왔다 갔다 하면서 실행된다.


