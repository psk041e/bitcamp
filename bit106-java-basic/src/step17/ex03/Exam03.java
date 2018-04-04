// non-static nested class == inner class 객체 생성
package step17.ex03;

public class Exam03 {
    
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
        // 같은 인스턴스 메서드 안에서는 인스턴스 중첩 클래스(non-static 중첩 클래스,
        // inner class) 를 마음대로 사용할 수 있다.
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
            System.out.println(Exam03.this.value);
        }
    }
    
    // Inner 클래스도 Exam02의 인스턴스 멤버이기 때문에 
    // Inner 클래스 안에서는 Exam02의 모든 인스턴스 멤버(변수와 메서드)에 접근할 수 있다.
    
    public static void main(String[] args) { // static 메서드에서는 this내장변수를 사용할 수 없다.
        // 문제는 같은 클래스라도 스태틱 메서드에서 inner 클래스를 사용하려 하거나,
        // 또는 다른 클래스에서 inner 클래스를 사용하려 할 때 문제가 발생한다. 
        
        // Inner innerObj = new Inner(); // 컴파일 오류!
        // 왜 Inner 클래스를 사용할 수 없는가?
        // => 다음 메서드를 왜 사용할 수 없는가를 따져봐라!
        
        // setValue(100); // 컴파일 오류!
        // => setValue()는 Exam03의 인스턴스 주소가 있어야 하기 때문이다.
        // 그렇다, Inner 클래스도 Exam03의 인스턴스 멤버이기 때문에
        // Exam03의 인스턴스 주소가 있어야 사용할 수 있다.
        // 원리는 똑같다!
        
        // 인스턴스 멤버(변수, 메서드, 중첩클래스) 사용법
        // 1) 먼저 인스턴스를 생성하라!
        Exam03 obj = new Exam03();
        
        // 2) 인스턴스 주소를 가지고 메서드르 호출하라!
        obj.setValue(200);
        
        // 3) 마찬가지로 중첩 클래스의 인스턴스를 만들 때도 Exam03의 인스턴스 주소가 필요하다.
        Inner obj2 = obj.new Inner();
        
        // 잠깐!
        // 왜 참조변수를 선언할 때는 인스턴스 변수를 사용하지 않나요?
        // => 참조 변수를 선언하는 경우에는 인스턴스 주소가 당장 필요없기 때문이다.
        // => 중첩 클래스의 객체를 만들 때는 바깥 클래스의 객체 주소를 넘겨줘야 하기 때문에
        //    인스턴스 생성할 때는 바깥 클래스의 객체 주소가 있어야 한다.
        
        
    }
}
