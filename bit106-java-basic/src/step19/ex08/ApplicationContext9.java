// 객체 생성할 때 의존 객체가 필요하다면 의존 객체를 생성하여 자동 주입 시킨다.
package step19.ex08;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ApplicationContext9 { 
    
    private HashMap<String, Object> objPool = new HashMap<>(); // objPool - 객체를 모아둠
    
    public ApplicationContext9(String packageName) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader(); // factory method(디자인 패턴)

        String path = packageName.replace(".", "/");
        URL url = classLoader.getResource(path); // 클래스 로더에서 경로를 알아낸다.
        File dir = new File(url.getPath()); // 알아낸 경로를 가지고 파일 객체를 생성한다. 강사님 소스 참고(더 짧게만듦)
        if (!dir.isDirectory()) // 그 파일이 디렉토리가 아니면 끝내고
            return;
     
        findAndInstantiateClasses(dir, packageName); // 디렉토리라면 클래스를 찾아서 객체를 생성한다.
    }
    
    public void findAndInstantiateClasses(File dir, String packageName) throws Exception { 
        File[] files = dir.listFiles(new FileFilter() { // 디렉토리에서 파일 목록을 꺼낸다. (anonymous class사용)
            public boolean accept(File pathname) { // 이 코드를 한 번 밖에 안쓰는데 확인하려면 별도의 클래스를 찾아봐야 한다.
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
                findAndInstantiateClasses(f, packageName + "." + f.getName()); // 재귀호출 -> ★코드가  복제된다고 생각해라★
                continue; // 들여쓰기를 줄여준다.
            }
         
            String classname = f.getName();
            Class clazz = Class.forName(packageName + "." +
                    packageName + "." + 
                    classname.substring(0, classname.length() - 6)); // 이름을 저장하는 대신 클래스 객체를 저장했다.
            
            // 이미 해당 타입의 객체가 생성되어 있다면 다시 생성하지 않는다.
            if (objPool.get(clazz.getName()) != null)
                continue;
            
            Object obj = createObject(clazz);
            if (obj != null)
                this.objPool.put(clazz.getName(), obj); // 객체를 저장하는데 해당 클래스 이름으로 저장하겠다.
        } 
    }     
    
    private Object createObject(Class clazz) throws Exception {
        try { 
            // 파라미터가 없는 기본 생성자를 찾는다.
            clazz.getConstructor();
            return clazz.newInstance(); // 기본 생성자를 호출하여 객체를 생성한다.
        } catch (Exception e) { 
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor constructor : constructors) {
                Object obj = callConstructor(constructor);
                if (obj != null)
                    return obj;
            }
            return null;
        }
    }
    
    private Object callConstructor(Constructor constructor) throws Exception {
        if (containsDefaultType(constructor))
            return null;
        
        // 1) 생성자의 파라미터 타입을 알아낸다.
        Class[] paramTypes = constructor.getParameterTypes();
        
        // 파라미터 타입에 해당하는 값을 보관할 저장소
        ArrayList<Object> paramValues = new ArrayList<>();
        for (Class paramType : paramTypes) {
            paramValues.add(findObject(paramType)); // 파라미터 값을 준비
        }
        
        // 파라미터 값이 준비되었기 때문에
        // 준비한 파라미터 값을 가지고 생성자를 호출하여 인스턴스를 만들어 리턴한다.
        return constructor.newInstance(paramValues.toArray());
    }
    
    private Object findObject(Class clazz) throws Exception {
        Object obj = objPool.get(clazz.getName());
        if (obj != null) { // 그 클래스 타입과 일치하는 객체가 있다면 그 객체를 리턴,
            return obj;
        } else { // 만약 objPool에 그런 타입의 객체가 없다면 새로 만들어 리턴.
            obj = clazz.newInstance();
            objPool.put(clazz.getName(), obj);
            return obj;
        }
    }
    
    private boolean containsDefaultType(Constructor constructor) {
        Class[] defaultTypes = {
                byte.class, short.class, int.class, long.class, 
                float.class, double.class, boolean.class, char.class,
                Byte.class, Short.class, Integer.class, Long.class,
                Float.class, Double.class, Boolean.class, Character.class, String.class
            };
        // 1) 생성자의 파라미터 정보를 꺼낸다.
        Class[] paramTypes = constructor.getParameterTypes();
        
        // 2) 생성자의 파라미터 타입이 primitive 타입이거나 Wrapper, String 일 경우
        //    이 생성자를 호출할 때 해당 값을 줘서 호출해야 한다.
        //    문제는 어떤 값을 줘야 하는지, 예를 들어 int를 원한다면
        //    int값으로 얼마를 줘야 하는지 여기 결정할 수 없다.
        //    그래서 이런 생성자로는 객체를 생성할 수 없다.
        //    이런 생성자인지 검사한다.
        for (Class paramType : paramTypes) {
            for (Class defaultType : defaultTypes) {
                if (paramType == defaultType) // 한개라도 포함하고 있다면 true 
                    return true;
            }
        }
        return false;
    }
    
    public Object getBean(String name) {
        return objPool.get(name);
    }
    
    
}
