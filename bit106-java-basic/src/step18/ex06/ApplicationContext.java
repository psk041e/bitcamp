// 지정한 패키지의 클래스 정보를 로딩하여 보관하는 역할
package step18.ex06;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext {
    
    public List<Class> classes;
    public ApplicationContext(String packagename) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        
        // 패키지 이름으로 실제 경로를 찾을 때
        // 패키지에 있는 .을 파일 경로인 /로 바꿔야 한다.
        URL url = classLoader.getResource(packagename.replace('.', '/'));
        
        this.classes = findClasses(new File(url.getPath()), packagename);
        
    }
    
    private List<Class> findClasses(File dir, String packagename) throws Exception { 
        File[] files = dir.listFiles(new FileFilter() {
            
            public boolean accept(File file) { // 이름이 없는 클래스는 1,2,3... 번호가 붙는다.(익명 클래스)
                if (file.isDirectory() || 
                        (file.getName().endsWith(".class") && 
                        !file.getName().contains("$"))) 
                    return true;
                return false;
            }
        });
        
        ArrayList<Class> list = new ArrayList<>();
        for (File f : files) {
            if (f.isDirectory()) {
                list.addAll(findClasses(f, packagename + "." + f.getName()));
                //list.addAll(findClasses(f)); 
            } else {
                //list.add(f);
                String classname = packagename  + "." + f.getName();
                // classneme = "step18.ex01.App.class"
                // 전체 문자열 길이 : classname.length();
                // .class 의 인덱스  전체 문자열 길이 -6
                Class c = Class.forName(classname.substring(0, classname.length() - 6));
            }
        }
        return list;
    }
}
