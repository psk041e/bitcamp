// 디렉토리에 들어 있는 파일이나 하위 디렉토리 정보 알아내기 II
package step16.ex01;

import java.io.File;

public class Exam05_2 {
    public static void main(String[] args) throws Exception {
        File dir = new File(".");

        // => 파일이나 디렉토리 정보를 File 객체로 받기
        File[] files = dir.listFiles(); // 파일의 상세정보를 알고싶을때 listFiles()로 아예 File[]배열로 받는다.
        
        for (File file : files) {
            System.out.printf("%s %12d %30s\n", 
                    file.isDirectory() ? "d" : "-", // 디렉토리이면 "d"를, 아니면(파일이면) "-"를 앞에 붙여줘라
                    file.length(),
                    file.getName());
        }
        
    }
}
