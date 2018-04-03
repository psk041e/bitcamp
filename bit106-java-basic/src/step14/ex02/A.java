//인터페이스 정의 I - 모든 메서드는 public 이다.
package step14.ex02;

public interface A {
    // 문법1:
    // 인터페이스에 정의하는 메서드는 호출 규칙이다.
    // 규칙은 공개되어야 한다.(법과 같이 모두가 알아야 규칙이다.)
    // 그래서 인터페이스에 선언되는 모든 메서드는 public이다.
    public void m1();
    
    // => 무조건 public 이기 때문에 생략해도 public 이다.
    void m2(); // public 이 생략된 것이다. (default) 아니다!
    
    // => private, protected, (default)는 없다!
    // private void m3(); // 컴파일 오류!
    // protected void m4(); // 컴파일 오류!
    void m5(); // 이건 (default)가 아니라, public이 생략된 것이다!
}
