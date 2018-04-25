// 스레드의 생명주기(lifecycle) - running 상태
package step24.ex04;

public class Exam04 {
    
    public static void main(String[] args) throws Exception {
ㅍ
            public MyThread(String name) {
                super(name);
            }
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.printf("%s ==> %d\n", this.getName(), i);
                }
            }
        
        }
        
        MyThread t1 = new MyThread("홍길동===>");
        MyThread t2 = new MyThread("오호라------>");
        MyThread t3 = new MyThread("히히호호##");

        // 스레드를 시작시키는 순간 running 상태로 접어든다.
        // running 상태는 실행하고 있는 상태뿐만 아니라,
        // CPU를 받을 수 있는 상태이기도 하다.
        // => CP는 OS의 관리 저액에 따라 스레드나 프로세스에 배분된다.
        t1.start();
        t2.start();
        t3.start();
        for (int i = 0; i < 1000; i++) {
            System.out.printf("main 스레드:%d\n", i);
        }
        
    }
}
