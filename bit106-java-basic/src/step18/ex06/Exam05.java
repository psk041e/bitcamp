// 응용 - 5) 파일 정보 대신 클래스 정보를 목록에 저장한다.
package step18.ex06;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// => 
public class Exam05 {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL url = classLoader.getResource("step18");
        
        List<Class> classes = findClasses(new File(url.getPath()), "step18");
        
        for (Class clazz: classes) {
            System.out.println(clazz.getName());
        }
    }
    
    static List<Class> findClasses(File dir, String packagename) throws Exception { 
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
