// non-static nested class == inner class
package step17.ex03;

public class Exam02 {
    
    int value;
    
    // => 인스턴스 메서드에서는 인스턴스 변수에 접근할 수 있다.
    // => 인스턴스 메서드는 this라는 내장 변수에 "호출될 때 넘겨받은"
    //    "인스턴스 주소"를 보관한다.
    public void setValue(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void test() {
        Inner innerObj = new Inner();
        
        // inner 클래스의 메서드를 호출하면
        // inner 객체의 주소 뿐만 아니라 바깥 객체의 주소까지 전달된다.
        // 즉 m() 메서드를 호출할 때 실제로 두 개의 주소가 넘어 간다.
        // innerObj의 저장된 객체 주소와 
        // test()를 호출할 때 넘겨 받은 Exam02 객체의 주소가 넘어간다.
        innerObj.m();
    }
    
    class Inner { // 인스턴스 멤버
        public void m() {
            // non-static 중첩 클래스도 인스턴스 멤버이다.
            // 따라서 바깥 클래스의 인스턴스 변수에 접근할 수 있다.
            // 단! 바깥 클래스의 인스턴스 주소를 사용하고 싶을 때는 
            // 바깥 클래스명.this 를 사용하라!
            // => 그냥 this 는 중첩 클래스의(Inner) 인스턴스를 의미한다.
            //
            // this <=== m() 메서드를 호출할 때 넘겨 받은 Inner 객체의 주소가 들어 있다.
            // Exam02.this <=== m() 메서드를 호출할 때 넘겨 받은 바깥 클래스의 객체 주소가 들어 있다.
            // 
            // 오직 이너클래스만이 Exam02.this 을 사용할 수 있다. 바깥 클래스의 객체 주소를 접근하고
            // 싶을 때 사용하는 아주 특수한 문법이다.
            System.out.println(Exam02.this.value);
        }
    }
    
    // Inner 클래스도 Exam02의 인스턴스 멤버이기 때문에 
    // Inner 클래스 안에서는 Exam02의 모든 인스턴스 멤버(변수와 메서드)에 접근할 수 있다.
    
    public static void main(String[] args) { // static 메서드에서는 this내장변수를 사용할 수 없다.
        Exam02 obj = new Exam02();
        obj.setValue(100);
        
        obj.test();
    }
}
