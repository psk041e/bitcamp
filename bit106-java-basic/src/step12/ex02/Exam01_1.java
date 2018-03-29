package step12.ex02;

public class Exam01_1 {

    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("bbb");
        String s3 = new String("ccc");
        String s4 = new String("ddd");
        String s5 = new String("eee");
        
        LinkedList list = new LinkedList();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        
        System.out.println(list.size());
        
        System.out.println(list.remove(1)); 
        
        print(list); // aaa, ccc,
        
        list.add(s4); // aaa, ccc, ddd
        list.add(1, s5); // aaa, eee, ccc, ddd -> 중간에 eee삽입
        print(list);
        
        list.add(0, s2); // bbb, aaa, eee, ccc, ddd
        print(list);
        
        list.add(5, "xxx"); // bbb, aaa, eee, ccc, ddd, xxx,
        print(list);
    }
    
    static void print(LinkedList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();
    }

}
