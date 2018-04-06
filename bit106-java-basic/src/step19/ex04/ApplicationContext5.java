// 중첩 클래스를 제외한 .class 파일만 추출한다.
package step19.ex04;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext5 { 
    private ArrayList<String> list = new ArrayList<>(); 
    
    public ApplicationContext5(String packageName) {
        String path = packageName.replace(".", "/");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader(); // factory method(디자인 패턴)
        URL url = classLoader.getResource(path);
        
        File dir = new File(url.getPath());
        
        if (dir.isDirectory())
            return;
        findFiles(dir, packageName);
    }
    
    // 파일 경로에서 패키지명과 클래스명을 추출할 수 없다. 
    // -> 어떤것부터 이 패키지인지 알 수 없다.
    // 그래서 파일을 찾을 때 패키지 이름을 따로 관리해야 한다.
    public void findFiles(File dir, String packageName) { 
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
                findFiles(f, packageName + "." + f.getName()); // 재귀호출 -> ★코드가  복제된다고 생각해라★
            } else {
                String classname = f.getName();
                this.list.add(packageName + "." + 
                        classname.substring(0, classname.length() - 6)); // .class를 날려버리고 붙인다.
            }
        } 
    }     // 디렉토리에서 목록을 가져와 arraylist에 담는다
          // 배열보다 넣고 빼기가 편하기 때문에 arraylist에 담는다.
    
    public List<String> getClassname() {
        return this.list;
    }
    
    
    
}
