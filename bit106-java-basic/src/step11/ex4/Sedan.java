// 기존의 클래스를 손대지 않고 새 기능만 추가한다.
// 어떻게? 상속문법을 이용한다.
package step11.ex4;

// 상속!
// => 재사용할 기존 클래스를 지정한다.
// => 새 클래스에는 추가할 기능을 덧붙인다.(확장한다)
public class Sedan extends step11.ex1.Car { // 기존 코드임을 강조하기 위해 일부러 import하지 않고 직접 명시해줌
    // 인스턴스 변수 추가
    boolean sunroof;
    boolean auto;
    
    public Sedan(String model, String maker, int capacity,
            boolean sunroof, boolean auto) {
        this.model = model; // 에러 -> 변수가 없는것이 아니라 접근이 안된다. -> Car클래스 변수를 public해준다.
        this.maker = maker;
        this.capacity = capacity;
        this.sunroof = sunroof;
        this.auto = auto;
    }
}

