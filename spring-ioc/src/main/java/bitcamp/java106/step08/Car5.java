package bitcamp.java106.step08;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

// 의존 객체 Engine 주입 - 인스턴스 변수에 @Autowired를 붙여도 된다!
public class Car5 {
    String model;
    String maker;
    int cc;
    boolean auto;
    Date createdDate;

    //@Autowired의 required 값은 기본이 true이다.
    // => 즉 의존객체 주입이 필수사항이다.
    // => 선택사항으로 바꾸고 싶으면 false로 설정하라!
    // @Autowired의 옵션(?)은 required한개이다.
    // 필수입력항목이어서 엔진객체를 넣지 않으면 에러가 나게된다.
    // 그러나 required를 false로 넣어주면 엔진객체를 넣지 않아도 에러가 나지 않는다.
    @Autowired(required=false) 
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
