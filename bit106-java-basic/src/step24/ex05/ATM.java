package step24.ex05;

public class ATM extends Thread {
    Account account;
    
    public ATM(String name, Account account) {
        super(name);
        this.account = account;
    }
    
    @Override
    public void run() {
        long money = 100;
        long sum = 0;
        
        while (true) {
            money = account.withdraw(100);
            
            if (money <= 0) 
                break;
            sum += money;
        }
        // 스레드명, 찾은 돈
        System.out.printf("%s가 찾은 돈: %d원\n", this.getName(), sum);
    }
}
