// URL(Uniform Resource Locator) - 포트번호 생략
package step16.ex02;

import java.net.URL;

public class Exam03 {
    
    public static void main(String[] args) throws Exception {
        // 웹(WWW) 상에서 자원의 위치를 표현하는 방법
        URL url = new URL("http://www.bitcamp.co.kr/a/b/hello.html#footer"); // #.. -> 문서 내의 특정 위치
        
        // URL 분석
        System.out.printf("프로토콜: %s\n", url.getProtocol());
        System.out.printf("서버주소: %s\n", url.getHost());
        System.out.printf("포트번호: %d\n", url.getPort()); // 들어가는 문 번호
        System.out.printf("자원경로: %s\n", url.getPath());
        System.out.printf("참조경로(내부위치): %s\n", url.getRef());
        
        
    }
    
    
}
