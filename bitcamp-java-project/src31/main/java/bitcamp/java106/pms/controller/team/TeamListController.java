// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.team;

import java.io.PrintWriter;
import java.util.List;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/team/list")
public class TeamListController implements Controller {

    TeamDao teamDao;
    
    public TeamListController(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    @Override
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        
        try {
            List<Team> list = teamDao.selectList();
            for (Team team : list) {
                out.printf("%s, %d, %s ~ %s\n", 
                        team.getName(), team.getMaxQty(), 
                        team.getStartDate(), team.getEndDate());
            }
        } catch (Exception e) {
            out.println("목록 가져오기 실패!");
            e.printStackTrace(out);
        }
    }
}

//ver 31 - JDBC API가 적용된 DAO 사용
//ver 28 - 네트워크 버전으로 변경
//ver 26 - TeamController에서 list() 메서드를 추출하여 클래스로 정의.
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - TaskDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 18 - ArrayList가 적용된 TeamDao를 사용한다.
//ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 15 - TeamDao를 생성자에서 주입 받도록 변경.
// ver 14 - TeamDao를 사용하여 팀 데이터를 관리한다.
// ver 13 - 시작일, 종료일을 문자열로 입력 받아 Date 객체로 변환하여 저장.