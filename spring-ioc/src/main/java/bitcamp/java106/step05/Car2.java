package bitcamp.java106.step05;

import java.util.List;

public class Car2 {
    String model;
    String maker;
    int cc;
    Engine engine;
    List<Tire> list;
    
    @Override
    public String toString() {
        return "Car2 [model=" + model + ", maker=" + maker + ", cc=" + cc + ", engine=" + engine + ", list=" + list
                + "]";
    }
    public List<Tire> getList() {
        return list;
    }
    public void setList(List<Tire> list) {
        this.list = list;
    }
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
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
