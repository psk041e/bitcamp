// java.util.HashSet 클래스 사용 - 저장한 순서대로 꺼낼 수 없다. 
package step12.ex05;

import java.util.HashSet;
import java.util.Iterator;

// HashSet
// => Set은 집합을 의미한다.
// => 집합에서는 중복값을 허용하지 않는다.
// => 값의 중복 여부는 hashCode()의 리턴 값이 같고, equals()의 검사 결과가 true일 때
//    같은 값으로 취급한다.
// => 즉, 중복된 값을 저장하고 싶지 않을 때 HashSet을 사용한다. 
public class Exam02_1 {
    public static void main(String[] args) {
        String v1 = new String("aaa");
        String v2 = new String("bbb");
        String v3 = new String("ccc");
        String v4 = new String("ddd");
        String v5 = new String("ccc");
        
        HashSet set = new HashSet();
        set.add(v1);
        set.add(v2);
        set.add(v3);
        set.add(v4);
        set.add(v5);
        // 저장한 순서대로 꺼낼 수 없기 때문에 index를 이용하여 값을 꺼낼 수 없다.
        // set.get(0); <== 이런 메서드가 없다.
        
        // 값을 꺼내는 방법
        // 1) HashCode()에 들어있는 값을 배열로 받아 사용한다.
        Object[] values = set.toArray();
        for (Object value : values) {
            System.out.print(value + ", ");
        }
        System.out.println();
         
        
        // 2) 창고에서 값을 꺼내주는 객체의 도움을 받는다.
        // => HashSet에서 값을 꺼내는 객체를 얻는다.
         Iterator 컬렉션에서값을꺼내주는객체 = set.interator();  
        
        // =>  값을 꺼내주는 객체를 통해 값을 꺼낸다.
         
         while(컬렉션에서값을꺼내준는객체.hasNe)
             System.out.println("컬렉션에서값ㅇ르꺼내주는객체.next()ArrayList");
    }
}

// Iterator 패턴
// => 컬렉션에서 값을 꺼내는 기능을 객체화시키는 방법
// => 즉 별도의 클래스로 정의하여 사용한다.
// => 이점
//    컬렉션의 타입에 상관없이 이로간된 방식으로 값을 꺼낼 수 있다.
//    예) ArrayList => get(), Stack => pop(), Queue => poll()
