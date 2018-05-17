// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.servlet.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.dao.TeamMemberDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.servlet.InitServlet;

@SuppressWarnings("serial")
@WebServlet("/task/add")
public class TaskAddServlet extends HttpServlet {
    
    TeamDao teamDao;
    TaskDao taskDao;
    TeamMemberDao teamMemberDao;
    
    @Override
    public void init() throws ServletException {
        teamDao = InitServlet.getApplicationContext().getBean(TeamDao.class);
        taskDao = InitServlet.getApplicationContext().getBean(TaskDao.class);
        teamMemberDao = InitServlet.getApplicationContext().getBean(TeamMemberDao.class);
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        String teamName = request.getParameter("teamName");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>작업 등록</title>");
        out.println("</head>");
        out.println("<body>");
        
        out.printf("<h1>'%s' 팀의 작업 등록</h1>", teamName);
        
        try { // 존재하는 팀인지 먼저 확인한다.
            Team team = teamDao.selectOne(teamName);
            if (team == null) {
                throw new Exception(teamName + " 팀은 존재하지 않습니다.\n");
            }
            
            List<Member> members = teamMemberDao.selectListWithEmail(teamName);
            
            out.println("<form action='add' method='post'>");
            out.printf("<input type='hidden' name='teamName' value='%s'>\n", teamName); 
            // 눈에는 보이지 않지만 서버에 보내기 위해 input 태그에 넣어주는 것이다.
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("   <th>작업명</th><td><input type='text' name='title'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("   <th>시작일</th><td><input type='date' name='startDate'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("   <th>종료일</th><td><input type='date' name='endDate'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<th>작업자</th>");
            out.println("   <td>");
            out.println("       <select name='memberId'>");
            out.println("           <option value=''></option>");
            
            for (Member member : members) {
                out.printf("           <option>%s</option>\n", member.getId());
            }
            
            out.println("       </select>");
            out.println("   </td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<button>등록</button>");
            out.println("</form>");
            
        } catch (Exception e) {
            out.printf("<p>%s</p>\n", e.getMessage());
            e.printStackTrace(out);
        }
        out.println("</body>");
        out.println("</html>");
    }
    
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String teamName = request.getParameter("teamName");
        
        Task task = new Task();
        task.setTitle(request.getParameter("title"));
        task.setStartDate(Date.valueOf(request.getParameter("startDate")));
        task.setEndDate(Date.valueOf(request.getParameter("endDate")));
        task.setTeam(new Team().setName(request.getParameter("teamName")));
        task.setWorker(new Member().setId(request.getParameter("memberId")));
        task.setWorker(new Member().setId(request.getParameter("memberId")));
        // 빈문자열이 들어간다면 데이터베이스에서 그것을 넣을지 말지 결정해 줄것이다.
        // -> TaskMapper.xml의 insert의 when조건절 확인
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.printf("<meta http-equiv='Refresh' content='1;url=list?teamName=%s'>\n", 
                task.getTeam().getName()); // taskList로 갈 때는 어느 팀의 목록인지 알려줘야 한다.
                                            // \n는 페이지소스보기에서 소스를 볼 때 확인하기가 쉽기 때문에 붙여준다.
        out.println("<title>작업 등록</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>작업 등록 결과</h1>");
        
        try {
            Team team = teamDao.selectOne(task.getTeam().getName());
         // 직접 입력하지 않고 선택하는 경우에는 아래와 같은 코드를 삽입하지 않아도 된다.
            if (team == null) {
                throw new Exception(task.getTeam().getName() + " 팀은 존재하지 않습니다.\n");
            }
            
            if (task.getWorker().getId().length() > 0 &&
                    !teamMemberDao.isExist( 
                    task.getTeam().getName(), task.getWorker().getId())) { // 팀에 멤버가  
                throw new Exception(task.getWorker().getId() + "는 이 팀의 회원이 아닙니다.\n");
            }
            // 그 팀에 소속되어있는 멤버가 있을 때만 작업을 등록해야 한다.
            // id가 제대로 넘어 왔을 때 그 팀의 멤버인지 확인하는 것이다.
            // 일단 id의 문자열이 빈문자열이 아니라면 한번더 검사한다. 그것이 팀멤버가 맞는지
            // 혹시나 임의로 값을 막 집어넣을때를 대비해서 조건을 넣어준다.
            // 선택사항이다. 절대 클라이언트에서 임의로 해킹할 경우를 가정하고 넣어주는 코드이다.
            // 넘어오는 값들을 다 검증하는것이다.
            // 만약 실무에서 이런 선택사항들을 넣지말라고 한다면 그것은 해커가 해킹할것을 고려하지 않는다는 것이다.
            // 어떤 정책을 가지느냐에 따라서 달라질것이다.
            
            taskDao.insert(task);
            out.println("<p>등록 성공!</p>");
        } catch (Exception e) {
            out.printf("<p>%s</p>\n", e.getMessage());
            e.printStackTrace();
        }
        out.println("</body>");
        out.println("</html>");
    }

}

//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TaskController에서 add() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TaskDao를 사용한다.
//ver 17 - 클래스 생성
