// Singleton 패턴 적용 후
package step09.singleton;

public class Car2 {
    // Car2 객체를 생성하면 다음 스태틱 변수에 보관해둔다.
    private static Car2 instance; 
    
    // 외부에서 생서자를 호출하지 못하도록 private으로 접근을 제한한다.
    // but 내부에서는 언제든지 호출가능!
    private Car2() {
        System.out.println("Car2()");
    }
    
    // 객체를 한개만 만들도록 강제화시킴
    public static Car2 getInstance() { // 클래스 메서드는 클래스 이름으로 호출한다.
        if (instance == null) // 두번째부터 인스턴스 주소가 null값이 아니면 주소를 초기화시키지 않는다.
            return new Car2(); // Car2인스턴스 주소를 호출하는 스태틱 메서드
        return instance;
    } // 인스턴스를 만든 후에 생성자를 호출해서 초기화시킬 수 있다.
      // 만약 인스턴스에 주소가 없다면 그 때는 인스턴스 라는 변수에 Car2객체를 만들어 보관한 후 인스턴스를 리턴한다.
    
}
