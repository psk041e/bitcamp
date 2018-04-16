// 여러 클라이언트의 요청을 처리하기 
package step23.ex03;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer2 {
    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행 중...");
        
        ServerSocket ss = new ServerSocket(8888);
        
        while (true) {
            Socket socket = ss.accept();
            Scanner in = new Scanner(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());
            
            String str = in.nextLine();
            out.println(str);
            
            in.close();
            out.close();
            socket.close();

            // Address already in use
            // => 같은 포트에서 서버를 두번 띄울 수 없다.
        }
        
        //ss.close(); // 반복문이 무한으로 돌기 때문에 실행이 되지 않는다.
        
    }
}
