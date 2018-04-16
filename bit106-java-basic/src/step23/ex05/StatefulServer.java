// stateless와 stateful의 비교
package step23.ex05;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// Stateful 방식의 특징
// => 클라이언트와 계속 연결을 유지하기 때문에 작업 결과를 계속 서버에 유지할 수 있다.
// 
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
                if (str.equals(" ")) 
                    break;
                sum += Integer.parseInt(str);
            }

            out.println("결과는 = " + sum);
        }
    }
}
