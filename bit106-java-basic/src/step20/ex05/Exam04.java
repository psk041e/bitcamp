// 애노테이션 프로퍼티 값 추출 - 배열 값 추출
package step20.ex05;

public class Exam04 {

    public static void main(String[] args) {
        Class clazz = MyClass4.class;
        MyAnnotation3 obj = (MyAnnotation3)clazz.getAnnotation(MyAnnotation3.class);
        
        System.out.println(obj.v1()[0]);
        System.out.println(obj.v2()[0]);
        System.out.println(obj.v3()[0]);
        
    }
}




