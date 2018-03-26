// 오버라이딩(overriding) - 응용 예: equals()
package step11.ex11;

public class Exam09_1 {
    
//    int i;
// 클래스 입장에서는 인스턴스 멤버이기 때문에 메인메소드에서 접근할 수 없다.
    /*
    class Score {
        
    }
    */
    static class Member /*extends Object*/ { 
        String name;
        int age;
        
        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    
    public static void main(String[] args) {
        // Object 클래스?
        //this.i = 100; // 스태틱 블록이기 때문에 this라는 내장변수가 존재하지 않는다.
                        // 스태틱 블록이기 때문에 인스턴스 변수 i에 접근할 수 없다. 
        
        // 스태틱 환경 안에서는 스태틱 멤버는 접근할 수 있지만,
        // 인스턴스 변수에 직접 접근할 수 없다.
        // 접근하려면 파라미터로 받거나 인스턴스를 생성시킨 다음에
        // 그 인스턴스 변수나 메서드를 호출할 수 있다.
        
        //Exam09 a = new Exam09(); // 인스턴스를 만든다.
        //Score obj;
        //obj = a.new Score(); // Score를 그냥 new 할 수 없다. 
                             // 항상 인스턴스 주소.new 클래스() 해주어야 한다.
        // 따라서 스태틱멤버는 인스턴스 주소 없이 사용할 수 있기 때문에
        // 클래스명에도 항상 static을 붙여준 것이다.
        
        Member m1 = new Member("홍길동", 20);
        Member m2 = new Member("홍길동", 20);
         // m1, m2의 주소가 다르다.
        
        if (m1 == m2) {
            System.out.println("m1 == m2");
        } else {
            System.out.println("m1 != m2");
        }
        
        System.out.println(m1.equals(m2));
        // 어? Member 클래스에 equals()를 정의한 적이 없는데 컴파일 오류가 발생하지 않네?
        // => 클래스를 만들 때 수퍼 클래스를 지정하지 않으면,
        //    자동으로 Object를 상속받게 된다.
        //    따라서 자바의 모든 클래스는 Object의 자손이다.
        // => 그래서 자바의 모든 클래스는 Object의 메서드를 사용할 수 있다. - toString(), equals(), hashcode()
        //    equals()는 Object로부터 상속받은 메서드 중하나이다.
        //
        // equals()는 String 클래스에서 문자열 비교에 사용했던 메서드이다.
        // 두 문자열의 인스턴스가 달라도 내용이 같으면 true를 리턴했다.
        // 그런데 위의 실행 결과를 보면 m1과 m2가 비록 인스턴스는 다르지만 
        // 내용이 같기 때문에 true를 리턴할 것이라 예상했는데
        // 실제 리턴값을 확인해보면 false를 리턴한다.
        // 이유?
        // => Object 클래스에서 상속 받아 쓰는 equals()는 원래 내용물을 비교하는게 아니라
        //    인스턴스가 같은지를 비교하는 메서드이다.
        // => m1, m2 인스턴스가 다르니 당연히 그 결과가 false인 것이다.
        //
        // Member의 내용이 같은지 비교하고 싶은가?
        // => 이럴 때 바로 "오버라이딩"을 사용하는 것이다.
        // => 즉 Object로부터 상속 받은 메서드가 Member 클래스에 맞지 않다.
        //    그럼 Member 클래스에 맞게금 재정의하면 되는 것이다.
        // 다음 Exam09_2를 보라!
        
    }
}
