// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.task;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Component;

import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/task/list")
public class TaskListController implements Controller {
    
    TeamDao teamDao;
    TaskDao taskDao;
    
    public TaskListController(TeamDao teamDao, TaskDao taskDao) {
        this.teamDao = teamDao;
        this.taskDao = taskDao;
    }
    
    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        String teamName = request.getParameter("teamName");
        
        try {
            Team team = teamDao.selectOne(teamName);
            if (team == null) {
                out.printf("'%s' 팀은 존재하지 않습니다.\n", teamName);
                return;
            }
            List<Task> list = taskDao.selectList(team.getName());
            for (Task task : list) {
                out.printf("%d,%s,%s,%s,%s\n", 
                        task.getNo(), task.getTitle(), 
                        task.getStartDate(), task.getEndDate(),
                        (task.getWorker() == null) ? 
                                "-" : task.getWorker().getId());
            }
        } catch (Exception e) {
            out.println("목록 가져오기 실패!");
            e.printStackTrace(out);
        }
    }

}

//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TaskController에서 list() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성
