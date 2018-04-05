// 응용 - 6) 지정된 패키지 또는 하위 패키지에 있는 클래스들의 정보를 로딩하는
//          기능을 별도의 클래스로 분리한다.
package step18.ex06;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class Exam06 {
    public static void main(String[] args) throws Exception {
        ApplicationContext appContext = new ApplicationContext("step18");
        List<Class> classes = appContext.classes;
        for (Class clazz: classes) {
            System.out.println(clazz.getName());
        }
    }
}
