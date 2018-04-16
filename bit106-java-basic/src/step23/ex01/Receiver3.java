// 서버 + 키보드 입력 + 무한반복
package step23.ex01;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Receiver3 {

    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());;
        
        while (true) {
            // 클라이언트가 보낸 문자열을 수신한다.
            String str = in.nextLine();
            System.out.println(str);
            
            // 키보드 입력을 받아서 클라이언트로 송신한다.
            System.out.print("입력> ");
            String input = keyScan.nextLine();
            out.println(input);
            
            if (str.equals("quit")) {
                break;
            }
        }
        
        in.close();
        out.close();
        socket.close();
        serverSocket.close();
        keyScan.close();
    }

}
