// 오버라이딩(overriding) - 응용 예: equals()
package step11.ex11;

public class Exam09_2 {
    
    static class Member /*extends Object*/ { 
        String name;
        int age;
        
        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        // Object로부터 상속 받은 equals() 메서드를
        // Member 클래스의 역할에 맞게 재정의해보자!
        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Member)) // 멤버클래스의 인스턴스인지 확인한다.
                return false;
            Member other = (Member) obj;
            
            if (!(this.name.equals(other.name)))
                return false;
           
            if (this.age != other.age)
                return false;
            
            return true;
        }
    
    public static void main(String[] args) {
        Member m1 = new Member("홍길동", 20);
        Member m2 = new Member("홍길동", 20);
         // m1, m2의 주소가 다르다.
        
        if (m1 == m2) {
            System.out.println("m1 == m2");
        } else {
            System.out.println("m1 != m2");
        }
        
        System.out.println(m1.equals(m2));
        
    }
}
}  
// 결론!
// => Object로부터 상속 받은 기본 메서드인 equals()는
//    같은 인스턴스인지를 비교하는 메서드이다.
// => 인스턴스에 데이터가 같은지를 비교하고 싶다면 이 메서드를 재정의(오버라이딩) 해야 한다.
// => 오버라이딩의 예:
//    String