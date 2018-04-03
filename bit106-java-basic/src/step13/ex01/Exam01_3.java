// 제네릭(Generic) - 문법 정리
package step13.ex01;

import java.util.ArrayList;

public class Exam01_3 {
    public static void main(String[] args) {
        // 문법
        // => 클래스명 옆에 다루고자 하는 타입의 이름을 지정한다.
        //    클래스명<타입명>
        ArrayList<Member> list = new ArrayList<Member>();
        
        // => 레퍼런스 선언에 제네릭 정보가 있다면 new 연산자에서는 생략할 수 있다.
        ArrayList<Member> list2 = new ArrayList<>();
        
        ArrayList<Member> list3;
        list3 = new ArrayList<>(); // OK!
        
        // 제네릭 문법으로 레퍼런스 변수를 선언할 때는 타입명을 생략할 수 없다.
        // ArrayList<생략불가!> list4; // 컴파일 오류!

    }
}
