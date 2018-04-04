// non-static 중첩 클래스 응용
package step17.ex03;

import java.util.Iterator;

public class ArrayList {
    
    public class MyIterator {
        int index;
        public boolean hasNext() {
            if (index < ArrayList.this.cursor)
                return true;
            return false;
        }
        public Object next() {
            return ArrayList.this.list[this.index++];
        }
        
    }
    
    
    protected static final int DEFAULT_CAPACITY = 5;
    
    Object[] list;
    int cursor;
    
    public ArrayList() {
        this(DEFAULT_CAPACITY); 
    }
    
      public ArrayList(int capacity) {
        if (capacity < DEFAULT_CAPACITY) { 
            list  = new Object[DEFAULT_CAPACITY];
        } else {
            list = new Object[capacity];
        }
    }
    
    public void add(Object value) {
        if (cursor >= list.length) { 
            // 새 값을 저장해야 하는데 배열이 꽉 차있는 상태라면
            // 이 메서드로 가라
            this.increaseArray();
        }
        list[cursor++] = value;
    }
    
    public Object get(int index) {
        return list[index];
    }
    
    public void set(int index, Object value) {
        list[index] = value; // replace이기 때문에 해당 인덱스에 집어넣어주기만 하면 된다.
    }
    
    public void remove(int index) {
        if (index < 0 || index >= cursor)
            return;
        
        for (int i = index + 1; i < cursor; i++) {
            list[i - 1] = list[i];
        }
        cursor--;
    }
    
    public void add(int index, Object value) {
        if (index < 0 || index > cursor) // 커서보다 하나 큰경우까지 가능
            return;
        
        if (cursor >= list.length) {
            this.increaseArray();
        }
        
        for (int i = cursor - 1; i >= index; i--) {
            list[i + 1] = list[i];
        }
        list[index] = value; // 방을 옮긴 후에 그 방으로 새 값을 넣는다.
        cursor++;
    }
    
    private void increaseArray() {
        Object[] list2 = new Object[list.length + DEFAULT_CAPACITY];
        for (int i = 0; i < list.length; i++) {
            list2[i] = list[i];
        }
        list = list2;
    }
    
    public int size() {
        return cursor; // 입력된 갯수와 똑같다.
    }
    
    public boolean contains(Object value) { // Object타입이지만 실제 String객체가 들어온다.
                                            // 데이터 내용이 같은지 비교
        for (Object obj : list) {
            if (obj.equals(value))          // 같은 객체가 들어 있는지 검사하는 것이 아니다.
                return true;                // 같은 내용을 가진 객체가 들어 있는지 검사하는 것이다.
        }
        return false;
    }
    
    public int indexOf(Object value) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(value))          // 같은 객체가 들어 있는지 검사하는 것이 아니다.
                return i;                       // 같은 내용을 가진 객체가 들어 있는지 검사하는 것이다.
            }
        return -1;
    }
    
    public MyIterator iterator() {
        // MyIterator를 만들 때 현재 ArrayList 객체 주소를 넘겨준다.
        // 즉 MyIterator는 자신이 만들어지는 그 순간의 바깥(클래스의) 객체의 주소를 알게 된다.
        // MyIterator는 이 바깥 객체를 가지고 값을 꺼낼 것이다.
        return new MyIterator(); // 내부에 보유하고 있는 인스턴스 객체 주소를 만들어 리턴한다.
    }
}
