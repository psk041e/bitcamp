// stateless와 stateful의 비교
package step23.ex05;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

// Stateless 방식의 특징
// => 요청할 때마다 서버와 연결한다. 응답 받은 후 서버와의 연결을 끊는다.
// => 요청자를 구분할 수 없어, 클라이언트의 작업 결과를 보관할 수 없다.
public class StatelessServer {
    static int sum = 0;
    
    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행 중...");
        
        // 합계를 계산하는 서버를 만들어 보자!
        // 네트워크 연결을 기다리는 역할을 수행할 객체를 준비
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("연결 준비 완료!");
        
        while (true) {
            Socket socket = ss.accept();
            System.out.println("클라이언트 연결 승인 및 작업 처리 중...");
            processRequest(socket);
            System.out.println("메서드 실행 완료!");
        }
    }
    
    static void processRequest(Socket socket) throws Exception {
        try (
            Socket socket2 = socket; 
            PrintStream out = new PrintStream(socket.getOutputStream());
            Scanner in = new Scanner(socket.getInputStream());
                ) {
            
            String str = in.nextLine();
            if (str.equals("")) {
                out.println("결과 = " + sum);
                return;
            }
            
            // 클라이언트와 연결되면 클라이언트는 값을 한 개 보낸다.
            // 서버는 그 클라이언트의 값을 기존 합계에 추가해야 한다.
            sum += Integer.parseInt(str);
            
            // 클라이언트가 데이터를 보낼 때마다 새로 연결을 수행한다.
            // => 데이터를 보낸 클라이언트가 누군지 서버에서 구분할 수 없다.
            // => 이런 방식의 통신이 "stateless" 이다.
            // => 클라이언트를 구분할 수 없기 때문에 각각의 클라이언트의 상태를
            //    따로 관리할 수 없다.
            // 해결책?
            // => 클라이언트가 접속할 때 식별 번호를 발급하여 클라이언트를 구분한다!
            // => 즉, 서버로부터 식별 번호를 부여받은 클라이언트는
            //    이후에 데이터를 보낼 때 식별번호를 함께 보낸다.

            
        }
    }
}
