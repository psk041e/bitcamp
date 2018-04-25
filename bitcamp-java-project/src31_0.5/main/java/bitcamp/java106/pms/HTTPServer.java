// HTTP 프로토콜에 따라 요청을 처리할 서버
// 웹 브라우저에 입력된 것 중에서 서버, 포트번호를 빼고 첫번째 줄에 보낸다.
// 서버창에서는 오버(=CRLF)할때까지, 빈줄을 읽을 때 까지 
//
// http프로토콜
// ------------------------------
// 크롬 브라우저는 이 데이터를 서버에 보내고
// 웹 브라우저에서 주소를 입력하고 엔터를 치면
// 웹 브라우저는 그 해당 웹서버에 연결하고 그 데이터를 한번에 쫙 보낸다.
// 웹 서버는 그 데이터를 처리하고 한번에 보낸 후 연결을 끊는다.
// 주거니받거니 하는 것이 아니라 한 번 보내고 한 번 응답하면 끝이다.
// 웹 서버가 웹 브라우저에게 반드시 보내줘야 하는 형식
// 크롬은 개발용으로 참고하라고 쪼개서 보여준다. (response header -> 서버에서 보낸 데이터)
// ------------------------------
package bitcamp.java106.pms;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HTTPServer {
    int port;
    ApplicationContainer applicationContainer;
    
    public HTTPServer(int port, ApplicationContainer applicationContainer) {
        this.port = port;
        this.applicationContainer = applicationContainer;
    }
    
    public void execute() throws Exception {
        // 서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket(this.port);
        System.out.println("서버가 시작됨!");
        
        while (true) {
            Socket socket = serverSocket.accept();
            
            // 클라이언트 요청을 처리할 코드를 기존의 실행흐름에서 분리하여 실행한다.
            // 그리고 바로 새 스레드(실행흐름)의 실행을 시작시킨다.
            System.out.println("클라이언트 요청 처리 중....");
            new RequestProcessorThread(socket).start();
            
            // 그리고 기존의 실행은 위의 t 스레드와 상관 없이 계속 진행한다.
        }
    }
    
    // 기존의 실행 흐름과 분리하여 명령을 처리할 클래스
    class RequestProcessorThread extends Thread { // 요청 처리 스레드, java.lang에 있어서 따로 import해주지 않아도 된다.
        Socket socket;
        
        public RequestProcessorThread(Socket socket) {
            this.socket = socket;
        }
        
        // 기존의 실행 흐름에서 분기되어 독립적으로 실행할 코드를 이 메서드에 두어라!
        @Override
            public void run() {
            PrintWriter out = null;
            Scanner in = null;
            
            try { 
                out = new PrintWriter(socket.getOutputStream());
                in = new Scanner(socket.getInputStream());
                
                boolean firstLine = true;
                String requestURI = null;
                
                while (true) {
                    String line = in.nextLine(); 
                    if (line.equals("")) 
                        break; 

                    if (!firstLine)
                        continue;
        
                    requestURI = line.split(" ")[1]; 
                    firstLine = false;
                }
                
                String result = applicationContainer.excute(requestURI);
                
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/plain;charset=UTF-8");
                out.println();
                out.println(result);
                
            } catch (Exception e) {
                out.println("서버 오류!");
                e.printStackTrace(out);
                out.println();
            } finally {
                out.close();
                in.close();
                try {socket.close();} catch (Exception e) {}
            }
            }
    }
}
