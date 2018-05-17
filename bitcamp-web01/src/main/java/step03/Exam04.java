// 요청 파라미터의 값이 한글일 경우 한글 깨짐 현상
package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/exam04")
public class Exam04 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(
            ServletRequest request, 
            ServletResponse response) throws ServletException, IOException {
        
        // tomcat7 이하 버전:
        // => GET 요청으로 한글 문자열을 파라미터로 보낼 때
        //    서버에서 꺼내면 한글이 깨진다.
        //    예) http://localhost:8888/test01/step03/exam04?name=홍길동&age=20
        // => 이유?
        //    웹브라우저: 
        //      1) URL에 입력한 값(UTF-8): "AB가각" (41 42 ea b0 80 ea b0 81) -8byte
        //      2) URL 인코딩: "AB%EA%B0%80%EA%B0%81" (41 42 25 45 41 25 42 30 25 38 30) 
        //         한글을 영문자화시킨다, ascii코드화시킨다. -> 절대 7bit를 넘어가지 않는다.
        //    톰캣서버:
        //      3) URL 디코딩을 수행하여 본래의 UTF-8로 변환: "AB가각" (41 42 ea b0 80 ea b0 81)
        //         - UTF-8은 자바 내부에서 사용하지 않는다.
        //         - 자바의 String 객체는 UTF-16을 사용한다.
        //      4) String 객체(UTF-16): "ABê°ê°" (0041 0042 00ea 00b0 0080 00ea 00b0 0081)
        //         - 각 바이트를 UTF-16으로 변환한다.
        //         - 클라이언트가 보낸 데이터가 어떤 문자표에 따라 만든 데이터인지 알려주지 않으면,
        //           무조건 ISO-8859-1(ISO-latin-1) 이라고 가정하고 무조건 0x00 1바이트를 붙인다.
        //         - 영어인 경우에는 앞에 0x00을 붙이면 UTF-16이기 때문에 아무런 문제가 없다.
        //         - 그러나 한글일 경우에는 그냥 UTF-8 각 바이트에 그냥 0x00을 붙이면
        //           올바르지 않은 UTF-16 코드가 되기 때문에 출력할 때 이상한 글자가 보이는 것이다. 
        //           (한글은 세개(3byte)를 묶어서 UTF-16으로 바꾸어야 하는데 따로따로 00을 붙여 만들어지기 때문에 이상한 글자가 된다.)
        //
        // 해결책?
        // 1) POST 명령으로 보낸 데이터인 경우
        // => 최초로 값을 꺼내기 전에(getParameter()를 최초롤 호출하기 전)
        //    클라이언트가 보낸 문자가 어떤 문자 코드로 되어있는지 알려줘야 한다!
        // => 즉, 클라이언트로부터 받은 코드를 다음과 같이 바꾼다.
        //    UTF-8: "AB가각" (41 42 ea b0 80 ea b0 81)
        //    String 객체(UTF-16): "AB가각" (0041 0042 AC00 AC01)
        //
        // request.setCharacterEncoding("UTF-8"); 
        // 세개를 묶어서 UTF-16으로 바꿔야한다고 알려주는 것이다.
        // 한자같은 경우에는 4개를 묶어야 한다. 이것을 적절하게 알아서 바꿔라!
        // 2) GET 명령으로 보낸 데이터의 경우 (톰캣 서버의 예)
        // => server.xml 설정 파일에서 다음과 같이 태그에 URIEncoding 속성을 추가하라!
        // 단, Tomcat 8 이상부터는 server.xml에 위와 같이 편집할 필요가 없다.
        // GET 요청으로 보낸 UTF-8 데이터는 자동으로 UTF-16으로 잘 변환된다.
        //
        String name = request.getParameter("name"); 
        int age = Integer.parseInt(request.getParameter("age")); 
        
        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.printf("이름=%s\n", name);
        out.printf("나이=%d\n", age);
        
        
    }
}







