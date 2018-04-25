// 스레드 그룹에 소속된 하위 그룹들 
package step24.ex02;

public class Exam04 {

    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        ThreadGroup mainGroup = main.getThreadGroup();

        // 스레드 그룹에 소속된 하위 그룹을 알고 싶다면?
        ThreadGroup[] groups = new ThreadGroup[100];
        int count = mainGroup.enumerate(groups, false);
        // 두 번째 파라미터 값을 false로 지정하면,
        // 하위 그룹에 소속된 그룹들은 제외한다.
        // 즉, 현재 그룹에 소속된 하위 목록만 가져오라는 의미!
        
        System.out.println("main 그룹에 소속된 하위 그룹들:");
        for (int i = 0; i < count; i++) {
        System.out.println("    => " +  groups[i].getName());
        }
        
        // "main" 스레드 그룹:
        //      => main 스레드
        //      => 다른 하위 그룹은 없다.

        

    }

}
