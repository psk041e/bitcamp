// 한글 깨짐 처리
package step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/exam02")
public class Exam02 extends GenericServlet {
    private static final long serialVersionUID = 1L; // 버전 번호를 1로 하라!

    @Override
    public void service(
            ServletRequest request, 
            ServletResponse response) throws ServletException, IOException {
        
        // 출력할 콘텐츠의 타입(MIME type)이 무엇이고,
        // 어떤 문자 코드표(character set)를 사용하여 변환할 것인지 지정한다.
        response.setContentType("text/plain; charset=UTF-8"); // plain: 순수 텍스트란 의미
        // 브라우저에게 텍스트를 보낼거다 순수텍스트를 보낼테니 순수한 텍스트 그대로 출력해줘라
        // enter가 있으면 enter도 출력해야 한다.
        // UTF-8로 보낼테니 그 타입으로 잘 읽어라!
        // 만약 text/html으로 지정을 하게되면 html방식으로 처리하게 된다.
        // 따라서 브라우저에게 내가 보낸 데이터를 어떻게 처리할지에 대한 방식을 알려주어야 한다.
        // 내가 새로운 타입을 만들지 않는 이상 브라우저에 검색해서 그것들중에서 사용해라! (등록된것들)
        // 위키백과 검색 > http://www.iana.org/assignments/media-types/media-types.xhtml
        
        // 출력 스트림을 꺼낼 때
        // 스트림에서 사용할 문자표를 지정하지 않으면,
        // 기본으로 ISO-8859-1 문자 코드표를 사용하여 문자열을 출력한다.
        // 즉, 다음과 같이 클라이언트로 문자열을 보낸다.
        //      String 객체(UTF-16) ==> ISO-8859-1 
        // 즉, String 객체에 들어있는 문자열을 ISO-8859-1 코드표에 따라 
        // 변환하여 클라이언트로 보낸다.
        PrintWriter out = response.getWriter();
        out.println("Hello!");
        
        // 문제는 한글이다.
        // 한글은 ISO-8859-1에 코드가 명시되어 있지 않다!
        // 따라서 한글은 ISO-8859-1 코드 값으로 바꿀 수 없기 때문에
        // 바꾸지 못했다는 의미로 '?' 문자를 대신 보낸다.
        out.println("안녕하세요!");
        
        // 해결책?
        // => ServeltResponse 객체에서 "출력 스트림을 꺼내기 전에"
        //    어떤 문자 코드표를 사용할 것인지 설정해야 한다.
        // => 출력하기 전이 아니라 출력하
        
    }
}

// MIME(Multi-purpose Internet Mail Extension) type
// => 원래는 메일을 보낼 때 콘텐츠의 타입을






