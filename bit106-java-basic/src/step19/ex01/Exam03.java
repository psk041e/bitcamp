// IoC 컨테이너 만들기 - 1) 특정 패키지의 파일 목록 알아내기
package step19.ex01;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

// => 디렉토리의 파일 목록을 다루는 메서드를 별도의 클래스로 분리한다.
public class Exam03 {
    
    public static void main(String[] args) {
        // 1) 패키지 경로를 준비
        File packageDir = new File("C:\\Users\\박서경\\git\\bitcamp\\bit106-java-basic\\src\\step19\\ex01");
        
        // 2) 해당 디렉토리에서 파일 목록을 가져오기
        ApplicationContext appContext = new ApplicationContext(packageDir); // 파일 목록을 준비 해 달
        List<File> files = appContext.getFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                System.out.printf("d %s\n", f.getName()); // 파일명만 출력해라
            } else {
                System.out.printf("- %s\n", f.getName());
            }
        }
    }
        /*
        static List<File> findFiles(File dir) { // 파일 객체를 담은 리스트 리턴
            LinkedList<File> list = new LinkedList<>();
            File[] files = dir.listFiles(); // 디렉토리인지 파일인지 구분해준다. 파일 배열을 리턴한다.
            for (File f : files) {
                list.add(f);
            } 
            return list;
        }     // 디렉토리에서 목록을 가져와 arraylist에 담는다
              // 배열보다 넣고 빼기가 편하기 때문에 arraylist에 담는다.
        */
        
        
        // LinkedList - 새값이 들어오면 새버킷을 만들어 기존 버킷과 연결
        // 목록을 관리하는 방법은 다르지만 데이터를 넣고빼는것은 같다.
        // ★★아예 목록을 관리하는 것에 대해서 List<>라는 클래스가 존재한다.★★ 
        // -> 자바에서 규칙을 정해버렸다. (java.util.List<> API참고)  
        // 메소드, 리턴값, 파라미터를 통일하자
        // All Known Implementing Classes: 
        // AbstractList, AbstractSequentialList, ArrayList, AttributeList, 
        // CopyOnWriteArrayList, LinkedList, RoleList, RoleUnresolvedList, Stack, Vector
        // -> 이것들이 List 규칙을 이용하는것들이다.
        // 리턴 타입에 대해서 구체적인 배열을 사용하지 않고 규칙 이름을 명시하자!
        // => 이것들을 "List 구현체"라고 한다.
        
        // 리턴값에 대해 
        // 그 상위 클래스나 인터페이스를 사용하는것이 유지보수를 쉽게 만든다.

        
        
        
        
        
}
