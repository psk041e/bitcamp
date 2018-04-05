// Reflection API : 클래스 로딩
package step18.ex01;

class A {
    static int i;
    static void m() {i = 100;}
    static {
        System.out.println("A 클래스 로딩!");
    }
}

public class Exam01 {

    public static void main(String[] args) throws Exception {
        // 클래스 로딩(클래스 파일을 읽어서 그 클래스에 대한 정보들을 메모리 위에 올려 놓겠다)
        // => 클래스가 로딩되어 있지 않다는 조건(한번로딩되면 또 될 필요가 없다.)
        // 1) 클래스의 스태틱 멤버(변수, 메서드, 중첩클래스)를 사용할 때
        // 2) new 명령을 사용해서 인스턴스를 생성하려 할 때
        // 3) Class.forName()을 이용하여 임의로 클래스를 로딩할 때
        //
        // 클래스 로딩 과정에서 하는 일
        // => 스태틱 변수를 준비한다.
        // => 스태틱 블록을 실행한다.
        
        // A.i = 100; // 클래스 로딩 확인!
        // A.m(); // 클래스가 먼저 메모리에 로딩 되어야 해당되는 메서드를 찾아 실행한다. 클래스 로딩 확인!
        // new A(); // 인스턴스를 생성할 때. 클래스 로딩 확인!
        Class.forName("step18.ex01.A"); // 클래스 로딩 확인!
        // 파라미터로 패키지명을 포함한 전체 클래스 이름을 지정해야 한다.
        // 패키지명을 포함한 전체 클래스 이름
        // = ★★fully qualified class name★★
        // = ★★FQName★★
        // = ★★QName★★
        
        A obj = null; // 레퍼런스 선언은 클래스 로딩과 상관 없다.
        A[] arr; // 배열 레퍼런스 언언도 클래스 로딩과 상관 없다.
        arr = new A[100]; // 레퍼런스 배열도 마찬가지로 클래스 로딩과 상관 없다.
                            // 인스턴스를 만드는 것이 아니므로 클래스 로딩이 되지 않는다.
                            
        
        
    }

}
