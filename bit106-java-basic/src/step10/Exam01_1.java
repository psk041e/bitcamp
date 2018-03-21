// String - "Hello" vs new String("Hello")
package step10;

public class Exam01_1 {
    public static void main(String[] args) {
        // String ?��?��?��?���? ?��?��?��?�� 방법
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        // => ?��?��물의 ?��?��?���?�? �??��?���? ?���? 무조�? ?��?��?��?���? ?��?��?��?��.
        // => �?비�?�? ?���? �?비�? 컬렉?��?�� ?��?�� ?��거된?��.
        if (s1 == s2) 
            System.out.println("s1 == s2");
        else
            System.out.println("s1 != s2");
        
        
        
        // string constant pool (?��?�� ???��) 메모�? ?��?��?�� String ?��?��?��?���? ?��?��?��?�� 방법
        // -> java8 specification > 2.5.2. Java Virtual Machine Stacks 참고
        String x1 = "Hello";
        String x2 = "Hello";
        // => ?��?��물이 같으�? 기존 ?��?��?��?��?�� 주소�? 리턴?��?��.
        //    �? 메모�? ?��?��?�� ?��?�� 중복 ?��?��?���? 갖는 ?��?��?��?���? ?��?��?���? ?��?��?��.
        // => JVM?�� ?��?�� ?��까�? 메모리에 ?���??��?��. (�?비�? 컬렉?��?�� �?리�??��?�� ?��?��?��.)
        if (x1 == x2) 
            System.out.println("x1 == x2");
        else
            System.out.println("x1 != x2");
        
        
        
    }
}
