// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.servlet.teammember;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/team/member/delete")
public class TeamMemberDeleteServlet extends HttpServlet {
    
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

        request.setCharacterEncoding("UTF-8"); // get요청으로 들어온 것은 상관없지만 그래도 써준다.
        String teamName = request.getParameter("teamName");
        String memberId = request.getParameter("memberId");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.printf("<meta http-equiv='Refresh' content='1;url=../view?name=%s'>\n", // 삭제한 후 원래의 teamviwe로 돌아간다.
                teamName); 
        out.println("<title>팀 회원 삭제</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>팀 회원 삭제 결과</h1>");
        
        try {
            int count = teamMemberDao.delete(teamName, memberId);
            if (count == 0) {
                out.println("<p>해당 팀원이 존재하지 않습니다.</p>");
            } else {
                out.println("<p>팀에서 회원을 삭제하였습니다.</p>");
            }
        } catch (Exception e) {
            out.println("<p>팀 회원 삭제 실패!</p>");
            e.printStackTrace(out);
        }
        out.println("</body>");
        out.println("</html>");
    }
}

//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TeamMemberController에서 delete() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 18 - ArrayList가 적용된 TeamMemberDao를 사용한다.
//ver 17 - TeamMemberDao 클래스를 사용하여 팀 멤버의 아이디를 관리한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - 팀 멤버를 등록, 조회, 삭제할 수 있는 기능 추가. 
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.