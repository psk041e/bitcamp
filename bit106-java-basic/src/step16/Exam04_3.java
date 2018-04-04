// 특정 폴더를 생성하여 그 폴더에 파일을 만든다.
package step16;

import java.io.File;

public class Exam04_3 {

    public static void main(String[] args) throws Exception{
        // 생성할 파일의 경로 설정
        File file = new File("temp/a/test.txt");
        
        // File dir = new File(file.getParent()); // 파일의 경로를 알아낸 다음에 그 디렉토리를 만든다.
        File dir = file.getParentFile(); // 아예 parent정보를 가지고 파일정보를 만들어줘라
        
        if (dir.mkdirs()) {
            System.out.println("temp/a 디렉토리를 생성하였습니다.");
        } else {
            System.out.println("temp/a 디렉토리를 생성할 수 없습니다.");
        }
        
        if (file.createNewFile()) { // 파일 생성
            System.out.println("test.txt 파일을 생성하였습니다.");
        } else {
            System.out.println("test.txt 파일을 생성할 수 없습니다.");
        }
        

    }

}
