// IoC 컨테이너 만들기 - 1) 특정 패키지의 파일 목록 알아내기
package step19.ex01;

import java.io.File;
// 일반 파일들은 컴파일 되는것이 아니다.
// bin이라는 폴더에 그대로 복사된다.
// java소스파일은 컴파일되어 놓여지고 그 외의 파일들은 그대로 복사된다.
// Navigator는 가공하지 않고 파일을 그대로 보여준다.

// => 그 패키지에 있는 파일 및 디렉토리 정보만 알아낸다.
public class Exam01 {
    
    public static void main(String[] args) {
        // 1) 패키지 경로를 준비
        File packageDir = new File("C:\\Users\\박서경\\git\\bitcamp\\bit106-java-basic\\src\\step19\\ex01");
        
        // 2) 해당 디렉토리에서 파일 목록을 가져오기
        File[] files = packageDir.listFiles(); // 디렉토리인지 파일인지 구분해준다. 파일 배열을 리턴한다.
        for (File f : files) {
            if (f.isDirectory()) {
                System.out.printf("d %s\n", f.getName()); // 파일명만 출력해라
            } else {
                System.out.printf("- %s\n", f.getName());
            }
        }
        
        
    }
}
