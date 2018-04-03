// 인터페이스의 모든 메서드는 public 이기 때문에 
// public 보다 적게 공개할순 없다.
// ★★ 메서드의 공개 범위를 public 보다 좁게할 순 없다.★★
package step14.ex02;

public class Exam02 implements A3 {
    // public 보다 좁게 공개 범위를 줄일 수 없다.
    // private void m1() {} // 컴파일 오류!
    // protected void m1() {} // 컴파일 오류!
    // void m1() {} // 컴파일 오류! 
    //Cannot reduce the visibility of the inherited method from A3 -> 상속 받은 메서드의 공개범위를 줄일 수 없다.
    
    
    // 반드시 public 이어야 한다.
    public void m1() {}
    public void m2() {}
}
