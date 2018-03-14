// 메서드 : 스택 메모리 응용 III - 스택 오버플로우
package step06;

public class Exam04_6 {

    static int sum(int value) {
        // 종료 조건을 빼버리면, 무한으로 호출한다.
        // 재귀 호출을 할 때 StackOverflow 에러가 날 확율이 높다.
        // -> 그 메소드에 대한 메모리를 만들 수 없어서 발생하는 에러
        /*
        if (value == 1)
            return 1;
        */
        long a1, a2, a3, a4, a5, a6, a7, a8, a9;
        long a11, a12, a13, a14, a15, a16, a17, a18, a19; 
        long a111, a112, a113, a114, a115, a116, a117, a118, a119; 
        // 메소드를 호출할 때마다 72bite 의 Stcak 메모리 생성
        // new는 Heap에 만들어진다. 순수하게 Stack에 만들기 위해서는 new를하면 안된다.
        // 스택 메모리 -> 재귀호출 -> 스택 오버플로우
        // 1부터 백만까지 반복문 돌려도 메모리가 부족하다는 에러가 뜨지 않지만
        // 
        System.out.println(value);
        return value + sum(value - 1); 
        //Exception in thread "main" java.lang.StackOverflowError

    }

    public static void main(String[] args) {

        System.out.println(sum(5));     
    }
}
