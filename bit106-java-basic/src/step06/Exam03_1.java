// 메서드 : call by value
package step06;

import java.util.Scanner;

public class Exam03_1 {

    static void swap(int a, int b) { // 두 개의 값을 바꾼다.
        // a, b는 swap이 호출될 때 만들어지는 변수이다.
        System.out.printf("swap() : a=%d, b=%d\n", a, b);
        int temp = a;
        a = b;
        b = temp;
        System.out.printf("swap() : a=%d, b=%d\n", a, b);
    }

    public static void main(String[] args) {
        
        // a, b는 메인이 호출될 때 만들어지는 변수이다.
        int a = 100;
        int b = 200;

        // swap() 호출할 때 a 변수의 값과 b 변수의 값을 넘긴다.
        // => 그래서 "call by value" 라 부른다.
        // => 비록 swap() 에서 a와 b라는 이름의 변수가 있지만,
        //    이 변수는 main()dp dlTsms qustndhk ekfms qustndlek.
        swap(100, 200);
        System.out.printf("main() : a=%d, b=%d\n", a, b);
    }
}

// call by value
// => 자바에서는 primitive data type인 경우 메서드를 호출할 때 값을 넘긴다.
// => 자바에서는 primitive data type에 대해서 메모리 주소를 넘기는 방법이 없다.
//    (c에서는 가능하다)
//
