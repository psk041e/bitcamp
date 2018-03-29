// java.util.ArayList의 indexOf()의 사용
package step12.ex01;

import java.util.ArrayList;

public class Exam03_2 {
    public static void main(String[] args) {
        String s1 = new String("aaa"); // 0번방
        String s2 = new String("bbb"); // 1번방
        String s3 = new String("ccc"); // 2번방
        String s4 = new String("bbb"); // 3번방
        
        ArrayList list = new ArrayList();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        print(list);
        
        System.out.println(list.indexOf(s4)); 
        // s4객체와 같은 내용을 가진 객체가 들어있다면 몇번째 방에 들어있는지 번호를 리턴해라
        // 1리턴 -> 1번방에 들어있다.
        
    }
    
    static void print(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();
    }
}
