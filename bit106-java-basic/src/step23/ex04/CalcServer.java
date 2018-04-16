// stateless 방식 - 계산기 서버 만들기
package step23.ex04;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

// 연결하고 데이터보내고 응답받고 연결끊고
// stateless
// => 서버에 작업을 요청할 때 연결하고, 서버로부터 응답을 받으면 연결을 끊는다.
// => 단점:
//    매번 요청할 때마다 서버에 연결해야 하기 때문에 실행 시간이 많이 걸린다.
//    실행 시간 = 연결하는데 걸린 시간 + 데이터 전송 시간  + 서버 처리 시간 + 데이터 수신 시간
//    특히 서버에 연결하는데 시간이 많이 걸리기 때문에 실행 시간이 많이 소요된다.
// => 장점:
//    서버에 계속 연결된 상태가 아니기 때문에 서버 입장에서는 메모리를 많이 사용하지 않는다.
// 왜? 
// 클라이언트와 연결을 계속 유지하지 않기 때문에 작업을 처리하는 동안만 연결정보를 유지한다.
// 그래서 같은 메모리라도 connectionful 방식 보다는 
// 더 많은 클라이언트의 요청을 처리할 수 있다.
// => 대표적인 예:
//    HTTP 통신 - 웹브라우저가 서버에 연결한 후 요청을 하고 서버가 응답한 후 연결을 끊는다.
//    (크롬 -> 도구 더보기 -> 개발자 도구 -> Network -> Preserve log, Disable cache 체크)
//    메신저 - 메신저 서버에 연결하고 메시지 전송 후 연결 끊는다.
//    메일 전송 - 메일서버에 데이터 전송 후 연결 끊는다.
//
public class CalcServer {
    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행 중...");
        
        ServerSocket ss = new ServerSocket(8888);

        while (true) {
            Socket socket = ss.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());
            
            int a = in.readInt();
            String op = in.readUTF();
            int b = in.readInt();
            int result = 0;
            
            switch (op) {
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "*": result = a * b; break;
            case "/": result = a / b; break;
            }
            
            out.printf("%d %s %d = %d\n", a, op, b, result);
            
            in.close();
            out.close();
            socket.close();
            
        }
        //ss.close();
        
    }
}
