package bitcamp.java106.step08;

import java.sql.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

// 의존 객체 Engine 주입 - 인스턴스 변수에 @Autowired를 붙여도 된다!
@Component
public class Car7 {
    String model;
    String maker;
    int cc;
    boolean auto;
    Date createdDate;

    // 이 애노테이션은 스프링 프레임워크가 아닌 자바에서 제공한다.
    // 스프링 프레임워크에서는 자바에서 제공하는 이 resource도 처리한다.
    @Resource(name="e1") // e1이라는 객체를 engine에 주입하라
    Engine engine;

    @Override
    public String toString() {
        return "Car [model=" + model + ", maker=" + maker + ", cc=" + cc + ", auto=" + auto + ", createdDate="
                + createdDate + ", engine=" + engine + "]";
    }
    
    public Engine getEngine() {
        return engine;
    }
    
    public void setEngine(Engine engine) {
        System.out.println("Car.setEngine()");
        this.engine = engine;
    }
    
    public boolean isAuto() { 
        return auto;
    }
    public void setAuto(boolean auto) {
        this.auto = auto;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public int getCc() {
        return cc;
    }
    public void setCc(int cc) {
        this.cc = cc;
    }
    
    
}
