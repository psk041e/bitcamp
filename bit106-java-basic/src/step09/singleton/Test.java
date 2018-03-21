// Singleton ?��?��
// => 객체�? ?�� 개만 ?��?��?�� ?�� ?���? 만드?�� ?���? 기법 (Calender�? ?��??같�? 방식?���? ?��?��?��?��.)
package step09.singleton;

public class Test {

    public static void main(String[] args) {
        // Singleton?�� ?��?��?���? ?��?? ?��?��?��?�� ?��?��?��?�� 만들�?
        Car c1 = new Car();
        Car c2 = new Car();
        Car c3 = new Car();
        // ?��?���? ?��?��?��?�� ?��?��?�� ?��?��?�� ?��?��.
        
        System.out.println("-----------------");
        
        // Car2 ?��?��?��?�� ?��?��?���? ?��근할 ?�� ?���? ?��문에 ?��출할 ?�� ?��?��.
        // Car2 c1 = new Car2(); // 컴파?�� ?���?!
        
        
        Car2 x1 = Car2.getInstance();
        Car2 x2 = Car2.getInstance();
        Car2 x3 = Car2.getInstance();
        if (x1 == x2) System.out.println("x1 == x2");
        if (x2 == x3) System.out.println("x2 == x3");
        
        
        
    }
}
