// 정수 변수 - 정수 리터럴과 정수 변수
package step02; 


public class Exam04_1 {
    public static void main(String[] args) {
        byte b;
        // 정수 리터럴은 기본이 4바이트 메모리를 차지한다.
        // ******그런데 byte메모리에 저장할 수 있는 값이라면 허락한다!!******
        b = -128;
        b = 127;

        // 다음과 같이 4바이트 리터럴 값을 메모리에 넣을 수 없다면
        // 컴파일 오류가 발생한다!
        // int 를 byte로 바꾸다가 데이터를 잃어버릴수 있으므로 컴파일 안해준다
//        b = -129; 
//        b = 128;

        short s;
        // 4바이트 정수 리터럴을 short 메모리(2byte)에 저장할 수 있다면 허락한다.
        s = -32768; // 컴파일 오류!
        s = 32767; // 컴파일 오류!

        // 만약 2바이트 범위를 벗어난다면 컴파일 오류!
//        s = -32769; // 컴파일 오류!
//        s = 32768; // 컴파일 오류!

        int i;
        i = -2147483648;
        i = 2147483647;

//        i = 100L; //

        
        // 값을 못 넣는 것이 아니라 처음부터 잘못되었다
        // 4바이트 범위를 넘어가는 숫자는 표기할수 없다.
        // 다음은 메모리의 문제가 아니다.
        // 정수 값을 표현할 때 4바이트 크기를 넘어가는 수를 표현했기 때문에
        // 오류가 발생한 것이다.
        // 4바이트 크기를 넘어가는 정수를 표현할 때는 
        // 반드시 숫자 뒤에 L 또는 l을 붙여야 한다.
        // i = -2147483649;
        // i = 2147483648;
        // 4바이트를 넘어가는 수는 l을 붙여주어야 하는 규칙을 어긴것

        // 다음은 4바이트가 넘어가는 수에 대해 L 또는 l을 붙임으로써
        // 정수 리터럴을 잘 표현했다.
        // 그러나 i 메모리가 4바이트 크기를 갖기 때문에 
        // 오른쪽의 값을 모두 저장할 수 없다.
        // 그래서 컴파일 오류가 발생한다.
//        i = -2147483648L; // 컴파일 오류!
//        i = 2147483647l; // 컴파일 오류!
        // 8바이트 리터럴을 제대로 표현하지 못해서 에러이다


        long l;
        l = -9223372036854775808L;
        l = 9223372036854775807L;
        // 4바이트 메모리를 넘어가는 값에는 L을 붙여주어야 한다.

        byte b2;
        b2 = 100; // OK
//        b2 = 100L; // 컴파일 오류!
        // 4바이트 정수 리터럴에 대해서만(예외이다)
        // byte나 short메모리에 유효한 범위의 값을 저장할 수 있게 허락한다.
        // 8byte 정수 리터럴일 경우에는 
        // 비록 byte나 short 메모리에 저장할 수 있는 값이라도
        // 허락하지 않는다. 컴파일 오류이다.
        
    }
}

