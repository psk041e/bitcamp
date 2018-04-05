// Reflection API : 클래스 로딩과 레퍼런스
package step18.ex01;


public class Exam02 {
    static class A {
        static int s_var = 100;
        int i_var = 200; // 인스턴스 변수
        
        static void m() {}
        void i_m() {} // 인스턴스 메서드

        static {
            System.out.println("A 클래스 로딩!");
        }
    }
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("step18.ex01.Exam02$A");
        // 중첩 클래스는 "클래스명$중첩클래스명" 형식의 이름을 갖는다.
        // -> Navigator의 bin파일에서도 확인할 수 있다.
        // 절대 클래스 안에 들어있지 않다.
        // 자바의 모든 클래스는 별개의 파일로 존재한다.
        // 시스템에 대한 정보를 다루는 클래스 System
        // 파일에 대한 정보를 다루는 클래스 File
        // 클래스에 대한 정보를 다루는 클래스 Class
        // class를 변수명으로 쓰고싶은데 쓰지못하므로 clazz를 많이 쓴다.
        // 제너릭을 쓸때 이 클래스는 어떤 클래스를 다룰지 모르겠는 경우 -> <?>를 사용한다.
        // clazz -> 클래스 정보를 가리키는 레퍼런스
        
    }        
        
}
