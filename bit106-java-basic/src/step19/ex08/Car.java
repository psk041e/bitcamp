package step19.ex08;

public class Car {
    Engine engine;
    
    public Car() {
        System.out.println("===> Car()");
        engine = new Engine();
    }
    public void move() {
        this.engine.run();
    }
}
