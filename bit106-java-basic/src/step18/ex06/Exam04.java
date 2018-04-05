// 응용 - 특정 패키지 및 그 하위 패키지의 .class 파일의 목록을 알아내기
package step18.ex06;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// 1) 클래스를 찾는 코드를 별도의 메서드로 분리한다.
public class Exam04 {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL url = classLoader.getResource("step18");
        
        List<File> files = findClasses(new File(url.getPath()));
        
        for (File f : files) {
            System.out.println(f.getCanonicalPath());
        }
    }
    
    static List<File> findClasses(File dir) throws Exception { // 리스트의 종류를 리턴할 수 있다 -> 훨씬 더 유연하다.
        File[] files = dir.listFiles(new FileFilter() {
            
            public boolean accept(File file) { // 이름이 없는 클래스는 1,2,3... 번호가 붙는다.(익명 클래스)
                if (file.isDirectory() || 
                        (file.getName().endsWith(".class") && 
                        !file.getName().contains("$"))) 
                    return true;
                return false;
            }
        });
        
        ArrayList<File> list = new ArrayList<>();
        for (File f : files) {
            if (f.isDirectory()) {
                list.addAll(findClasses(f)); 
            } else {
                list.add(f);
            }
        }
        return list;
    }
}
