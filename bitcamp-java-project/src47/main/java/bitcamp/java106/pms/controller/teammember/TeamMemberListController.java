package bitcamp.java106.pms.controller.teammember;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.web.RequestMapping;

@Component("/team/member/list")
public class TeamMemberListController {

    TeamMemberDao teamMemberDao;
    
    public TeamMemberListController(TeamMemberDao teamMemberDao) {
        this.teamMemberDao = teamMemberDao;
    }
    
    @RequestMapping
    public String list(
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

        String name = request.getParameter("name");

            List<Member> members = teamMemberDao.selectListWithEmail(name);
            request.setAttribute("members", members);
            return "/team/member/list.jsp";
    }
}

//ver 45 - 프론트 컨트롤러 적용
//ver 42 - JSP 적용
//ver 39 - forward 적용
