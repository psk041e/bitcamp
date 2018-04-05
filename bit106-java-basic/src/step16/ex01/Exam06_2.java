// 디렉토리에 들어있는 파일(디렉토리) 목록을 꺼낼 때 필터 적용하기
package step16.ex01;

import java.io.File;
import java.io.FilenameFilter;

public class Exam06_2 {
    // 남이 만든 인터페이스 규칙에 따라서 클래스를 만든다.
    // 인터페이스(FilenameFilter)에 대해 호출 당하는 클래스를 만든다. -> 사용되는 클래스(callee) -> File(caller)가 사용한다.
    static class JavaFilter implements FilenameFilter {
        public boolean accept(File dir, String name) { // 어차피 메서드 이름을 틀리면 에러가 나므로 @ Override를 지운다.
            if (name.endsWith(".java"))
                return true; // 조회 결과에 포함시켜라!
            return false; // 조회 결과에서 제외하라!
        }
        // 필터의 메서드는 목록에 있는 갯수만큼 호출된다.
    }
    
    public static void main(String[] args) throws Exception {
        File dir = new File(".");

        // => 확장자가 .java 인 파일의 이름만 추출하기
        // 1) 필터 준비
        JavaFilter javaFilter = new JavaFilter();
        
        // 2) 필터를 사용하여 디렉토리의 목록을 가져오기
        File[] files = dir.listFiles(javaFilter); // 파일의 상세정보를 알고싶을때 listFiles()로 아예 File[]배열로 받는다.
        
        for (File file : files) {
            System.out.printf("%s %12d %30s\n", 
                    file.isDirectory() ? "d" : "-", // 디렉토리이면 "d"를, 아니면(파일이면) "-"를 앞에 붙여줘라
                    file.length(),
                    file.getName());
        }
        
    }
}
