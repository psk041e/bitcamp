// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.task;

import java.io.PrintWriter;
import java.sql.Date;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/task/add")
public class TaskAddController implements Controller {
    TeamDao teamDao;
    TaskDao taskDao;
    MemberDao memberDao;
    TeamMemberDao teamMemberDao;
    
    public TaskAddController(TeamDao teamDao, TaskDao taskDao,
            TeamMemberDao teamMemberDao, MemberDao memberDao) {
        this.teamDao = teamDao;
        this.taskDao = taskDao;
        this.teamMemberDao = teamMemberDao;
        this.memberDao = memberDao;
    }
    
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        String teamName = request.getParameter("teamName");
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            out.printf("'%s' 팀은 존재하지 않습니다.\n", teamName);
            return;
        }
        
        Task task = new Task(team);
        task.setTitle(request.getParameter("title"));
        task.setStartDate(Date.valueOf(request.getParameter("startDate")));
        task.setEndDate(Date.valueOf(request.getParameter("endDate")));
        task.setWorker(this.memberDao.get(request.getParameter("memberId")));
        
        taskDao.insert(task);
        out.println("등록 성공!");
    }

}
