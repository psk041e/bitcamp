// HTTP 클라이언트 만들기
package step23.ex07;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

// HTTP 요청 프로토콜
// -----------------------------
// GET [자원주소] HTTP/1.1 (CRLF)
// Host: [서버주소] (CRLF)
// (CRLF)
// -----------------------------
//
// 프로토콜(potocol)?
// => 클라이언트/서버 간의 통신 규칙.
// => 데이터를 주고 받는 규칙.
//
// 규칙에 따라서 보내고 받기만 하면 된다.
public class HttpClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("www.hani.co.kr", 80);
        
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        
        // HTTP 요청 프로토콜에 따라 서버에 데이터 전송
        out.println("GET /arti/economy/economy_general/840889.html?_fr=mt1 HTTP/1.1");
        out.println("Host: www.hani.co.kr");
        out.println();
        
        // HTTP 응답 프로토콜에 따라 서버가 보낸 데이터를 수신
        while (true) {
            try {
                System.out.println(in.nextLine());
            } catch (Exception e) {
                break;
            }
        }
        
        out.close();
        in.close();
        socket.close();
        
    }
}
