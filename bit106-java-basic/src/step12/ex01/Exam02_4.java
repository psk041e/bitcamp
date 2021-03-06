// java.util.ArrayList의 contains()의 동작 원리 확인
package step12.ex01;

import java.util.ArrayList;

public class Exam02_4 {
    // equals()를 오버라이딩 한다면?
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

        // Source > Generate hashCode() and equals()
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Member other = (Member) obj;
            if (age != other.age)
                return false;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }
        
        // 보통은 hashCode와 equals를 모두 오버라이딩 해준다.
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
        
        // Member 클래스는 equals()를 오버라이딩 했다.
        // 따라서 인스턴스가 다르더라도 Member의 name과 age 값이 같다면
        // equals()의 검사 결과가 true이기 때문에,
        // contains()는 같은 객체로 판단할 것이다.
        System.out.println(list.contains(s4)); // false
        
        // 기본 데이터형은 toString, equals, hashCode를 오버라이딩 한다.
        // 그러나 직접 만든 Member객체는 equals와 hashCode를 오버라이딩 하지 않았기 때문에
        // contains를 하는 경우 false값이 나오는 것이다.
        //
        // ArrayList를 사용하느느 경우 equals와 hashCode를 모두 비교하기 때문에 클래스에
        // 두가지를 모두 오버라이딩 해 주어야 한다.
        
    }
    
    static void print(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();
    }
}
