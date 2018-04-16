// stateless와 stateful의 비교
package step23.ex05;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// Stateless 방식의 특징
// => 요청 할 때마다 서버와 연결한다. 응답 받은 후 서버와의 연결을 끊는다.
// 
public class StatelessClient {
    public static void main(String[] args) throws Exception {
        // 합계 계산을 요청하는 클라이언트를 만들어 보자!
        try (Scanner keyScan = new Scanner(System.in)) {
            while (true) {
                System.out.print("값? "); 
                String str = keyScan.nextLine(); // 키보드에서 값을 입력 받아
                
                try (
                    Socket socket = new Socket("192.168.0.9", 8888); 
                    // real ip를 적거나 localhost를 적어도 된다.
                    PrintStream out = new PrintStream(socket.getOutputStream());
                    Scanner in = new Scanner(socket.getInputStream());) {

                out.println(str); // 서버에 보낸다.
                if (str.equals(" ")) // 만약 값을 입력하지 않았으면
                    System.out.println(in.nextLine()); // 서버가 보낸 결과를 출력한다.
                    break;
                }
            }
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
