package step13.ex02;

public class LinkedList2<E> { // 자바 튜토리얼 참고 
    
    
    protected class Bucket {  
        public E value; 
        public Bucket next; 
        public Bucket prev; 
                            
    }
    
    protected Bucket head; 
    protected Bucket tail; 
    
    public LinkedList2() {
        head = new Bucket();
        tail = head;
    }

    public void add(E value) {
        // 맨 끝 객차에 짐을 싣는다.
        tail.value = value;
        
        // 새 객차를 만들어 맨 뒤에 붙인다.
        Bucket bucket = new Bucket();
        tail.next = bucket;
        
        // 새 객차에 이전 객차의 주소를 저장한다.
        bucket.prev = tail;
        
        // 새로 붙인 객체를 맨 끝 객체로 처리한다.
        tail = bucket;
    }

    public E get(int i) {
        Bucket cursor = head;
        int count = 0;
        
        while (cursor != tail) {
            if (count == i)
                return cursor.value;
            count++;
            cursor = cursor.next;
        }
        return null;
    }

    public int size() {
        Bucket cursor = head;
        int count = 0;
        
        while (cursor != tail) {
            count++;
            cursor = cursor.next;
        }
        return count;
    }

    public E remove(int i) {
        Bucket cursor = head;

        if (i == 0) {
            if (head == tail) // 아무것도 없는 상태
                return null;
            else { // 값이 하나라도 있는 상태이다.
                head = head.next;
                head.prev = null;
                return cursor.value; // 삭제한 버킷의 값을 리턴한다.
            }
        }
        
        int count = 0;
        
        while (cursor != tail) {
            if (count == i) {
                cursor.prev.next = cursor.next;
                cursor.next.prev = cursor.prev;
                return cursor.value;
            }
            
            count++;
            cursor = cursor.next;
        }
        return null;
    }

    public void add(int i, E value) { // cursor는 결국 해당 위치를 가리킨다.
        Bucket cursor = head;
        int count = 0;
        
        while (cursor != tail) {
            if (count == i) {
                Bucket bucket = new Bucket();
                bucket.value = value;
                bucket.prev = cursor.prev;
                cursor.prev = bucket;
                bucket.next = cursor;
                if (bucket.prev != null) {
                    bucket.prev.next = bucket;
                } else { // 이전에 다른 객차가 없다면 이 객체를 헤드로 만든다.
                    head = bucket;
                }
                
                return;
            }
            count++;
            cursor = cursor.next;
        }
        
        if (count == i) { // 맨 끝에 값을 추가하는 것이다.
            add(value);
        }
    }
}
