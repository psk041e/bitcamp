// 중첩 클래스를 제외한 .class 파일만 추출한다.
package step19.ex03;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext4 { 
    private ArrayList<File> list = new ArrayList<>(); 
    
    public ApplicationContext4(String packageName) {
        String path = packageName.replace(".", "/");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader(); // factory method(디자인 패턴)
        URL url = classLoader.getResource(path);
        
        File dir = new File(url.getPath());
        
        if (dir.isDirectory())
            return;
        findFiles(dir);
    }
    
    public void findFiles(File dir) { // 파일 객체를 담은 리스트 리턴
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                if (pathname.isDirectory() || // 디렉토리이거나
                        (pathname.getName().endsWith(".class") && // .class 파일인 경우
                        !pathname.getName().contains("$"))) { // 단 중첩 클래스는 제외
                    return true;
                }
                return false;
            }
        }); 
        for (File f : files) {
            if (f.isDirectory()) {
                findFiles(f); // 재귀호출 -> ★코드가  복제된다고 생각해라★
            } else {
                this.list.add(f);
            }
        } 
    }     // 디렉토리에서 목록을 가져와 arraylist에 담는다
          // 배열보다 넣고 빼기가 편하기 때문에 arraylist에 담는다.
    
    public List<File> getFiles() {
        return this.list;
    }
    
    
    
}
