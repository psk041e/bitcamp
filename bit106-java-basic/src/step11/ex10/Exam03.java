// 메서드 오버로딩(overloading) - 응용  II
package step11.ex10;

public class Exam03 {
    public static void main(String[] args) {
        // 다양한 파라미터 값을 받는 println()
        // 메서드가 하나가 아니라 여러개였던 것이다!
        System.out.println(100);
        System.out.println(true);
        System.out.println("Hello");
        
        // 외부에서 값을 받아 Integer 객체를 생성하는 메서드들
        Integer obj1 = Integer.valueOf(100);
        Integer obj2 = Integer.valueOf("100");
        Integer obj3 = Integer.valueOf("64", 16);
//        Integer obj4 = Integer.parseInt(100);
        
        // 추가.
        // valueOf(String)은 new Integer()으로 객체를 반환하고 
        // parseInt(String)은 int 기본 자료형을 반환한다.
        
        System.out.printf("%d, %d, %d\n", obj1, obj2, obj3);
        
    }
}
