// String - 문자?�� 비교
package step10;

public class Exam01_2 {
    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        String s3 = "Hello";
        // ?��?��?��?��?�� 주소�? ?��?�� ?��?��?��?��?�� ?��?��?���? 같�?�? 비교?�� ?��?��
        // equals()?��?�� 메서?���? ?��?��?��?��!
        if (s1.equals(s2)) 
            System.out.println("s1�? s2?�� 같다.");
        else
            System.out.println("s1�? s2?�� ?��르다.");
        
        if (s1.equals(s3)) 
            System.out.println("s1�? s3?�� 같다.");
        else
            System.out.println("s1�? s3?�� ?��르다.");
        
        // => 주소값에 ?���??��?�� ?��?��물�? 모두 같다.
        
    }
}
