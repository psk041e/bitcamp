// String - mutable(바�? ?�� ?��?��) vs immutable(바�? ?�� ?��?��) 객체 -> ?���? ?��?��?��?��?�� ?��?��?��?��.
// 메모리�? ?���? 고정?���? 바�??�� ?��?��?�� ?��로그?�� ?��?��?�� 빠르?��. 그래?�� 기본?��?���? immutable객체?�� 경우�? 좋다.
package step10;

public class Exam01_3 {
    public static void main(String[] args) {
        // String 객체?�� ?��?��?��?�� immutable 객체?��?��.
        // �?, ?�� �? 객체?�� 값을 ?��?���? �?경할 ?�� ?��?��.
        
        String s1 = new String("Hello");
        
        // String ?��?��?��?��?�� ?��공하?�� ?��?�� 메서?���? ?��출하?���? 간에 
        // ?��?��?�� ?��?��?���? �?경하�? ?��?��?��.
        // ?���?, ?���? String 객체�? 만들 뿐이?��.
        String s2 = s1.replace('l', 'x');
        System.out.printf("%s : %s\n", s1, s2); // ?��본�? 바�?��? ?��?��?��.
        
        String s3 = s1.concat(", world!");
        System.out.printf("%s : %s\n", s1, s3); // ?��본�? 바�?��? ?��?��?��.
        
        // StringBuffer?�� mutable 객체?��?��.
        // ?��?��?�� 문자?��?�� �?경하�? ?��?�� ?�� ?��?��?��?�� ?��?��?��?��?��.
        StringBuffer buf = new StringBuffer("Hello");
        //                                   01234
        buf.replace(2, 4, "xx"); // replace?��?��법이 조금 ?��르다. ?��번호?�� 바꾸고싶?? 문자 ?��?��?�� ?��?��?���? ?���??��.
        System.out.println(buf); // ?��본을 바꾼?��.
        
        // String객체 값을 바꾸�? ?���? 객체�? 계속 ?��?��?��?�� 메모리�?? ?��비하?�� ?���? ?��?��
        // ?��?��?�� 객체?�� 값을 바꾸�? ?��?���? StringBuffer�? ?��?��?��?�� 바꿔주는것이 좋다.
        
        // StringBuffer ?��?��?�� 주의?��?��!
        // StringBuffer?�� ?��?��물을 비교?�� ?�� equals()�? ?��?��?��봐야 ?��?��?��?��.
        // == ?��?��?��?? 같�? 결과�? 출력?��?��.
        StringBuffer b1 = new StringBuffer("Hello");
        StringBuffer b2 = new StringBuffer("Hello");
        if (b1.equals(b2)) 
            System.out.println("b1 == b2");
        else
            System.out.println("b1 != b2");
        
        // ?��결책?
        // => StringBuffer?��?�� String?�� 꺼내 비교?��?��!
        if (b1.toString().equals(b2.toString())) 
            System.out.println("b1.toString() == b2.toString()");
        else
            System.out.println("b1.toString() != b2.toString()");
        
    }
}
