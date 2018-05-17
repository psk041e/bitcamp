package bitcamp.java106.pms.servlet.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.servlet.InitServlet;

// Dao Spring Bean 컨테이너에 들어있다.
// Servlet 
@WebServlet("/board/add")
public class BoardAddSerlvet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    BoardDao boardDao;
    
    @Override
    public void init() throws ServletException {
        // 스프링 IoC 컨테이너에서 서블릿 객체를 관리하는 것이 아니기 때문에
        // 스프링 IoC 컨테이너에 들어있는 DAO 객체를 자동으로 주입 받을 수 없다.
        // 서블릿을 생성할 때 스프링 IoC 컨테이너에서 직접 DAO를 꺼내 와야 한다.
        //
        // 자동주입을 시키지 못한다.
        // 매번 서블릿을 실행할 때 마다, 필요할 때마다 가져오거나, 한번 init에서 가져와야 한다.
        boardDao = InitServlet.getApplicationContext().getBean(BoardDao.class); 
        // doget이나 dopost 가 호출 되기 전에 한 번은 호출된다.
    }
    
    // get 방식의 문제는 웹브라우저 history 에 다 남아있다.
    // 일반적으로는 게시글을 많이 안쓰지만 블로그나 회사메일에서 안에 들어가는 내용이 8KB가 넘어가는 일이 허다하다.
    // 첨부파일은 get방식으로는 불가능하다.
    // add, update ==> POST 요청으로 데이터가 넘어온다. 라고 생각하면 된다.
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        // 클라이언트가 보낸 데이터가 어떤 문자표를 사용해서 작성한지 알아야만
        // String 객체(UTF-16)로 값을 꺼낼 수 있다.
        request.setCharacterEncoding("UTF-8");
        
        Board board = new Board();
        board.setTitle(request.getParameter("title"));
        board.setContent(request.getParameter("content"));
        board.setCreatedDate(new Date(System.currentTimeMillis()));
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        
        // 지정된 시간이 경과하면 특정 서블릿을 요청하도록 태그를 삽입
        // => 웹브라우저는 meta 태그의 내용대로 동작한다.
        // equipment
        // 메타테그를 심어놓으면 웹 브라우저는 이 메타태그대로 동작한다.
        // Refresh: 메타 태그가 특정 행동을 하게끔 만든다.
        out.println("<meta http-equiv='Refresh' content='1;url=list'>");
        
        out.println("<title>게시물 목록</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>게시물 등록</h1>");
        
        try {
            boardDao.insert(board);
            out.println("<p>등록 성공!</p>");
        } catch (Exception e) {
            out.println("<p>등록 실패!</p>");
            e.printStackTrace(out);
        }
        // 생략해도 실행되지만 생략하지 말아라! 반드시 써준다.
        out.println("</body>");
        out.println("</html>");
    }

}

//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - BoardController에서 add() 메서드를 추출하여 클래스로 정의. 
