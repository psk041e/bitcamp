package bitcamp.java106.pms.servlet.team;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/team/view")
public class TeamViewServlet extends HttpServlet {

    TeamDao teamDao;
    TeamMemberDao teamMemberDao;
    
    @Override
    public void init() throws ServletException {
        teamDao = InitServlet.getApplicationContext().getBean(TeamDao.class);
        teamMemberDao = InitServlet.getApplicationContext().getBean(TeamMemberDao.class);
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>팀 보기</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>팀 보기</h1>");
        
        try {
            Team team = teamDao.selectOne(name);
    
            if (team == null) {
                throw new Exception("유효하지 않은 팀입니다.");
            }
            
            out.println("<form action='update' method='post'>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.printf("    <th>팀명</th><td><input type=\"text\" name=\"name\" value='%s' readonly></td>\n",
                    team.getName());
            out.println("</tr>");
            out.println("<tr>");
            out.println("    <th>설명</th><td><textarea name=\"description\" ");
            out.printf("        rows=\"6\" cols=\"60\">%s</textarea></td>\n",
                    team.getDescription());
            out.println("</tr>");
            out.println("<tr>");
            out.printf("    <th>최대인원</th><td><input type=\"number\" name=\"maxQty\" value='%d'></td>\n",
                    team.getMaxQty());
            out.println("</tr>");
            out.println("<tr>");
            out.printf("    <th>시작일</th><td><input type=\"date\" name=\"startDate\" value='%s'></td>\n", 
                    team.getStartDate());
            out.println("</tr>");
            out.println("<tr>");
            out.printf("    <th>종료일</th><td><input type=\"date\" name=\"endDate\" value='%s'></td>\n", 
                    team.getEndDate());
            out.println("</tr>");
            out.println("</table>");
            out.println("<p>");
            out.println("<a href='list'>목록</a>");
            out.println("<button>변경</button>");
            out.printf("<a href='delete?name=%s'>삭제</a>\n", name);
            out.printf("<a href='../task/list?teamName=%s'>작업목록</a>\n", name); 
            // 상대경로, 현재 위치가 team방이기 때문에 그 상위의 방으로 가서 task로 들어가라는 뜻이다.
            out.println("</p>");
            out.println("</form>");
            
            List<Member> members = teamMemberDao.selectListWithEmail(name);
            
            out.println("<h2>회원 목록</h2>");
            out.println("<form action='member/add' method='post'>");
            // 'http://localhost:8888/bitcamp-java-project/team/member/add'
            // 현재 team까지 똑같기 때문에 그부분까지 생략 가능하다.
            // 입력 폼으로 보낼때는 보통get으로 보내지 않는다.
            out.println("<input type='text' name='memberId' placeholder='회원아이디'>");
            // placeholder: 회색으로 된 안내문구가 출력되고 입력할때 없어진다.
            out.printf("<input type='hidden' name='teamName' value='%s'>\n", name); 
            // 파라미터로 이미 받았기 때문에 변수로 넣어준다.
            // 눈에는 보이지 않지만 teamName이 넘어간다.
            // 입력폼에 있는 값을 서버로 넘기고 싶은데 보일 필요가 없을 때 사용한다.
            out.println("<button>추가</button>");
            out.println("</form>");
            out.println("<table border='1'>");
            out.println("<tr><th>아이디</th><th>이메일</th><th> </th></tr>");
            for (Member member : members) {
                out.printf("<tr>"
                        + "<td>%s</td>"
                        + "<td>%s</td>"
                        + "<td><a href='member/delete?teamName=%s&memberId=%s'>삭제</a></td>"
                        + "</tr>\n",
                        member.getId(), 
                        member.getEmail(),
                        name,
                        member.getId()); 
                // 기존에 selectList는 멤버 아이디 목록을 List에 담아서 리턴한다.
                // selectList를 뜯어고치게 되면 다른 화면에서 이미 저 메서드를 쓰고 있기 때문에 다른 프로그램도 모두 뜯어고쳐야 한다.
                // 그래서 기존의 selectList는 사용할수 없다.
                // 우리는 id와 email두가지가 필요하기 때문이다.
                //
                // 현업에서 기존에 있는 메서드가 내가 원하는 값을 가지지 않는다고 해서 그 메서드를 뜯어고치면
                // 그 메서드를 사용하는 프로그램을 모두 뜯어고쳐야 한다.
                // 따라서 새로운 메서드를 만들어야 한다. 그러나 그동안 그렇게 해온 메서드들, 쓰레기들이 엄청 많을 것이다.
                // 하지만 어쩔수 없이 새로운 메서드를 만들어야 한다.
                // 5~7년이 넘어가면 어차피 리뉴얼을 한다. 리뉴얼을 하지 않으면 유지보수하는데 더 큰 고통이 따른다.
                
                // 여기서 팀을 삭제하면 처음부터 멤버를 다시 그려야 한다.
                // 그래서 Ajax가 나타난 것이다. Ajax는 7,8년 전부터 잘 구현하고 있다.
                // Ajax는 javascript이다. 이것은 삭제를 하면 처음부터 refresh하지 않고 그 부분만 삭제하도록 해준다.
                // javascript를 쓰지 않으면 현대적인 기능을 사용하지 못한다.
            }
            out.println("</table>");
               
        } catch (Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e); 
            request.setAttribute("title", "팀 상세조회 실패!");
            // 다른 서블릿으로 실행을 위임할 때,
            // 이전까지 버퍼로 출력한 데이터는 버린다.
            요청배달자.forward(request, response);
        }
        out.println("</body>");
        out.println("</html>");
    }
}

//ver 39 - forward 적용
//ver 37 - 컨트롤러를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TeamController에서 view() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TeamDao를 사용한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - TeamDao를 생성자에서 주입 받도록 변경.
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.