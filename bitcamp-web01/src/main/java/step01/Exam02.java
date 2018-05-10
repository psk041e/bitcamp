// 서블릿 만들기 2 - 추상 클래스를 상속 받아서 Servlet 인터페이스를 간접적으로 구현하기.
// 자식클래스는 무조건 그 인터페이스의 구현체가 된다.
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
// 매번 다섯개 메서드를 다 만들 필요 없이 service()만 만들면 된다.
//
@WebServlet("/step01/exam02") 
// 이 전체가 이름이기 때문에 폴더와 상관없다.
// 이름이지만 파일경로처럼 지어야 명령어가 체계적이게 된다.
// 따라서 이름을 지을 때는 관리하기 편하도록 위와같이 경로처럼 짓는다.
public class Exam02 extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Exam02.service()");
    }
}
