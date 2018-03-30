// 제네릭(Generic) - 사용 전
package step13.ex01;

import java.util.HashSet;

import step12.ex01.ArrayList;

public class Exam01_1 {
    public static void main(String[] args) {
        // ArrayList에 어떤 종류(타입, 클래스)의 객체를 저장할지 지정하지 않으면
        // 기본으로 Object 타입의 객체를 다루는 것으로 간주한다.
        // 즉 Object 타입이라면 어떤 클래스든지 저장하고 꺼낼 수 있다.
        ArrayList list = new ArrayList();
        list.add(new Member("홍길동", 20));
        list.add(new String("Hello"));
        list.add(new Integer(100));
        list.add(new HashSet());
    }
}
