package step11.ex07;

public class B extends A {
    int v2;

    B() {
        // 수퍼 클래스의 어떤 생성자를 지정하지 않으면 컴파일러는
        // 다음과 같이 수퍼 클래스의 기본 생성자를 호출하라는 명령을 붙인다.
        // super();
        // 만약 수퍼 클래스의 기본 생성자(파라미터를 안받는 생성자)가 없으면 컴파일 오류가 발생한다!
        
        // 해결 방법?
        // => 수퍼 클래스에 있는 생성자를 호출하라!
        super(100); // 무조건 super 클래스 생성자가 먼저 실행되어야 한다!
        
        System.out.println("B() 생성자!");
    }
}

