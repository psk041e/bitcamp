// 객체를 저장할 때 클래스 이름으로 저장하고, 클래스 이름으로 꺼낼 수 있다.
package step19.ex07;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ApplicationContext8 { 
    // 객체를 저장할 수 있도록  Map 을 사용한다.
    // 객체를 꺼내기 쉽도록 이름으로 저장하겠다.
    private HashMap<String, Object> objPool = new HashMap<>(); // objPool - 객체를 모아둠
    
    public ApplicationContext8(String packageName) throws Exception {
        String path = packageName.replace(".", "/");
        ClassLoader classLoader = ClassLoader.getSystemClassLoader(); // factory method(디자인 패턴)
        URL url = classLoader.getResource(path);
        
        File dir = new File(url.getPath());
        
        if (dir.isDirectory())
            return;
        findClasses(dir, packageName);
    }
    
    public void findClasses(File dir, String packageName) throws Exception { 
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
                findClasses(f, packageName + "." + f.getName()); // 재귀호출 -> ★코드가  복제된다고 생각해라★
                continue; // 들여쓰기를 줄여준다.
            }
            String classname = f.getName();
            Class clazz = Class.forName(packageName + "." +
                    packageName + "." + 
                    classname.substring(0, classname.length() - 6)); // 이름을 저장하는 대신 클래스 객체를 저장했다.
            Object obj = createObject(clazz);
            if (obj != null)
                this.objPool.put(clazz.getName(), obj); // 객체를 저장하는데 해당 클래스 이름으로 저장하겠다.
        } 
    }     
    
    private Object createObject(Class clazz) {
        try { // 굳이 리턴값을 체크할 필요가 없다.
            clazz.getConstructor();
            return clazz.newInstance();
            // 리턴값으로 null을 알려주기에는 불안하다.
            // 기본 생성자가 없는 경우에 대해서 대비를 제대로 하기 위해
            // -> 생성자가 없으면 null을 리턴하는 것이 아니라 예외를 발생시킨다.
        } catch (Exception e) { // 에러가 뜬다면 null을 전달한다.
            return null;
        }
    }
    
    public Object getBean(String name) {
        return objPool.get(name);
    }
    
    
    
}
