package bitcamp.java106.step03;

public class Car {
    String model;
    String maker;
    int cc;
    
    public Car() {
        System.out.println("Car() 생성자 호출됨!");
    }
    
    public Car(String model) { // 모델명을 받음
        System.out.println("Car(String) 생성자 호출됨!");
        this.model = model;
    }
    
    public Car(int cc) { // cc를 받음
        System.out.println("Car(int) 생성자 호출됨!");
        this.cc = cc;
    }
    
    // 이런식으로 생성자를 만들지 말아라! 아무 의미가 없는 생성자이다!
    public Car(String model, int cc) { 
        System.out.println("Car(String,int) 생성자 호출됨!");
        this.model = model;
        this.cc = cc;
    }
    
    public Car(int cc, String model) { 
        System.out.println("Car(int,String) 생성자 호출됨!");
        this.cc = cc;
        this.model = model;
    }
    
    @Override
    public String toString() {
        return "Car [model=" + model + ", maker=" + maker + ", cc=" + cc + "]";
    }
    
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        System.out.println("setModel() 호출됨!");
        this.model = model;
    }
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        System.out.println("setMaker() 호출됨!");
        this.maker = maker;
    }
    public int getCc() {
        return cc;
    }
    public void setCc(int cc) {
        System.out.println("setCc() 호출됨!");
        this.cc = cc;
    }
    
    
}
