package step22.ex09;

// 인스턴스의 값을 바이트 배열로 자동 변환(Serialize)할 수 있도록 허가한다.
// => java.io.Serializable 인터페이스를 구현한다.
// => Serializable 인터페이스는 아무런 메서드가 정의되어 있지 않다.
//    이 클래스가 인터페이스를 구현한다고 해서 추가해야 될 것은 없다. 
//    단지 Serialize를 활성화시키는 기능을 수ss행한다.
// => 이 인터페이스를 구현한 객체만 ObjectInputStream/ObjectOuputStream으로
//    입출력할 수 있다.
public class Member3 implements java.io.Serializable{
    // java.io.Serializable 인터페이스를 구현하는 모든 클래스는
    // 반드시 데이터의 버전을 식별할 때 사용할 번호를 지정해야 한다.
    // 버전 번호는 private static final long serialVersionUID 변수에 저장한다.
    // 만약 클래스에 그 변수가 없다면 컴파일러가 자동으로 부여한다.
    //
    private static final long serialVersionUID = 7L;
    
    String name;
    int age;
    boolean gender; // true(여자), false(남자)
    
    @Override
    public String toString() {
        return "Member3 [name=" + name + ", gender=" + gender + ", tel=" + tel + "]";
    }

    // Exam03_2.java 를 실행하기 전에 다음 변수를 추가하고, toString()을 개정하라!
    String tel;

}
