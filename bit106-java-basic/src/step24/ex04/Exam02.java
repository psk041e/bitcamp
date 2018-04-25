// 스레드의 생명주기(lifecycle) - join
package step24.ex04;

public class Exam02 {
    
    public static void main(String[] args) {
        System.out.println("스레드 실행 전");
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("===> "+ i);
                }
            }
        };
        t.start();
        
        t.join(); // t 스레드가 종료될 때까지 "main" 스레드는 기다린다.
        // 어떤 스레드가 작업완료한 후 쓰고 싶으면
        System.out.println("스레드 실행 후"); 
        // main() 메서드의 호출이 끝나더라도 다른 스레드의 실행이 종료될 때까지 
        // JVM은 종료하지 않는다.
        
        
    }

}
