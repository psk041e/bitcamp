// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.task;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.Iterator;
import java.util.Scanner;

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
import bitcamp.java106.pms.util.Console;

@Component("/task/list")
public class TaskListController implements Controller {
    TeamDao teamDao;
    TaskDao taskDao;
    
    public TaskListController(TeamDao teamDao, TaskDao taskDao) {
        this.teamDao = teamDao;
        this.taskDao = taskDao;
    }
    
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        String teamName = request.getParameter("teamName");
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            out.printf("'%s' 팀은 존재하지 않습니다.\n", teamName);
            return;
        }
        
        Iterator<Task> iterator = taskDao.list(teamName);
        
        while (iterator.hasNext()) {
            Task task = iterator.next();
            out.printf("%d,%s,%s,%s,%s\n", 
                    task.getNo(), task.getTitle(), 
                    task.getStartDate(), task.getEndDate(),
                    (task.getWorker() == null) ? 
                            "-" : task.getWorker().getId());
        }
    }
    
}

