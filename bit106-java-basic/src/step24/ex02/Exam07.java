// "system" 스레드 그룹의 자식 그룹들 
package step24.ex02;

public class Exam07 {

    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        ThreadGroup mainGroup = main.getThreadGroup();
        ThreadGroup systemGroup = mainGroup.getParent();
        
        Thread[] arr = new Thread[100]; 
        int count = systemGroup.enumerate(arr, false);

        System.out.println("system 스레드 그룹의 자식 그룹들:");
        for (int i = 0; i < count; i++) {
            System.out.println("    => " + arr[i].getName());
        }

        // [JVM 프로세스(실행중인 프로그램)]
        // "system" 스레드 그룹:
        //     => 다른 하위 그룹은 없다!
        //     => "main" 스레드 그룹:
        //          => main 스레드 : main() 메서드 호출
        //          => 다른 하위 그룹은 없다!
        //     => "Reference Handler" 스레드 : 인스턴스의 참조 관리
        //     => "Finalizer" 스레드 : 가비지 관리
        //     => "Signal Dispatcher" 스레드 : 외부 신호 관리

        

    }

}
