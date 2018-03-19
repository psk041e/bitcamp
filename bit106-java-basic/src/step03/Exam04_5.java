// 클래스 사용 - import II
package step03;

// 구체적으로 클래스 이름까지 지정하지 않고
// 패키지명 다음에 wildcard(*)를 지정한다면
// 그 패키지의 모든 클래스를 패키지 명 없이 사용할 수 있다.
import step03.test.*;
import java.util.*;
import java.lang.reflect.*;

public class Exam04_5 {
    public static void main(String[] args) {
        B v2;
        v2 = new B();

        Method obj1;
//        Calender obj2;

    }
}

// 결론!
// - 가능한 import 문을 선언할 때 * 대신 구체적인 클래스명을 적어라!
// - 같은 패키지의 여러 클래스를 사용하더라도
//   귀찮지만 클래스명을 적어라!
// - 왜?
//   소스 코드를 읽을 때 어떤 클래스가 어떤 패키지에 있는지 빠르게 파악할 수