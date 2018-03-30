// 제네릭(Generic) - 문법 정리
package step13.ex01;

import java.util.HashSet;

import step12.ex01.ArrayList;

public class Exam01_3 {
    public static void main(String[] args) {
        // 문법
        // => 클래스명 옆에 다루고자 하는 타입의 이름을 지정한다.
        // 
        ArrayList list = new ArrayList();
        list.add(new Member("홍길동", 20));
        list.add(new String("Hello"));
        list.add(new Integer(100));
        list.add(new HashSet());
        
        // 값 꺼내기
        // 객체의 값을 꺼내려면 보통 해당 클래스로 형변환 한 다음에 사용한다.
        // 왜? get()메서드의 리턴 타입이 Object이기 때문이다.
        Member member = (Member) list.get(0);
        System.out.println(member.name);
        System.out.println(member.age);
        // => 이렇게 값을 꺼낼 때 마다 그 객체의 원래 클래스로 형변환 해야 하는 것은 매우 번거롭다.
        
    }
}
