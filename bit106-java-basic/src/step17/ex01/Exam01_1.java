// 클래스의 종류 : 패키지 멤버 클래스 사용
package step17.ex01;

import java.io.File;
import java.io.FilenameFilter;

// 물론 Exam01_1또한 패키지 멤버 클래스이다.
public class Exam01_1 {
        
    public static void main(String[] args) throws Exception {
        File dir = new File(".");

        // 패키지 멤버 클래스의 인스턴스를 생성한다.
        JavaFilter javaFilter = new JavaFilter();
        
        // 패키지 멤버 클래스의 인스턴스를 필터로 사용하여 디렉토리 안의 목록을 추출한다.
        String[] names = dir.list(javaFilter);
        for (String name : names) {
            System.out.println(name);
        }
        
    }
}
