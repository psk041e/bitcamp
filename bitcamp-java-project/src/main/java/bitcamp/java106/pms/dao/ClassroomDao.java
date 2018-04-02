package bitcamp.java106.pms.dao;

import java.util.LinkedList;

public class ClassroomDao {
    private LinkedList<Classroom> collection = new LinkedList<>();
    
    public void insert(Classroom classroom) {
        this.collection.add(classroom);
    }
    
    public Classroom[] list() {
        /*
        Object[] arr1 = new Classroom[10];
        Classroom[] arr2 = (Classroom[]) arr1; // 가능
        
        Object[] arr3 = new Object[10];
        arr2 = (Classroom[]) arr3; // 컴파일은 가능하지만 실행시 에러가난다.
        */
        Classroom[] arr = new Classroom[this.collection.size()]; // 값을 담을 배열을 준비한다.
        return this.collection.toArray(arr); 
        // collection은 데이터를 가지고 있다.
        // toArray()는 담아줄 뿐만아니라 리턴값이 그 배열 주소이기 때문에 따로 return arr;해주지 않아도 된다.
        // 배열에 값을 담은 arr배열을 넘긴다.
        
        /* 위와같다
        for (int i = 0, x = 0; i< collection.size(); i++) {
            arr[i] = this.collection.get(i);
        }
        return arr;
        */
    }
    
    /*
    private int count(String teamName) { // 배열의 개수를 세어준다.
        int cnt = 0;
        for (int i = 0; i < collection.size(); i++) {
            Classroom classroom = collection.get(i);
            if (classroom.getTeam().getName().toLowerCase().equals(
                    teamName.toLowerCase())) {
                cnt++;
            }
        }
        return cnt;
    }
    
    public Classroom get(int classroomNo) {
        int index = this.getClassroomIndex(classroomNo);
        if (index < 0)
            return null;
        return collection.get(index);
    }
    
    public void update(Classroom classroom) {
        int index = this.getClassroomIndex(classroom.getNo());
        if (index < 0)
            return;
        this.collection.set(index, classroom);
    }
    
    public void delete(int classroomNo) {
        int index = this.getClassroomIndex(classroomNo);
        if (index < 0)
            return;
        collection.remove(index);
    }
    
    private int getClassroomIndex(int classroomNo) {
        for (int i = 0; i < this.collection.size(); i++) {
            Classroom classroom = collection.get(i);
            if (classroom.getNo() == classroomNo) {
                return i;
            }
        }
        return -1;
    }
    */
}

// ver 20 - 클래스 추가
// ver 18 - ArrayList 클래스를 적용앟여 객체(의 주소) 목록을 관리한다.
// ver 17 - 클래스 생성





