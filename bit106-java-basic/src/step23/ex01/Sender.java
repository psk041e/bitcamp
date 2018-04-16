package step23.ex01;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Sender {

    public static void main(String[] args) throws Exception {
        // 1) 다른 컴퓨터와 네트워크로 연결한다.
        Socket socket = new Socket("192.168.0.59", 8888);
        // 네트워크 연결을 수행하는 객체
        
        // 2) 소켓 객체를 통해 읽고 쓸 수 있도록 입출력 스트림을 얻는다.
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());;
        
        // 3) 상대편으로 문자열을 한 줄 보낸다.
        // => 상대편에서 데이터를 읽을 때 까지 리턴하지 않는다.
        // => 이런 메서드를 블로킹(blocking) 메서드라 부른다.
        // 작업이 끝날 때 까지 리턴하지 않는 메서드
        // 상대편에서 Hello를 다읽어야만이 다음 라인으로 간다.
        out.println("박서경");
        
        // 4) 상대편에서 보낸 문자열을 한 줄 읽는다.
        // => 상대편이 한 줄 데이터를 보낼 때 까지 리턴하지 않는다.
        // => 이런 메서드를 블로킹 메서드라 부른다.
        String str = in.nextLine();
        System.out.println(str);
        
        // 5) 항상 입출력 도구는 사용 후 닫아야 한다.
        in.close();
        out.close();
        
        // 6) 네트워크 연결도 닫는다.
        socket.close();
        
    }

}
