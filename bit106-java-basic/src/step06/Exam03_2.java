// 메서드 : call by reference
package step06;

public class Exam03_2 {

    static void swap(int[] arr) { // arr : swap이 호출될 때 만들어진 배열이다.
        System.out.printf("swap() : arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
        System.out.printf("swap() : arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {100, 200};
        // swap(new int[] {100, 200}); // 배열을 만들어서 넘겨준다.
        swap(arr); // 배열 인스턴스(메모리) 를 넘기는 것이 아니다.
                   // 주소를 넘기는 것이다.
                   // 그래서 "call by reference" 라 부른다.
        System.out.printf("main() : arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);
        // 메소드에서 다른 메소드가 바꾼 값을 출력할 수 있다.
        // -> 주소를 전달해야 한다.
        // -> 배열을 전달한다는 것은 배열의 주소를 전달한다는 것이다.
        // -> 같은 배열에 접근한다는 것이다.

        System.out.print(arr[0]);
    }
}

