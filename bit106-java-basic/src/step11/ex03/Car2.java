// 기존 코드를 복사하여 새 클래스를 만든 후에 코드를 복사했다.
package step11.ex03;

public class Car2 {
    String model;
    String maker;
    int capacity;
    boolean sunroof;
    boolean auto;
    
    // 생성자 2개
    public Car2() {}
    
    // 기존에 이 생성자를 쓰는 코드가 있기 때문에 지울 수 없다.
    // 이전 프로그램(ex1.Exam01)에서 다음 생성자를 사용하기 때문에
    // 이 생성자의 파라미터를 덧 붙일 수는 없다.
    public Car2(String model, String maker, int capacity) {
        this.model = model;
        this.maker = maker;
        this.capacity = capacity;
    }
    
    // 그래서 새로 생성자를 추가해야 한다.
    public Car2(String model, String maker, int capacity,
            boolean sunroof, boolean auto) {
        // 이 클래스의 다른 생성자를 먼저 호출할 수 있다.
        // => 이 때 this()를 사용한다.
        this(model, maker, capacity); // 중복되는 코드를 처리
        
        this.sunroof = sunroof;
        this.auto = auto;
    }

}
