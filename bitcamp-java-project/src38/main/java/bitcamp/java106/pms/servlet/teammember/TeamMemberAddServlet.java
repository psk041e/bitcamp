// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.servlet.teammember;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/team/member/add")
public class TeamMemberAddServlet extends HttpServlet {
    
    TeamDao teamDao;
    MemberDao memberDao;
    TeamMemberDao teamMemberDao;
    
    @Override
    public void init() throws ServletException {
        teamDao = InitServlet.getApplicationContext().getBean(TeamDao.class);
        memberDao = InitServlet.getApplicationContext().getBean(MemberDao.class); 
        teamMemberDao = InitServlet.getApplicationContext().getBean(TeamMemberDao.class); 
    }
    
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String teamName = request.getParameter("teamName");
        String memberId = request.getParameter("memberId");
        

        try {
            Team team = teamDao.selectOne(teamName);
            if (team == null) {
                throw new Exception(teamName + " 팀은 존재하지 않습니다.");
            }
            Member member = memberDao.selectOne(memberId);
            if (member == null) {
                throw new Exception(memberId + " 회원은 없습니다.");
            }
            if (teamMemberDao.isExist(teamName, memberId)) {
                throw new Exception("이미 등록된 회원입니다.");
            }
            teamMemberDao.insert(teamName, memberId);
            
            response.sendRedirect("../view?name=" + 
                    URLEncoder.encode(teamName, "UTF-8"));
            
            
        } catch (Exception e) {
            RequestDispatcher 요청배달자 = request.getRequestDispatcher("/error");
            request.setAttribute("error", e); 
            request.setAttribute("title", "팀 회원 등록 실패!");
            // 다른 서블릿으로 실행을 위임할 때,
            // 이전까지 버퍼로 출력한 데이터는 버린다.
            요청배달자.forward(request, response);
        }
    }
}

//ver 39 - forward 적용
//ver 38 - redirect 적용
//ver 37 - 컨트롤러를 서블릿으로 변경
//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TeamMemberController에서 add() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 18 - ArrayList가 적용된 TeamMemberDao를 사용한다.
//ver 17 - TeamMemberDao 클래스를 사용하여 팀 멤버의 아이디를 관리한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - 팀 멤버를 등록, 조회, 삭제할 수 있는 기능 추가. 
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.