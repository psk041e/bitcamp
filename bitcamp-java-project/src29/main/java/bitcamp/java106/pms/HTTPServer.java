// HTTP 프로토콜에 따라 요청을 처리할 서버
// 웹 브라우저에 입력된 것 중에서 서버, 포트번호를 빼고 첫번째 줄에 보낸다.
// 오버 -> CRLF
// 서버창에서는 오버할때까지, 빈줄을 읽을 때 까지 
// http프로토콜
// 크롬 브라우저는 이 데이터를 서버에 보내고
// 웹 브라우저에서 주소를 입력하고 엔터를 치면
// 웹 브라우저는 그 해당 웹서버에 연결하고 그 데이터를 한번에 쫙 보낸다.
// 웹 서버는 그 데이터를 처리하고 한번에 보낸 후 연결을 끊는다.
// 주거니받거니 하는 것이 아니라 한 번 보내고 한 번 응답하면 끝이다.
// 웹 서버가 웹 브라우저에게 반드시 보내줘야 하는 형식
// 크롬은 개발용으로 참고하라고 쪼개서 보여준다. (response header -> 서버에서 보낸 데이터)
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
            processRequest(socket);
        }
    }
    
    private void processRequest(Socket socket) {
        PrintWriter out = null;
        Scanner in = null;
        
        try { // 소켓으로부터 입출력스트림을 준비
            out = new PrintWriter(socket.getOutputStream());
            in = new Scanner(socket.getInputStream());
            
            // HTTP 프로토콜에서 요청 정보를 읽는다.
            boolean firstLine = true;
            String requestURI = null;
            
            while (true) {
                String line = in.nextLine(); 
                // 변수가 또 만들어진다고 걱정하지 말아라
                // 훨씬 더 직관적이게 된다.
                // 한 줄을 읽어와 그 줄이 빈줄인지 확인한다.
                if (line.equals("")) // 빈줄을 보낼때까지 계속 읽는다.
                    break; // 빈줄이라면 읽기를 멈춘다.
                
                // 브라우저에서 명령어를 실행할때 우리가 필요한 명령어는 localhost:8888의 뒷부분이다.
                // ex) /board/list
                // => 클라이언트가 보낸 데이터중에서 나머지 라인은 관심없고 첫번째 라인만 관심있다.
                // 처음에 읽을때는 true, 그 나머지 라인은 
                if (!firstLine)
                    continue;
    
                // HTTP 요청 프로토콜에서 첫 번째 줄에 있는 요청 URI 정보를 추출한다.
                // 첫번째 라인을 공백으로 자른 후 request라인을 공백으로 자른 후 집어넣는다.
                // 한 줄을 자르면 세개의 방으로 나뉘고 우리가 관심있는 값은 1번방에 있는 값이다
                // 따라서 첫번째 라인에서 공백으로 잘라 그중 1번방의 내용을 담는다.
                // firstLine뒤의 내용은 읽어도 쓰지 않지만 다 읽어줘야 하기 클라이언트가 알기 때문에 공백전까지 모두 읽어준다.
                // 네트워크는 반드시 보내면 읽어줘야 한다.
                // 리턴되어야 하는데 읽을때까지 리턴을 하지 못한다.
                
                requestURI = line.split(" ")[1]; 
                firstLine = false;
                // 클라이언트가 보내는 것은 쓰지 않더라도 모두 읽어줘야 한다.
            }
            
            // ApplicationContainer에게 실행을 요청한다.
            // requestURI를 처리할 컨트롤러를 찾아서 데이터값을 찾아 처리한 내용을 result에 담는다.
            String result = applicationContainer.excute(requestURI);
            
            // HTTP 프로토콜에 따라 응답한다.
            out.println("HTTP/1.1 200 OK"); // 실행상태 정보 반드시 왼쪽과 같이 보낸다.
            out.println("Content-Type: text/plain;charset=UTF-8"); // 끝에 ;은 붙이면 안됨
            out.println(); // 빈줄을 보낸다.
            out.println(result); // 데이터를 보낸다. -> 빈줄 다음에 데이터를 뿌린다.
            // 브라우저는 result내용을 화면에 뿌린다.
            
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
