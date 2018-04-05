// 클래스 메서드 응용
package step08;

import java.util.Scanner;

public class Exam02_2 {
    static class Math { 
        // 자바에서는 메서드를 클래스 밖에 둘 수 없다!! -> 모든 메서드는 클래스 안에 있어야 한다. (클래스가 최소 포장단위)
        // cf. c++은 바깥에 메서드를 둘 수 있다.
        // 의미있는 포장을 위해 Math클래스 안에 절대값을 리턴하는 메서드를 정의한다.
        
        // 다음 메서드와 같이 인스턴스 변수를 사용하지 않고
        // 파라미터 값을 가지고 작업하는 경우에 보통 클래스 메서드로 정의한다.
        public static int abs(int value) { // 절대값을 리턴하는 메서드
            if (value < 0)
                return value * -1;
            return value;
        }
    }
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("숫자를 입력하세요> ");
        int value = keyScan.nextInt();
        
        // 이렇게 특정 인스턴스의 변수를 다루는 것이 아니라
        // 외부에서 전달한 파라미터 값을 가지고 작업을 수행하는 메서드인 경우
        // 클래스 메서드로 정의하면 사용하기 편하다.
        int result = Math.abs(value);
        
        // 만약 abs() 메서드가 인스턴스 메서드라면,
        // 다음과 같이 인스턴스를 만든 후에 호출해야 한다.
        // abs()는 인스턴스 변수를 사용하지도 않는데
        // 이렇게 인스턴스를 생성해야 한다면 얼마나 낭비적인가!
        /*
        Math m = new Math();
        int result = m.abs(value);
        System.out.printf("절대값=%d\n", result);
        */
    }
}

