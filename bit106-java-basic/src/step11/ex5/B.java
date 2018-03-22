package step11.ex5;

// 상속
// => 재사용할 기존 클래스를 지정한다.
// => 새 클래스에는 추가할 기능을 덧붙인다.(확장한다)
// 주의! 개발 입문자들이 가장 많이 착각하는 것!
// => 상속이라는 단어 때문에 개발 입문자들이 많이 오해한다.
//    "B 클래스가 A 클래스를 상속했기 때문에,
//     B 클래스에는 A 클래스의 코드를 갖고 있을 것이다."
// => 아니다!
//    B 클래스는 A 클래스의 링크 정보만 갖고 있다.(A 클래스의 코드를 자동으로 가져오는 것이 아니다!)
//    따라서 B 클래스를 사용하려면 반드시 A클래스가 있어야 한다.
public class B extends A {
    int v2;
    
    static { // 클래스가 로딩된 다음에 딱 한번 실행된다.(자바버추얼머신은 클래스를 한번만 메모리에 올린다.)
        System.out.println("B클래스의 static{} 실행!");
    }
}

