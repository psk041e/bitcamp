// 캡슐화(encapsulation) - 셋터와 겟터
package step11.ex13;

public class Exam01_4 {
   
    public static void main(String[] args) {
        // 환자 데이터를 등록해보자!
        Customer4 c1 = new Customer4();

        // 실무에서 만드는 셋터는 보통 파라미터 값을 검증하지 않기 때문에
        // 그냥 입력된 값 그대로 인스턴스 변수에 저장한다.
        // 그래서 값을 꺼내 출력해보면 입력된 값 그대로 출력될 것이다.
        c1.setName("홍길동");
        c1.setAge(300);
        c1.setWeight(100);
        c1.setHeight(-50);
        // 셋터 메서드에서 유효한 값이 아니면 필터링하여 처리할 것이다.

        // 값을 꺼내보자!
        // => 인스턴스 변수에 직접 접그할 수 없기 때문에 메서드를 통해 값을 꺼내야 한다.
        // => Customer3에는 인스턴스 변수의 값을 리턴해주는 겟터가 구비되어 있다.
        System.out.printf("%s, %d, %d, %d\n",
                c1.getName(), c1.getAge(), c1.getWeight(), c1.getHeight());
        
        
    }
}
