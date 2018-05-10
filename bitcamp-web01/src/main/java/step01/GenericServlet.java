// 서블릿 클래스가 공통으로 구현해야 할 메서드를 미리 이 클래스에서 구현해 둔다.  
package step01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// Servlet 인터페이스에 선언된 메서드 중에서
// 개발자가 관심 없는 메서드는 이 클래스에서 미리 구현해 둔다.
// 그러면 개발자는 Servlet 인터페이스를 직접 구현하기 보다는
// 이 클래스를 상속 받음으로써 개발이 간결해 질 것이다.
public abstract class GenericServlet implements Servlet {
    ServletConfig config;
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 여기서 구현해봐야 어차피 서브 클래스에서 재정의할 메서드이기 때문에 
        // 굳이 수퍼클래스에서 재정의할 필요가 없다.
        // 서브 클래스에서 반드시 구현해야 한다.
        //
        // 추상 메서드를 가질 수 있는 클래스를 만들 수 있다.
        // 직접 쓰지 못하게만 막아놓으면 된다.
        // => 추상 클래스로 만든다.
        // 서브 클래스들의 공통 속성과, 공통 기능을 상속해주는 역할로만 
        // 서브 클래스에게 반드시 구현하라고 강제하고 싶을 때 추상 메서드를 사용한다.
        // 따라서 service()메서드를 반드시 구현하라고 강제해야 한다.
        // 1) 어차피 서브 클래스에서 재정의 해야할 메서드라면 추상 메서드로 만든다.
        // 2) 서브 클래스에서 반드시 재정의 하도록 강제 하고 싶을 때 추상 메서드로 만든다.
        // 추상 클래스만이 추상 메서드를 가질 수 있다.
        // 인스턴스를 못만드는 추상 클래스만이 추상 메서드를 가질 수 있기 때문이다.
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }
    
    @Override
    public void destroy() {
        // 당장 할일이 없으므로 구현만 해둔다.
    }
    
    @Override
    public String getServletInfo() {
        return this.getClass().getName(); // 클래스 이름을 리턴한다.
    }
    
    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }
}
