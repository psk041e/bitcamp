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

@Component("classroom/delete")
public class ClassroomDeleteController implements Controller {
    Scanner keyScan;
    ClassroomDao classroomDao;
    
    public ClassroomDeleteController(Scanner scanner, ClassroomDao classroomDao) {
        this.keyScan = scanner;
        this.classroomDao = classroomDao;
    }
    
    public void service(String menu, String option) {
        System.out.println("[수업 정보 삭제]");

        System.out.print("삭제할 수업 번호? ");
        String str = keyScan.nextLine();
        if (str.length() == 0) {
            System.out.println("번호를 입력하시기 바랍니다.");
            return;
        }
        
        int i = Integer.parseInt(str);
        Classroom classroom = classroomDao.get(i);
        
        if (classroom == null) {
            System.out.println("유효하지 않은 게시물 번호입니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                classroomDao.delete(i);
                System.out.println("삭제하였습니다.");
            }
        }
    }

}

//ver 23 - @Component 애노테이션을 붙인다. ClassroomDao를 받도록 생성자 변경.
//ver 22 - ClassroomDao 변경 사항에 맞춰 이 클래스를 변경한다.
//ver 20 - 클래스 추가
