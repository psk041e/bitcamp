package bitcamp.java106.pms.dao;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;

@Component
public class TeamMemberDao {
    
    private HashMap<String, ArrayList<String>> collection;
 
    public TeamMemberDao() throws Exception {
        load();
    }
    
    /*
    @SuppressWarnings("unchecked")
    // 이 메서드에서 리턴 타입이 맞는지 검사가 되지 않더라도 타입 체크에 관한건
    // 에러 띄우지 말아라.
    // 항상 Warning은 없어야 한다.
    public void load() {
        try ( 
            ObjectInputStream in = new ObjectInputStream(
                                   new BufferedInputStream(
                                   new FileInputStream("data/teammember.data")));
            ) {
                
                collection = (HashMap<String,ArrayList<String>>) in.readObject();
            //in.close(); 자동으로 하기 때문에 필요 없다.
            } catch (Exception e) {
                // 데이터를 읽다가 오류가 발생하면 빈 해시맵 객체를 만든다.
                collection = new HashMap<>();
            }
    }
    */
    public void load() throws Exception {
        Scanner in = new Scanner(new FileReader("data/teammember.csv"));
        while (true) {
            try {
                String[] arr = in.nextLine().split(":");
                String[] idList = arr[1].split(",");
                ArrayList<String> list = new ArrayList<>();
                for (String id : idList) {
                    list.add(id);
                }
                collection.put(arr[0], list);
            } catch (Exception e) { // 데이터를 모두 읽었거나 파일 형식에 문제가 있다면,
                e.printStackTrace();
                break; // 반복문을 나간다.
            }
        }
        in.close();
    }
    
    public void save() throws Exception {
        try (
                ObjectOutputStream out = new ObjectOutputStream(
                                new BufferedOutputStream(
                                new FileOutputStream("data/teammember.data")));
            ) {
            
            out.writeObject(collection);
        } 
    }
    
    
    public int addMember(String teamName, String memberId) {
        String teamNameLC = teamName.toLowerCase();
        String memberIdLC = memberId.toLowerCase();
        
        // 팀 이름으로 멤버 아이디가 들어 있는 ArrayList를 가져온다.
        ArrayList<String> members = collection.get(teamNameLC);
        if (members == null) { // 해당 팀의 멤버가 추가된 적이 없다면,
            members = new ArrayList<>();
            members.add(memberIdLC);
            collection.put(teamNameLC, members);
            return 1;
        }
        
        // ArrayList에 해당 아이디를 가진 멤버가 들어 있다면,
        if (members.contains(memberIdLC)) {
            return 0;
        }
        
        members.add(memberIdLC);
        return 1;
    }
    
    public int deleteMember(String teamName, String memberId) {
        String teamNameLC = teamName.toLowerCase();
        String memberIdLC = memberId.toLowerCase();
        
        ArrayList<String> members = collection.get(teamNameLC);
        if (members == null || !members.contains(memberIdLC)) 
            return 0;

        members.remove(memberIdLC);
        return 1;
    }
    
    public Iterator<String> getMembers(String teamName) {
        ArrayList<String> members = collection.get(teamName.toLowerCase());
        if (members == null)
            return null;
        return members.iterator();
    }
    
    public boolean isExist(String teamName, String memberId) {
        String teamNameLC = teamName.toLowerCase();
        String memberIdLC = memberId.toLowerCase();
        
        // 팀 이름으로 멤버 아이디가 들어 있는 ArrayList를 가져온다.
        ArrayList<String> members = collection.get(teamNameLC);
        if (members == null || !members.contains(memberIdLC)) 
            return false;
        
        return true;
    }
}

// 용어 정리!
// 메서드 시그너처(method signature) = 함수 프로토타입(function prototype)
// => 메서드의 이름과 파라미터 형식, 리턴 타입에 대한 정보를 말한다.

//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList를 적용하여 객체(의 주소) 목록을 관리한다.
//ver 17 - 클래스 추가









