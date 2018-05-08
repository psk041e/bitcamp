package bitcamp.java106.step07;

import java.sql.Date;

public class Car {
    String model;
    String maker;
    int cc;
    boolean auto;
    Date createdDate;
    Engine engine;
    
    public Car() {
        System.out.println("Car()");
    }
    
    
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
        // 리턴값이 boolean일 때는 get이란 이름을 가질수도 있고 is라는 이름을 가질수도 있다.
        // 둘다 모두 게터로 본다. 관례이다.
        return auto;
    }
    public void setAuto(boolean auto) {
        System.out.println("Car.setAuto()");
        this.auto = auto;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        System.out.println("Car.setCreateDate()");
        this.createdDate = createdDate;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        System.out.println("Car.setModel()");
        this.model = model;
    }
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        System.out.println("Car.setMaker()");
        this.maker = maker;
    }
    public int getCc() {
        return cc;
    }
    public void setCc(int cc) {
        System.out.println("Car.setCc()");
        this.cc = cc;
    }
    
    
}
