package step12.ex01;

public class ArrayList {
    protected static final int DEFAULT_CAPACITY = 5;
    
    Object[] list;
    int cursor;
    
    /*
    public void m() {
        this(5);
    } 불가!
    */
    
    public ArrayList() { // 초기 용량을 지정하지 않으면 기본이 5개
        // 자신의 다른 생성자를 호출할 수 있다.
        // => 생성자를 호출할 수 있는 경우
        //    1) new 명령을 사용할 때 호출할 생성자를 지정
        //    2) 생성자에서 다른 생성자를 호출할 때
        //    그 외에는 임의로 생성자를 호출할 수 없다. 
        // 일반 메서드에서 생성자를 임의로 호출할 수 없다.
        // 다른 생성자를 호출할 때는 super 클래스의 생성자를 호출할 수 없다.
        // => 둘 중 하나만 첫 문장으로 올 수 있다.
        // super(); // 컴파일 오류!
        this(DEFAULT_CAPACITY); // 5는 capacity에 들어가는 파라미터 값이다.
    }
    
      public ArrayList(int capacity) {
        // super(); 항상 생성자에는 수퍼 클래스의 기본 생성자를 호출하는 문장이 숨겨져 있다.
        //          물론 개발자가 수퍼 클래스의 생성자를 호출 하겠다고 명시한다면
        //          당연히 자동으로 붙지 않는다.
        if (capacity < DEFAULT_CAPACITY) { // 최소 5개 이상은 생성
            list  = new Object[DEFAULT_CAPACITY];
        } else {
            list = new Object[capacity]; // Object객체 주소를 담을 배열을 5개 만들어라
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
    public void printD() {
        System.out.println(list.length);
        System.out.println(cursor);
    }
}
