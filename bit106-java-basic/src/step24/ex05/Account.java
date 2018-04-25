package step24.ex05;

public class Account {
    String accountId;
    long balance; // 잔액
    
    public Account(String accountId, long balance) {
        this.accountId = accountId;
        this.balance = balance;
    }
    
    // 한 번에 한 스레드만이 호출하도록 접근을 제한하고 싶다면 
    // 메서드 전체를 동기화 블럭으로 선언하라!
    // 어떻게? 메서드 앞에 synchronized를 붙인다.
    // => 이 메서드처럼 여러 스레드가 접근했을 때 문제가 발생하는 critical section이 아니면
    //    synchronized 사용을 자제하라. 왜? 성능이 떨어진다.(멀티스레드를 이용하지 못하기 때문)
    synchronized public long withdraw(long money) { // method Area
        for (int i = 0; i < 10000; i++) Math.asin(45.765);
        long b = this.balance;
        // 시간 딜레이를 위해 넣었다.(의미x)
        for (int i = 0; i < 10000; i++) Math.asin(45.765);
        b -= money;
        for (int i = 0; i < 10000; i++) Math.asin(45.765);        
        if (b < 0)
            return 0;
        for (int i = 0; i < 10000; i++) Math.asin(45.765); 
        // for문에서 t1이 머뭇거리는 사이에 t3스레드가 시작을 한다.
        this.balance = b;
        for (int i = 0; i < 10000; i++) Math.asin(45.765);
        return money;
    }
}
