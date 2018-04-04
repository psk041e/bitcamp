// non-static nested class == inner class
package step17.ex03;

public class Exam01 {
    
    int value;
    
    // => 인스턴스 메서드에서는 인스턴스 변수에 접근할 수 있다.
    // => 인스턴스 메서드는 this라는 내장 변수에 "호출될 때 넘겨받은"
    //    "인스턴스 주소"를 보관한다.
    //
    public void setValue(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public static void main(String[] args) { // static 메서드에서는 this내장변수를 사용할 수 없다.
        Exam01 obj = new Exam01();
        obj.setValue(100);
        // 이 메서드를 자바 버추얼머신이 호출한다.
        // 이 객체를 만드는 것이 아니라 메인이라는 메서드를 호출한다.
        // 를 heap이라는 메모리에 만들기 때문에 전혀 문제가 없다.
        
        System.out.println(obj.getValue());
        // 이왕이면 인스턴스 변수에 직접 접근하지 말고 겟터와 셋터를 통해서 값을 넣고 집어넣자!
    }
}
