package step11.ex12;

public class Exam04 {
    public static void main(String[] args) {
        Member m1 = new Member("홍길동", 20);
        Member m2 = new Member("홍길동", 20);
        
        // 비록 m1과 m2는 같은 값을 갖고 있지만 인스턴스가 다르다.
        System.out.println(m1 == m2);
        
        // Object로부터 상속 받은 hashCode()는 인스턴스 마다 고유의 해시값(식별값)을 리턴한다. 
        System.out.printf("%x, %x\n", m1.hashCode(), m2.hashCode()); // %x: 16진수 출력
        // 해시코드가 다르다.
        
        // Object로부터 상속 받은 toString()은 "클래스명@해시값"을 리턴한다.
        System.out.printf("%s, %s\n", m1.toString(), m2.toString());

        // Object로부터 상속 받은 equals()는 인스턴스가 같은지 검사한다.
        System.out.printf("%b\n", m1.equals(m2));
        
        System.out.println("-----------------------------------");
        
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        
        // 비록 s1과 s2는 같은 문자열을 갖고 있지만 인스턴스가 다르다.
        System.out.println(s1 == s2);
        
        // String 클래스는 Object로부터 상속 받은 hashCode()를 오버라이딩 했다.
        // => 문자열이 같으면 같은 해시값을 리턴하게 만들었다.
        // => 재정의 하지 않았다면 같은 값이 절대 나올 수 없다. 
        System.out.printf("%x, %x\n", s1.hashCode(), s2.hashCode()); // %x: 16진수 출력
        // 해시코드는 인스턴스 주소가 아니다! 자바는 주소를 알려주지 않는다.
        // c, c++은 주소를 알려주기때문에 주소를 마음대로 엑세스 할 수 있어서 문제가 많았다.
        // 그래서 자바에서는 주소를 알려주지 않는다.
        
        // String 클래스는 Object로부터 상속 받은 toString()을 오버라이딩 했다.
        // => 스트링 인스턴스에 보관된 문자열을 리턴하도록 만들었다.
        System.out.printf("%s, %s\n", s1.toString(), s2.toString());

        // String 클래스는 Object로부터 상속 받은 equals()를 오버라이딩 했다.
        // => 문자열이 같은지를 비교하도록 만들었다.
        System.out.printf("%b\n", s1.equals(s2));
    }
}
