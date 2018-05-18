// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.servlet.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/board/view")
public class BoardViewServlet extends HttpServlet {
    BoardDao boardDao;
    
    @Override
    public void init() throws ServletException {
        boardDao = InitServlet.getApplicationContext().getBean(BoardDao.class); 
    }
    // view는 값을 가져오기 때문에 doGet을 사용한다.
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        // request.setCharacterEncoding("UTF-8");
        int no = Integer.parseInt(request.getParameter("no")); // 번호는 한글과 상관없기 때문에 
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>게시물 보기</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>게시물 보기</h1>");
        out.println("<form action='update' method='post'>"); 
        // update서블릿에게 post요청하라!
        // 보이지는 않지만 테이블 바깥쪽이 입력 폼이 된 것이다.
        // form 이라는 태그 안에 있어야 버튼이 어떤 일을 할것이다.
        // get으로 하면 데이터가 어떤것이 날아가는지 볼수 있다.
        // 입력 상자에 name을 부여하지 않으면 서버에 보내지 않는다.
        // update앞은 현재 view와 같은 주소를 가지기 때문에 생략한 것이다.
        
        try { // pre: 입력한 그대로 텍스트로 출력한다.
            Board board = boardDao.selectOne(no);
            if (board == null) {
                throw new Exception("유효하지 않은 게시물 번호입니다.");
            }
            out.println("<table border='1'>");
            out.println("<tr><th>번호</th>");
            out.printf("   <td><input type='text' name='no' value='%d' readonly></td></tr>", 
                    board.getNo()); // readonly: 이 태그안에 값을 쓰지 못하도록 한다.
                                    // readonly와 같은 속성은 값이 존재하지 않고 그 자체로만 사용한다.
            out.println("<tr><th>제목</th>");
            out.printf("   <td><input type='text' name='title' value='%s'></td></tr>", 
                    board.getTitle());
            out.println("<tr><th>내용</th>");
            out.printf("   <td><textarea rows='10' name='content' cols='60'>%s</textarea></td></tr>", 
                    board.getContent());
            out.printf("<tr><th>등록일</th><td>%s</td></tr>", 
                    board.getCreatedDate()); // 등록일은 자동으로 들어가기 때문에 name을 부여하지 않아도 된다.
            out.println("</table>");
            // input box는 inline, 한줄 박스이다.
            // textarea는 여러줄 박스이다. 보통 이것은 태그 안에 내용을 넣어준다.
            // 이것은 암기할 사항이다.
            
        } catch (Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e); 
            request.setAttribute("title", "게시물 상세조회 실패!");
            // 다른 서블릿으로 실행을 위임할 때,
            // 이전까지 버퍼로 출력한 데이터는 버린다.
            요청배달자.forward(request, response);
        }
        out.println("<p>");
        out.println("<a href='list'>목록</a>");
        out.println("<button>변경</button>");
        out.printf("<a href='delete?no=%d'>삭제</a>", no);
        out.println("</p>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}

//ver 37 - BoardViewController를 서블릿으로 변경
//         HTML로 출력
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - BoardController에서 view() 메서드를 추출하여 클래스로 정의.
