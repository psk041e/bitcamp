// 응용 - 특정 패키지의 파일 목록을 알아내기
package step18.ex06;

import java.io.File;
import java.net.URL;

public class Exam02 {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL url = classLoader.getResource("step18/ex06");
        
        File file = new File(url.getPath());
        File[] list = file.listFiles(); // 폴더 밑에 있는것들을 끄집어낸다.
        for (File f : list) {
            System.out.println(f.getName());
        }

    
    
    
    }

}
