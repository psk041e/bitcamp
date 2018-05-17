// 클라이언트가 보낸 파라미터의 이름을 꺼내기
package step03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/step03/exam07")
public class Exam07 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(
            ServletRequest request, 
            ServletResponse response) throws ServletException, IOException {

        // GET 요청의 데이터를 꺼낼 경우에는 다음 코드는 의미가 없다. (서버 설정에 달려있기 때문)
        // 그러나 POST 요청의 데이터를 꺼낼 경우를 대비하기 위해 그냥 둔다.
        request.setCharacterEncoding("UTF-8");
        
        Enumeration<String> names = request.getParameterNames(); 
        // Iterator 패턴이다.
        
        response.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = response.getWriter();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            out.printf("%s=%s\n", name, request.getParameter(name)); 
            // 파라미터가 몇개가 넘어올지 알수 없을 때 이 방법을 쓴다.
            // 클라이언트가 어떤 값을 보낼지 애매할 때 이 방법을 쓴다.
            
        }
        
        
    }
}







