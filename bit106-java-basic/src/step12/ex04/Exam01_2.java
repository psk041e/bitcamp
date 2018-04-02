// java.util.concurrent.ArrayBlockingQueue 구현과 사용
package step12.ex04;

import java.util.concurrent.ArrayBlockingQueue;
// 한번에 하나를 꺼낼 때 다른것들이 달려들지 않게 한다.
public class Exam01_2 {

    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("bbb");
        String s3 = new String("ccc");
        String s4 = new String("ddd");
        String s5 = new String("eee");
        
        ArrayBlockingQueue queue = new ArrayBlockingQueue(100);
        queue.offer(s1); // aaa,
        print(queue); 
        queue.offer(s2); // aaa, bbb,
        print(queue); 
        queue.offer(s3);
        print(queue); // aaa, bbb, ccc
        
        System.out.println("==>" + queue.poll()); // bbb, ccc,
        print(queue);
        System.out.println("==>" + queue.poll()); // ccc,
        print(queue);
        
        queue.offer(s4); // ccc, ddd, 
        print(queue);
        queue.offer(s5); // ccc, ddd, eee,
        print(queue);
        
        String value;
        while ((value = (String) queue.poll()) != null) {
            System.out.println(value);
        }
    }
    
    static void print(ArrayBlockingQueue list) {
        Object[] arr = list.toArray();
        for (Object value : arr) {
            System.out.print(value + ", "); 
            // 컬렉션 객체에 들어 있는 값을 배열로 만들어 배열로 다루고 싶으면 toArray()에 요청하면 된다.
        }
        System.out.println();
    }    
}





















