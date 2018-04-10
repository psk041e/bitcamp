// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller.classroom;

import java.sql.Date;
import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.util.Console;

@Component("classroom/list")
public class ClassroomListController implements Controller {
    Scanner keyScan;
    ClassroomDao classroomDao;
    
    public ClassroomListController(Scanner scanner, ClassroomDao classroomDao) {
        this.keyScan = scanner;
        this.classroomDao = classroomDao;
    }
    
    public void service(String menu, String option) {
        System.out.println("[수업 목록]");
        Iterator<Classroom> iterator = classroomDao.list();
        while (iterator.hasNext()) {
            Classroom classroom = iterator.next();
            System.out.printf("%d, %s, %s ~ %s, %s\n",
                classroom.getNo(), classroom.getTitle(), 
                classroom.getStartDate(), classroom.getEndDate(),
                classroom.getRoom());
        }
    }
}

//ver 23 - @Component 애노테이션을 붙인다. ClassroomDao를 받도록 생성자 변경.
//ver 22 - ClassroomDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 20 - 클래스 추가
