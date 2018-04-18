// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.team;

import java.io.PrintWriter;
import java.sql.Date;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/team/add")
public class TeamAddController implements Controller {
    TeamDao teamDao;
    
    public TeamAddController(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();

        Team team = new Team();
        team.setName(request.getParameter("name"));
        team.setDescription(request.getParameter("description"));
        team.setMaxQty(Integer.parseInt(request.getParameter("maxQty")));
        team.setStartDate(Date.valueOf(request.getParameter("startDate")));
        team.setEndDate(Date.valueOf(request.getParameter("endDate")));
        teamDao.insert(team);
        
        out.println("등록 성공!");
    }
}

