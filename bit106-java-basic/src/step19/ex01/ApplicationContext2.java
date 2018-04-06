// 하위 폴더의 파일을 가져온다.
package step19.ex01;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ApplicationContext2 { // 문맥,환경,상황
    private ArrayList<File> list = new ArrayList<>(); // 파일 정보를 담을 arrayList
    
    public ApplicationContext2(File dir) {
        findFiles(dir); // 생성자에 넘어오는 파일 정보를 다 챙겨서 리스트에 담는다.
    }
    
    public void findFiles(File dir) { // 파일 객체를 담은 리스트 리턴
        File[] files = dir.listFiles(); // 디렉토리인지 파일인지 구분해준다. 파일 배열을 리턴한다.
        for (File f : files) {
            if (f.isDirectory()) {
                findFiles(f); // 재귀호출 -> ★코드가  복제된다고 생각해라★
            } else {
                this.list.add(f);
            }
        } 
    }     // 디렉토리에서 목록을 가져와 arraylist에 담는다
          // 배열보다 넣고 빼기가 편하기 때문에 arraylist에 담는다.
    
    public List<File> getFiles() {
        return this.list;
    }
    
    
    
}
