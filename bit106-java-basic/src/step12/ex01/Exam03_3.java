// indexOf()에서 객체를 찾을 때 equals()로 비교하여 찾는다. 
package step12.ex01;

import java.util.ArrayList;

public class Exam03_3 {
    // equals()를 오버라이딩 하지 않았다.
    static class Member {
        String name;
        int age;
        
        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString() {
            return String.format("[%s,%d]", this.name, this.age);
        }
        
    }
    
    public static void main(String[] args) {
        Member s1 = new Member("홍길동", 20);
        Member s2 = new Member("임꺽정", 30);
        Member s3 = new Member("유관순", 16);
        Member s4 = new Member("임꺽정", 30);
        
        ArrayList list = new ArrayList();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        print(list);
        
        // Member 클래스는 equals()를 오버라이딩 하지 않았다.
        // 따라서 같은 값을 갖더라도 인스턴스가 다르면
        // equals()의 검사 결과도 false가 될 것이다.
        // 그래서 contains로 s4 객체와 같은 객체가 있는지 검사해보면,
        // 같은 객체가 없다고 나온다.
        System.out.println(list.indexOf(s4));  // -1
        
        // ArrayList를 사용하려면 내가 만드는 클래스에 equals()를 반드시 오버라이딩 해주어야 한다.
        
    }
    
    static void print(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();
    }
}
