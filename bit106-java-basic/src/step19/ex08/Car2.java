// 의존 객체 Engine을 
package step19.ex08;

public class Car2 {
    Engine engine;
    
    public Car2(Engine engine) {
        System.out.println("===> Car2(Engine)");
        this.engine = engine;
    }
    public void move() {
        this.engine.run();
    }
}
