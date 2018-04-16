// 대기열 - 서버에 연결을 요청한 후 대기 중인 클라이언트의 목록
package step23.ex02;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.println("서버 실행!");
        
        keyScan.nextLine(); // 사용자가 입력을 하던 안하던 엔터를 치기 전까지는 다음라인으로 넘어가지 않는다. stop의 기능을 함
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("클라이언트 연결을 기다리는 중..."); // 대기열에 들어감
        
        keyScan.nextLine();
        Socket socket = ss.accept();
        System.out.println("대기 중인 클라이언트 중 한 개의 클라이언트에 대해 연결 승인!"); // 자원 해제 않고 기다리는중
        
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        System.out.println("입출력 스트림 준비!");
        
        keyScan.nextLine();
        
        System.out.println("클라이언트 데이터 수신중...");
        System.out.println(in.nextLine());
        System.out.println("클라이언트 데이터 수신 완료!");
        
        System.out.println("클라이언트에게 응답 보냄!");
        out.println("OK!");
        
        // 자원 해제
        socket.close();
        System.out.println("클라이언트와의 연결 해제!");
        
        ss.close();
        System.out.println("서버 종료!");
        // 랜카드 자체에 버퍼가 있어서 보내놓고 난 다음에 close시킨다 아직 다 보내진 상태가 아니다.
        // 먼저 연결되고, 먼저 대기열에 있는 것부터 순서대로 처리된다. => Queue => 소켓통신에서 소켓 대기열에 있는것을 먼저 처리한다.
        // hong이 들어오는 것은 
    }

}

// 포트번호
// => 0 ~ 1023 (well-known-port)
//    - 특정 프로그램이 관습적으로 사용하는 포트 번호
//    - 일반 프로그램을 작성할 때 가능한 이 포트번호를 사용하지 말아야 한다.
//    - 7(echo->신호를 보내면 똑같이 돌아온다. 리눅스서버에는 기본적으로 설치되어있지만 막아놓는다.(해커들이 악용할수 있기 때문이다.)),
//      20(FTP 데이터 포트) 21(FTP 제어포트), 23(telnet), 25(SMTP), 53(DNS), 
//      80(HTTP-> 원래는 주소를 검색할 때 써줘야 하지만 생략해도 가능하다.), 110(POP3), 143(IMAP) 등
// => 1024 ~ 49151 (registered port) -> 서버쪽 프로그램을 짤때
//    - 일반적인 통신 프로그램을 작성할 때 이 범위 포트 번호를 사용한다.
//    - 다만 이 범위의 번호 중에서 특정 프로그램이 널리 사용하는 번호가 있다.
//      가능한 그 번호도 피하라!
//    - 8080(proxy server port), 1521(Oracle), 3306(MySQL) 등
// => 49152 ~ 65535 (dynamic port)
//    - 통신을 하는 프로그램은 반드시 포트번호를 가져야 한다.
//      그래야 OS가 해당 프로그램을 구분할 수 있다.
//    - 따라서 클라이언터 프로그램도 포트번호를 갖는데,
//      프로그램에서 결정하는 것이 아니라, OS로부터 자동 발급 받는다.
//    - 이 범위의 포트번호는 클라이언트가 OS로부터 자동 발급 받는 포트번호이다.