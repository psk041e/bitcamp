// Thread를 상속 받기 - 익명 클래스로 구현하기
package step24.ex03;

public class Exam03 {
    
    public static void main(String[] args) {
        new Thread() { // 이름이 없는 클래스는 정의하자 마자 바로 객체를 만든다.
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("===> "+ i);
                }
            }
        }.start();
        
        for (int i = 0; i < 1000; i++) {
            System.out.println(">>>> " + i);
        }
        
    }

}
