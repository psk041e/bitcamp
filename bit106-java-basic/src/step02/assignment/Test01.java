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
package step02.assignment; // directory path -> .을 사용한다

public class Test01 {  // jvm이 클래스를 실행하려면 메인 메소드가 있어야 한다.
    public static void main(String[] args) { 
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);

        
        System.out.print("이름? ");
        String name = keyScan.nextLine();
        System.out.print("국어? ");
        int kor = keyScan.nextInt();
        System.out.print("영어? ");
        // 이전에 국어 점수를 입력받을 때 들어온 줄바꿈 코드는 
        // nextInt() 메서드에서 버린다.
        int eng = keyScan.nextInt();
        System.out.print("수학? ");
        int math = keyScan.nextInt();
        
        
        int sum = kor + eng + math;
        float average = (float)(sum / 3);

        System.out.println("---------------------");
        System.out.println(name + " " + kor + " " + eng + " " 
                            + math + " " + sum + " " + average);

    }
}