// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.team;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;
import bitcamp.java106.pms.util.Console;

@Component("/team/update")
public class TeamUpdateController implements Controller {
    TeamDao teamDao;
    
    public TeamUpdateController(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        
        Team team = teamDao.get(name);

        if (team == null) {
            out.println("해당 이름의 팀이 없습니다.");
        } else {
            Team updateTeam = new Team();
            updateTeam.setName(request.getParameter("name"));
            updateTeam.setDescription(request.getParameter("description"));
            updateTeam.setMaxQty(Integer.parseInt(request.getParameter("maxQty")));
            updateTeam.setStartDate(Date.valueOf(request.getParameter("startDate")));
            updateTeam.setEndDate(Date.valueOf(request.getParameter("endDate")));
            
            int index = teamDao.indexOf(updateTeam.getName());
            teamDao.update(index, updateTeam);
            out.println("변경하였습니다.");
        }
    }
}

