// String - mutable(바꿀 수 있는) vs immutable(바꿀 수 없는) 객체 -> 다른 언어에서도 사용한다.
// 메모리가 한번 고정되면 바꿀수 없어야 프로그램 실행이 빠르다. 그래서 기본적으로 immutable객체인 경우가 좋다.
package step10;

public class Exam01_3 {
    public static void main(String[] args) {
        // String 객체는 전형적인 immutable 객체이다.
        // 즉, 한 번 객체에 값을 담으면 변경할 수 없다.
        
        String s1 = new String("Hello");
        
        // String 클래스에서 제공하는 어떤 메서드를 호출하든지 간에 
        // 원래의 데이터를 변경하지 않는다.
        // 다만, 새로 String 객체를 만들 뿐이다.
        String s2 = s1.replace('l', 'x');
        System.out.printf("%s : %s\n", s1, s2); // 원본은 바뀌지 않는다.
        
        String s3 = s1.concat(", world!");
        System.out.printf("%s : %s\n", s1, s3); // 원본은 바뀌지 않는다.
        
        // StringBuffer는 mutable 객체이다.
        // 원래의 문자열을 변경하고 싶을 때 사용하는 클래스이다.
        StringBuffer buf = new StringBuffer("Hello");
        //                                   01234
        buf.replace(2, 4, "xx"); // replace사용법이 조금 다르다. 끝번호는 바꾸고싶은 문자 다음의 인덱스를 써준다.
        System.out.println(buf); // 원본을 바꾼다.
        
        // String객체 값을 바꾸게 되면 객체를 계속 생성되서 메모리를 낭비하는 수가 있다
        // 따라서 객체의 값을 바꾸고 싶으면 StringBuffer를 사용해서 바꿔주는것이 좋다.
        
        // StringBuffer 사용시 주의사항!
        // StringBuffer의 내용물을 비교할 때 equals()를 사용해봐야 소용없다.
        // == 연산자와 같은 결과를 출력한다.
        StringBuffer b1 = new StringBuffer("Hello");
        StringBuffer b2 = new StringBuffer("Hello");
        if (b1.equals(b2)) 
            System.out.println("b1 == b2");
        else
            System.out.println("b1 != b2");
        
        // 해결책?
        // => StringBuffer에서 String을 꺼내 비교하라!
        if (b1.toString().equals(b2.toString())) 
            System.out.println("b1.toString() == b2.toString()");
        else
            System.out.println("b1.toString() != b2.toString()");
        
    }
}
