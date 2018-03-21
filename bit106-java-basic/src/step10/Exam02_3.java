// Wrapper ?��?��?�� - wrapper 객체?�� �? 비교
package step10;

public class Exam02_3 {
    public static void main(String[] args) {
        Integer obj1 = new Integer(100); // Heap ?�� ?��?��?��?�� ?��?��
        Integer obj2 = new Integer(100); // Heap ?�� ?��?��?��?�� ?��?��
        if (obj1 == obj2) // ?��?��?��?��?�� 주소 비교
            System.out.println("obj1 == obj2");
        else
            System.out.println("obj1 != obj2");
        
        Integer obj3 = 100; // constant pool ?�� ?��?��
        Integer obj4 = 100; // constant pool ?�� ?��?��?�� 기존 주소 리턴
        if (obj3 == obj4) // ?��?��?��?��?�� 주소�? 같다.
            System.out.println("obj3 == obj4");
        else
            System.out.println("obj3 != obj4");
        
        int i = 100;
        Integer obj5 = new Integer(100);
        if (i == obj5) // obj5�? auto-unboxing ?�� ?��?��?��?�� int?? int�? 비교?��?��.
                       // ?��?��?��?�� ?��개�? 같�? 종류�? ?��?���? ?��?��?�� ?�� ?��?��.
            System.out.println("i == obj5");
        else
            System.out.println("i != obj5");
        
        
        
        
    }
}
