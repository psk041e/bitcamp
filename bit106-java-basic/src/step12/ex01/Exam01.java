package step12.ex01;

public class Exam01 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        // list.ArrayList(4); // 인스턴스 주소로 생성자를 호출할 수 없다.
        list.add("aaa"); // aaa,
        list.add("bbb"); // aaa, bbb,
        list.add("ccc"); // aaa, bbb, ccc,
        list.add("ddd"); // aaa, bbb, ccc, ddd,
        
        print(list); // aaa, bbb, ccc, ddd,
        
        list.remove(2);
        
        print(list); // aaa, bbb, ddd,
        
        list.remove(0);
        
        print(list); // bbb, ddd,
        
        list.remove(4);
        
        print(list); // bbb, ddd,
        
        list.add(1, "xxx"); // bbb, xxx, ddd,
        list.add(1, "yyy"); // bbb, yyy, xxx, ddd,
        list.add(0, "zzz"); // zzz, bbb, yyy, xxx, ddd,
        list.add(5, "ttt"); // zzz, bbb, yyy, xxx, ddd,
        
        print(list);
        
        list.set(1, "aaa"); // zzz, aaa, yyy, xxx, ddd,
        
        print(list);
        
        list.add("ccc"); // zzz, aaa, yyy, xxx, ddd, ccc,
        list.add("eee"); // zzz, aaa, yyy, xxx, ddd, ccc, eee,
        
        print(list);
        
        
    }
    
    static void print(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();
    }
}
