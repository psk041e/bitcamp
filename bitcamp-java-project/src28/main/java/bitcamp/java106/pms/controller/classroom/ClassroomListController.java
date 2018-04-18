// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.classroom;

import java.io.PrintWriter;
import java.util.Iterator;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.server.ServerRequest;
import bitcamp.java106.pms.server.ServerResponse;

@Component("/classroom/list")
public class ClassroomListController implements Controller {
    ClassroomDao classroomDao;
    
    public ClassroomListController(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }
    
    public void service(ServerRequest request, ServerResponse response) {
        PrintWriter out = response.getWriter();
        Iterator<Classroom> iterator = classroomDao.list();
        while (iterator.hasNext()) {
            Classroom classroom = iterator.next();
            out.printf("%d, %s, %s ~ %s, %s\n",
                classroom.getNo(), classroom.getTitle(), 
                classroom.getStartDate(), classroom.getEndDate(),
                classroom.getRoom());
        }
    }
}

//ver 23 - @Component 애노테이션을 붙인다. ClassroomDao를 받도록 생성자 변경.
//ver 22 - ClassroomDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 20 - 클래스 추가
