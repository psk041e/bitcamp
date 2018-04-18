// stateless와 stateful의 비교
package step23.ex05;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// Stateless 방식의 특징
// => 요청할 때마다 서버와 연결한다. 응답 받은 후 서버와의 연결을 끊는다.
// => 요청자를 구분할 수 없어, 클라이언트의 작업 결과를 보관할 수 없다. 
public class StatefulServer {
    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행 중...");
        // 합계를 계산하는 서버를 만들어 보자!
        ServerSocket ss = new ServerSocket(8888);
        
        while (true) {
            Socket socket = ss.accept();
            System.out.println("클라이언트 연결 승인 및 작업 처리 중...");
            processRequest(socket);
            
        }
    }
    
    static void processRequest(Socket socket) throws Exception {
        try (
            Socket socket2 = socket; 
                // try블록을 나가기 전에 socket2에 대해서 close()가 호출되고
                // 그것은 곧 socket에 대해서 close()가 호출되는것이나 마찬가지이다.
            PrintStream out = new PrintStream(socket.getOutputStream());
            Scanner in = new Scanner(socket.getInputStream());
                ) {
            
            // 클라이언트와의 연결을 끊을 때까지 계속 결과를 서버에 유지한다.
            // => "connectionful(stateful)-상태유지, 연결유지" 방식이라 부른다.
            int sum = 0;
            
            while (true) {
                String str = in.nextLine();
                if (str.equals("")) 
                    break;
                sum += Integer.parseInt(str);
            }

            out.println("결과 = " + sum);
        }
        
        // "stateful"은 한 번 연결 되면 연결을 끊을 때 까지 데이터를 주고 받는다.
        // 그래서 각 클라이언트의 작업 결과(상태 값)를 유지할 수 있다.
        // 단, 현재 버전의 문제는 클라이언트가 연결을 끊을 때 까지 
        // 다른 클라이언트의 요청을 처리 하지 못한다는 문제가 있다.
        // 해결책?
        // => 멀티 스레드를 이용하여 동시에 여러 클라이언트에 요청을 처리하면 된다!
    }
}
