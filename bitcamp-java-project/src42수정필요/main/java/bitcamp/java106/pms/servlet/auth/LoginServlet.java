// 로그인 폼 출력과 사용자 인증처리 서블릿
package bitcamp.java106.pms.servlet.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
    
    MemberDao memberDao;
    
    @Override
    public void init() throws ServletException {
        ApplicationContext iocContainer = 
                WebApplicationContextUtils.getWebApplicationContext(
                        this.getServletContext()); 
        memberDao = iocContainer.getBean(MemberDao.class);
    }

    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        
        Cookie cookie = null;
        if (request.getParameter("saveId") != null) {
            // 입력폼에서 로그인할 때 사용한 ID를 자동으로 출력할 수 있도록 
            // 웹브라우저로 보내 저장시킨다.
            cookie = new Cookie("id", id);
            cookie.setMaxAge(60 * 60 * 24 * 7);
        } else { // "아이디 저장" 체크박스를 체크하지 않았다면 
            cookie = new Cookie("id", "");
            cookie.setMaxAge(0); // 웹브라우저에 "id"라는 이름으로 저장된 쿠키가 있다면 제거한다.
            // 즉 유효기간을 0으로 설정함으로써 "id"라는 이름의 쿠키를 무효화시키는 것이다.
        }
        response.addCookie(cookie);
        
        try {
            Member member = memberDao.selectOneWithPassword(id, password);
            
            HttpSession session = request.getSession();
            
            if (member != null) { // 로그인 성공!
                session.setAttribute("loginUser", member);

                // 로그인 하기 전의 페이지로 이동한다.
                String refererUrl = (String)session.getAttribute("refererUrl");
                
                if (refererUrl == null) { 
                    // 이전 페이지가 없다면 메인 화면으로 이동시킨다.
                    response.sendRedirect(request.getContextPath()); // => "/java106-java-project"
                } else { 
                    // 이전 페이지가 있다면 그 페이지로 이동시킨다.
                    response.sendRedirect(refererUrl);
                }
                return;
                
            } else { // 로그인 실패!
                session.invalidate();
                // forward할때는 이전에 설정한것이 무시되지만
                // include는 include하기 전 서블릿에서 설정해주어야 한다.
                response.setContentType("text/html;charset=UTF-8");
                request.getRequestDispatcher("/auth/fail.jsp").include(request, response);
                // 이 서블릿이 현재 어플리케이션
                // sendRedirect는 반드시 url을 지정한다.
                // 그러나 이것은 지정하지 않는다. include foward는 현재 웹 어플리케이션을 기준으로
                // 하기 때문에 앞의 /는 bitcamp-java-project를 의미한다.
                // 웹 브라우저에 보내는 것이다.
                // 웹 브라우저에 보내는 url은 무조건 서버 루트를 의미한다. 
                // include foward할때 /는 현재 어플리케이션에서 사용하는 루트 이기 때문에 현재 웹 어플리케이션을 의미한다.
                // 이 경로는 서블릿 컨테이너에게 요구하는 것이다. 
                // 웹 브라우저에서 바라보는 /는 localhost:8888이다. 
                // html의 모든 링크는 브라우저에게 보내는 것이므로 /는 서버루트로 받아들인다. 
                // 따라서 jsp에서 <%=%>를 사용한 것이다.
            }
        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("title", "로그인 실패!");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}

//               [웹브라우저]                                  [웹서버] 
// GET 요청: /java106-java-project/auth/login ===>
//                                                       <=== 응답: 로그인폼 
// POST 요청: /java106-java-project/auth/login ===>
//                                                       <=== 응답: redirect URL
// GET 요청: /java106-java-project ===> 
//                                                       <=== 응답: index.html
// 메인화면 출력!

//ver 42 - JSP 적용
//ver 41 - 클래스 추가




