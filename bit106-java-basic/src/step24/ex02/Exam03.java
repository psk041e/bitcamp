// 스레드 그룹에 소속된 스레드들 
package step24.ex02;

public class Exam03 {

    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        ThreadGroup mainGroup = main.getThreadGroup();

        // 스레드 그룹에 소속된 스레드 목록을 알고 싶다면?
        Thread[] arr = new Thread[100];
        int count = mainGroup.enumerate(arr, false);
        // 두 번째 파라미터 값을 false로 지정하면,
        // 하위 그룹에 소속된 스레드들은 제외한다.
        // 즉, 현재 그룹에 소속된 스레드 목록만 가져오라는 의미!
        
        System.out.println("main 그룹에 소속된 스레드들:");
        for (int i = 0; i < count; i++) {
            System.out.println("    => " + arr[i].getName());
        }


        // "main" 스레드 그룹:
        //      => "main" 스레드

        

    }

}
