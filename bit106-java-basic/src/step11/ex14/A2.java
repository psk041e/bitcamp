package step11.ex14;

public class A2 extends A{
    @ Override // 컴파일러에게 오버라이딩을 제대로 했는지 검사하라고 명령한다.
               // 붙이지 않아도 되지만 개발자가 혹시나 실수하는것을 방지해준다.
    public void m() { // 오버라이드 -> 수퍼클래스의 메서드를 똑같이 재정의한다.
        System.out.println("A2의 m() 호출!");
    }
    
    public void x() {
        System.out.println("A2에서 추가한 메서드 x()");
    }
}
