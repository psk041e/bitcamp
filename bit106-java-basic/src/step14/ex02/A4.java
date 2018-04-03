// 인터페이스 정의 - 인터페이스는 규칙이다. 그래서 인스턴스를 만들 수 없다. 
package step14.ex02;

public interface A4 {
    // 인터페이스는 규칙으로 사용되기 때문에 new 명령어로 인스턴스를 생성할 수 없다. 
    // => 인터페이스에 선언되는 모든 변수는 
    //    public 으로 공개되고,
    //    static 으로 클래스 변수가 된다.
    //    규칙은 변경되어서는 안된다. 그래서 
    //    모든 변수는 final로 선언한다.
    //    final 변수는 선언과 동시에 특정 값으로 초기화 해야 한다.
    public static final int v1 = 100;
    
    // 인터페이스의 모든 변수는 public이고, static이고, final이기 때문에
    // 생략해도 된다.
    /*public static final*/ int v2 = 100;
    

}
