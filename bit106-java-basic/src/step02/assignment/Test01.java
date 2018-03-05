/*
# 과제(2018-03-05)
사용자로부터 이름, 국어, 영어, 수학 데이터를 입력 받고 합계와 평균을 출력하라
## 실행 결과
```
> java -classpath bin step02.assignment.Test01
이름? 홍길동
국어? 100
영어? 90
수학? 80
-----------
홍길동 100 90 80 270 90.0 
>
*/
package step02.assignment;

public class Test01 {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);

        
        System.out.print("이름? ");
        String s = keyScan.nextLine();
        System.out.print("국어? ");
        int i1 = keyScan.nextInt();
        System.out.print("영어? ");
        int i2 = keyScan.nextInt();
        System.out.print("수학? ");
        int i3 = keyScan.nextInt();
        
        
        int sum = i1 + i2 + i3;
        float average = (float)(sum / 3);

        System.out.println("---------------");
        System.out.println(s + " " + i1 + " " + i2 + " " 
                            + i3 + " " + sum + " " + average);

    }
}