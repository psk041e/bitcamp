// stateful 방식 - 계산기 서버 만들기(접속유지)
package step23.ex04;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

// stateful 방식
// => 한 번 연결한 후 여러 번 요청/응답하는 방식
// => 단점:
//    한 번 연결하면 클라이언트가 연결을 끊을 때까지 계속 유지한다.
//    클라이언트가 작업을 요청하지 않더라도 계속 연결정보를 유지해야 하기 때문에
//    메모리를 많이 차지하고 동시에 많은 클라이언트의 요청을 처리하기 힘들다.
// => 장점:
//    한 번 서버에 연결되면 클라이언트가 연결을 끊을 때 까지 유지되기 때문에 
//    작업을 처리하는 속도가 빠르다.
//    작업 처리하는데 걸리는 시간 = 데이터 전송 시간 + 작업 처리 시간 + 데이터 수신 시간
//    즉 작업을 요청할 때마다 연결할 필요가 없기 때문에 연결하는데 신간이 걸리지 않는다.
//    클라이언트의 작업 상태를 계속 유지할 수 있기 때문에 "stateful" 방식이라 부른다.
//
// => 대표적인 예:
//    게임 서버 연결 - 서버에 한 번 연결되면 게임을 마칠 때 까지 데이터를 주고 받는다.
//    화상 통신 - 한 번 연결되면 연결을 끊을 때 까지 데이터를 주고 받는다.
//    채팅 서버 - 전용 클라이언트를 이용한 채팅
//    텔렛 - 원격 제어 프로그램
//    FTP - 파일 전송 프로그램
//
public class CalcServer2 {
    public static void main(String[] args) throws Exception {
        System.out.println("서버 실행 중...");
        
        ServerSocket ss = new ServerSocket(8888);

        while (true) {
            Socket socket = ss.accept(); // 대기열에 있는 클라이언트 하나를 꺼내서 리턴받는다.
            try {
                processRequest(socket); // 소켓을 주면서 클라이언트요청을 호출하라고 한다.   
                                        // 메서드 호출한 쪽에서 처리하도록 해라
            } catch (Exception e) {
                System.out.println("클라이언트 요청 처리 중 오류 발생!");
                System.out.println("다음 클라이언트의 요청을 처리합니다.");
            }
        }
        //ss.close();
        
    }
    
    static void processRequest(Socket socket) throws Exception {
        try (
                Socket socket2 = socket; 
                // 안쓰는 변수를 선언한 이유?
                // 여기에 선언된 변수에 대해서는 try블록을 나가기 전에 내부적으로 자동으로 close해주기 때문에
                // 따로 close문을 쓰지 않아도 된다.
                DataInputStream in = new DataInputStream(socket.getInputStream());
                PrintStream out = new PrintStream(socket.getOutputStream());
                ) {
             
            l1: while (true) { 
                // 특정 문장을 나가고 싶으면 라벨을 붙여서 나간다.
                // boolean 변수를 이용해 초기 값을 true,
                // switch(변수)를 넣고
                // default: 변수 = false;를 이용해도 된다. 
                int a = in.readInt();
                String op = in.readUTF();
                int b = in.readInt();
                int result = 0;
                
                switch (op) {
                case "+": result = a + b; break;
                case "-": result = a - b; break;
                case "*": result = a * b; break;
                case "/": result = a / b; break;
                case "quit": break l1;
                }
                out.printf("%d %s %d = %d\n", a, op, b, result);
            }
            out.println("quit");
        }
    }
}
