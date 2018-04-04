// 템플릿 메서드를 구현한 클래스 사용
package step15.ex03;

public class Exam01 {
    
    public static void main(String[] args) {
        Restaurant obj1 = new Restaurant();
        Farm obj2 = new Farm();
        
        // 레스토랑이나 농장 건축의 기본 흐름은 정해져 있다.
        // 단지 착수와 완료에 대한 것만 다르다.
        obj1.build();
        System.out.println("----------------");
        obj2.build();
    }
}
