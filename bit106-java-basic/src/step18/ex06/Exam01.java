// 응용 - 자바 CLASSPATH에 있는 파일에 절대 경로를 알아내는 방법
package step18.ex06;

import java.net.URL;
import java.util.Enumeration;

// 자바 버추얼머신은 경로에 상관 없이 값을 꺼내준다.
// 이 클래스가 있는 패키지 폴더에서 내가 지정한 파일을 찾아줘라
// 자바 버추얼 머신 밑에 클래스를 로딩만 전문적으로 처리하는 것이 있다. -> ClassLoader
public class Exam01 {

    public static void main(String[] args) throws Exception {
        // 프로그램과 관련된 파일을 일반 경로에 두는 것 보다
        // JVM이 알고 있는 경로(CLASSPATH)에 두면 해당 파일을 보다 쉽게 찾을 수 있다.
        // 왜냐하면,
        // JVM이 모르는 특정 경로에 파일을 두면,
        // 그 파일을 찾기 위해서 소스 코드에 그 특정 경로를 지정해야 한다.
        // 만약 프로그램을 다른 OS에 배포하거나 파일 경로가 달라진다면,
        // 또 소스 코드를 변경해야 하는 번거로움이 발생한다.
        // 그래서 실무에서는 이런 문제를 해결하기 위해
        // 프로그램과 관련된 파일은 주로 CLASSPATH 에 둔다.
        
        // 다음은 CLASSPATH에 파일을 두었을 때 그 파일의 실제 경로를 알아내는 방법이다.
        // 1) CLASSPATH 를 뒤져서 파일을 찾아줄 객체를 얻는다.
        // => ClassLoader (CLASSPATH 경로를 알고 있다.)
        ClassLoader classLoader = ClassLoader.getSystemClassLoader(); // factory method(디자인 패턴)
        
        // 2) 특정 패키지나 클래스의 절대 경로를 알아낸다.
        //    => 클래스 로더는 디렉토리나 파일을 찾을 때 JVM 에 지정된 CLASSPATH에서 찾는다.
        //       따라서 프로그램을 작성할 때 해당 패키지나 파일이 있는 경로를
        //       코드에 지정할 필요가 없어 편리하다.
        //    => 디렉토리 경로를 지정할 때 . 대신 / 를 사용하라!
        //    => getResources()가 리턴하는 것은 찾은 자원의 경로 정보이다.
        //    => 같은 경로의 자원이 여러 디렉토리에 중복해서 있을 때는
        //       getResources()를 호출하여 여러 개의 경로 정보를 받아라!
        //    => 자원의 절대 경로 정보를 담고 있는 URL 객체를 리턴한다.
        // 
        URL url = classLoader.getResource("step18/ex06");
        
        // URL 정보에서 파일 경로를 문자열로 추출한다.
        System.out.println(url.getPath());
        System.out.println(url.getFile()); // getPath() + query
        

        // Enumeration -> Iterator와 유사한 일을 한다.(꺼내주는 일)
        // 여러개를 받을거면 Enumeration을 사용해라
    }

}
