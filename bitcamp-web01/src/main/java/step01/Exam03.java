// 서블릿 만들기 3 - 추상 클래스를 상속 받아서 Servlet 인터페이스를 간접적으로 구현하기.
package step01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// => javax.servlet.Servlet 인터페이스를 직접 구현하는 것 보다
//    미리 구현한 클래스를 상속 받아서
//    필요한 메서드만 구현하거나 재정의하는 것이 편하다!
// => 그래서 이미 자바에서는 GenericServlet이라는 이름을 가진 클래스를 제공하고 있다.
// => 그러면 있는데 왜 만든겁니까??
//    - 
//
@WebServlet("/step01/exam03") 
// 이 전체가 이름이기 때문에 폴더와 상관없다.
// 이름이지만 파일경로처럼 지어야 명령어가 체계적이게 된다.
// 따라서 이름을 지을 때는 관리하기 편하도록 위와같이 경로처럼 짓는다.
public class Exam03 extends javax.servlet.GenericServlet { 
    private static final long serialVersionUID = 1L;
    // 파일을 저장할 때 버전정보를 넣는것과 같다.
    // 실무에서 이것을 만들어도 활용하지는 않는다.
    // 그러나 기술적으로 대비해서 이 인터페이스를 구현하고 있다.

    // javax.servlet.을 써주지 않으면 같은 패키지에 있는 클래스를 상속받기 때문에 명시해주어야 한다.
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Exam02.service()");
    }
}
