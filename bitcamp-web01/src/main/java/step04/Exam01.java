// GET 요청과 POST 요청의 HTTP 프로토콜 비교
package step04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step04/exam01")
public class Exam01 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    // 테스트 방법:
    // http://localhost:8888/bitcamp-web01/step04/exam01_test.html 
    @Override
    public void service(
            ServletRequest request, 
            ServletResponse response) throws ServletException, IOException {
        
        // 클라이언트가 보낸 값을 꺼낼 때는 GET, POST 구분없이 동일한 방법으로 값을 꺼낸다.
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        
        // UTF-16 ==> UTF-8
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("name=%s\n", name);
        out.printf("age=%d\n", age);
        
    }
}

// HTTP 프로토콜 - GET 요청
// - request-URI에 데이터를 포함해서 보낸다.
//       URL?파라미터명=값&파라미터명=값&파라미터명=값...
//   예) /java106-web01/step04/exam01?name=bbb&age=30
// 
/*
GET /java106-web01/step04/exam01?name=bbb&age=30 HTTP/1.1   <== request-line
Host: localhost:8888   <=== header(general/request/entity)
Connection: keep-alive
Pragma: no-cache
Cache-Control: no-cache
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.170 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,...
Referer: http://localhost:8888/java106-web01/step04/exam01_test.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,la;q=0.6
(빈줄)   <== empty line. 보내는 데이터의 끝을 알림. 
*/

//HTTP 프로토콜 - POST 요청
//- message-body(entity-body)에 데이터를 포함해서 보낸다.
//- post 요청을 할 때는 보내는 데이터의 정보를 추가한다.
//  즉 Content-Length 와 Content-Type 헤더를 추가해서 보낸다.
//
/*
POST /java106-web01/step04/exam01 HTTP/1.1     <== request-line
Host: localhost:8888    <== header(general/request/entity)
Connection: keep-alive
Content-Length: 15      <== post 요청할 때만 보내는 헤더 값. 빈 줄 다음에 읽어야 할 바이트의 수.
Pragma: no-cache
Cache-Control: no-cache
Origin: http://localhost:8888
Upgrade-Insecure-Requests: 1
Content-Type: application/x-www-form-urlencoded    <== post 요청할 때만 보내는 헤더 값
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.170 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*...
Referer: http://localhost:8888/java106-web01/step04/exam01_test.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,la;q=0.6
(빈 줄)  <== empty line 
name=bbb&age=30    <== post 요청은 빈 줄 다음에 데이터를 보낸다.  
*/

//GET vs. POST
//[GET]
// - URL에 데이터가 포함되기 때문에 바이너리 데이터를 보낼 수 없다.
//   바이터리 데이터를 BASE64 형식(텍스트 형식)으로 변환하여 보낼 수는 있다. (완전히 불가능한 것은 아니다.)
//   (URL인코딩 : 8bit크기의 문자열을 7bit크기의 문자열로 바꾸는 것이다.)
//   (BASE64 : 바이너리 데이터를 텍스트로 바꾸는 것이다. -> 텍스트로 전송할수 밖에 없는 경우, 크기가 늘어남)
// - 대용량의 데이터를 보낼 수 없다.
// - 대부분의 웹서버는 request-line 및 header의 최대 크기를 8182(8KB)로 제한하고 있다.
//   (한번에 데이터를 왕창 많이 보내면 그 데이터를 처리하느라 서버에 부하가 걸릴수 있기 때문에 URL이 길어지는 것을 방지하기 위해서이다.)
//   => 그래서 파일 업로드나 게시글 등록, 변경에서는 GET 요청을 하지 않는다.
// - 보내는 데이터가 웹브라우전의 URL 주소창을 통해 노출된다. 보안에 취약.
//   URL에 데이터가 포함되기 때문이다.
//   => 그래서 로그인 값을 GET 요청으로 보내지 않는다.
// - URL과 값을 동시에 보낼 때 유용하다.
//   왜? URL에 값이 포함되기 때문이다.
//   => 예) 검색을 요청하는 URL
// - 즐겨찾기에 저장할 수 있으며, 방문기록에 자동으로 저장된다.
//   => 그래서 더더욱 로그인에는 GEt을 사용하면 안된다.
//   => 왜? 즐겨찾기나 방문기록에 URL을 저장할 때 데이터도 함께 저장되기 때문이다.
//
//
//[POST]
// - 멀티파트 형식으로 바이너리 데이터를 보낼 수 있다.
// - 대용량의 데이터를 보낼 수 있다.
//   빈 줄 다음에 데이터를 보내기 때문에 데이터의 크기에 제한이 없다.
//   서버 쪽에서 허용하는 만큼까지 보낼 수 있다.
//   => 파일업로드나 게시글 등록, 변경에 주로 사용한다.
// - 보내는 데이터가 웹브라우저의 URL 주소창에 노출되지 않는다.
//   => 그래서 로그인 갖ㅄ을 보낼 때 이 방식을 사용한다.
// - 즐겨찾기에 저장해봐야 소용없다. 방문기록에 저장된 것은 무용하다.
//   => 왜? URL만 저장되기 때문이다. 즉, 데이터가 포함되어 있지 않기 때문이다.
//   => 게시물 조회, 검색 결과 조회와 같은 데이터 조회 결과를 출력하는 URL을 저장할 때는
//      POST 방식이 아닌 GET 방식을 사용해야 한다.
//   


//BASE64
//- 바이너리 데이터를 텍스트로 변환하여 전송할 때 사용한다.
//- 바이너리 데이터를 ASCII 코드의 문자로 변환하는 방식이다.
//- 이렇게 텍스트로 만든 데이터는 OS에 상관없이, 프로그래밍 언어에 상관없이,
//네트워크 프로토콜에 상관 없이 언제든 주고 받을 수 있다는 장점이 있다.
//혹시 GET방식으로 바이너리데이터를 보낼수있지 않냐고 우긴다면 그렇지 않다. BASE64로 보내는 것이다.











