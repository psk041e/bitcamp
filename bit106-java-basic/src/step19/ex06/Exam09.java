// IoC 컨테이너 만들기 - 6) Class 객체를 이용하여 인스턴스를 만들어 저장한다.
package step19.ex06;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

// => 인스턴스를 꺼내 그 클래스 이름을 출력한다.
public class Exam09 {
    
    public static void main(String[] args) throws Exception {
        ApplicationContext7 appContext = new ApplicationContext7("step19.ex01"); 
        List<Object> objects = appContext.getObjects();
        for (Object obj : objects) {
            System.out.println(obj.getClass().getName());
        }
    }

        
        
        
        
        
}
