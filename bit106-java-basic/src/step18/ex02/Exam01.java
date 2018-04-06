// 클래스 정보 추출 - 클래스 이름 알아내기
package step18.ex02;

public class Exam01 {

    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("java.lang.String");
        // Class -> 클래스 정보를 리턴하는 메서드를 가지고 있다.
        System.out.println(clazz.getSimpleName()); // String
        System.out.println(clazz.getName()); // java.lang.String
        System.out.println(clazz.getCanonicalName()); // java.lang.String
        System.out.println(clazz.getTypeName()); // java.lang.String
        
        
    }
}
