package bitcamp.java106.step05;

public class Tire {
    String maker;
    int width; //폭
    int ratio; //편평비
    int wheel; //휠
    
    @Override
    public String toString() {
        return "Tire [maker=" + maker + ", width=" + width + ", ratio=" + ratio + ", wheel=" + wheel + "]";
    }
    
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getRatio() {
        return ratio;
    }
    public void setRatio(int ratio) {
        this.ratio = ratio;
    }
    public int getWheel() {
        return wheel;
    }
    public void setWheel(int wheel) {
        this.wheel = wheel;
    }
    
    
}
