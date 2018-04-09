// 예외 던지기 - 예외 상황을 호출자에게 알려주기
package step21.ex03;

public class Exam02_1 {

    // throw 명령어를 사용하여 예외 정보를 호출자에게 던진다.
    // => throw [java.lang.Throwable 타입의 객체]; 
    //    (던질 수 있는 클래스는 java.lang.Throwable 타입의 객체만이 가능하다.)
    // 
    // java.lang.Throwable
    // => Throwable에는 두 부류의 서브 클래스가 있다.
    // 1) java.lang.Error (시스템 오류)
    //    => JVM에서 발생된 오류이다.
    //    => 개발자가 사용하는 클래스가 아니다.(가능한데 사용하지는 말아라!)
    //    => 이 오류가 발생하면 현재의 시스템 상태를 백업하고 즉시 실행을 멈춰야 한다.
    //    => JVM에서 오류가 발생한 경우에는 계속 실행해 봐야 소용이 없다.
    //       근본적으로 문제를 해결할 수 없다.
    //    => 오류의 예 : 
    //       스택 오버플로우 오류, VM 관련 오류, AWT 윈도우 관련 오류, 스레드 종료 오류 등
    //       
    // 2) java.lang.Exception (애플리케이션 오류)
    //    => 애플리케이션에서 발생시킨 오류이다.
    //    => 개발자가 사용하는 클래스이다.
    //    => 적절한 조취를 취한 후 계속 시스템을 실행하게 만들 수 있다.
    //    => 오류의 예 : 
    //       배열의 인덱스가 무효한 오류, I/O 오류, SQL 오류, Parse 오류 
    
    // 오류를 던진다면 반드시 메서드 선언부에 어떤 오류를 던지는지 선언해야 한다.
    static void m() throws Throwable {
        throw new Throwable(); // OK!
    }
    
    static void m2() throws Error {
        throw new Error(); // OK! 하지만 이 계열의 클래스는 사용하지 말라!
        // 왜? JVM 관련 오류일 때 사용하는 클래스이다.
    }
    
    // java.lnag.Error 계열의 오류를 던질 때는 어떤 오류를 던지는지 선언하지 않아도 된다.
    // 물론 선언해도 된다.
    static void m3(){
        throw new Error(); 
    }
    
    static void m4() throws Exception {
        throw new Exception(); // OK! 보통 개발자가 사용하는 예외 클래스이다. 
    }
    
    // Exception 계열의 예외를 던질 때는 반드시 메서드 선언부에 어떤 계열의 예외인지 선언해야 한다.
    static void m5() throws Exception {
        throw new String(); // 컴파일 오류!
        // throw 로 던질 수 있는 객체는 오직 java.lang.Throwable 타입만 가능하다.
        // cf. javaScript는 가능하다.
    }
    
    public static void main(String[] args) {
    
        // 예외를 받았을 때 처리하는 문법
        try {
            m();
        } catch (RuntimeException e) {
            // 예외가 발새하면 catch 블록에서 적절한 조치를 취한다.
            // 예를 들면, 다음과 같이 예외가 발생된 이유를 간단히 출력한다.
            System.out.println(e.getMessage());
        }
        System.out.println("시스템을 종료합니다.");

    }

}
