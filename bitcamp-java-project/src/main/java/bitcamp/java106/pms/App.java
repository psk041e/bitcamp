/*
## src03 - 클래스와 배열
- 학습목표
  - 클래스를 사용하여 입력 데이터를 묶어서 저장하는 방법을 익힌다.
  - 배열을 사용하여 여러 개의 데이터를 다루는 방법을 익힌다.
  - for 반복문을 사용하여 배열을 다루는 방법을 이해한다.
  - if 조건문을 사용하는 방법을 이해한다.
  - 문자열을 비교하는 방법을 이해한다.
- 작업 내용
  - 사용자로부터 팀정보를 입력 받아 출력하라.
  - 입력은 최대 5개까지 가능하다.
  - 5개를 넘으면 바로 출력한다.
- 실행 결과
```
> java -classpath bin bitcamp.java106.pms.App
팀명? 비트비트
설명? 자바 프로젝트 팀
최대인원? 5
시작일? 2018-05-05
종료일? 2018-08-20
계속 입력하시겠습니까?(Y/n) Y
팀명? 비트비트2
설명? 자바 프로젝트 팀2
최대인원? 5
시작일? 2018-05-05
종료일? 2018-08-20
계속 입력하시겠습니까?(Y/n) Y
팀명? 비트비트3
설명? 자바 프로젝트 팀3
최대인원? 5
시작일? 2018-05-05
종료일? 2018-08-20
계속 입력하시겠습니까?(Y/n) n
--------------------------------
비트비트, 5명, 2018-05-05 ~ 2018-08-20
비트비트2, 5명, 2018-05-05 ~ 2018-08-20
비트비트3, 5명, 2018-05-05 ~ 2018-08-20

*/

package bitcamp.java106.pms;
// next() 와 nextLine()의 차이
public class App {
    public static void main(String[] args){
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);

        class Source {
            String teamName;
            String description;
            int maxQty;
            String startDate;
            String endDate;
        }

        Source[] s = new Source[5];

        int su = 1;
        for (int i = 0; i < 5; i++){
            s[i] = new Source();
            System.out.print("팀명? ");
            s[i].teamName = keyScan.nextLine();
            System.out.print("설명? ");
            s[i].description = keyScan.nextLine();
            System.out.print("최대인원? ");
            s[i].maxQty = keyScan.nextInt();
            keyScan.nextLine(); // 숫자 뒤에 줄바꿈 코드르르 읽는다.
                                // 일고 난 뒤에 아무것도 안하기 때문에
                                // 일종의 줄바꿈 코드를 제거하는 효과가 있다.
            System.out.print("시작일? ");
            s[i].startDate = keyScan.nextLine();
            System.out.print("종료일? ");
            s[i].endDate = keyScan.nextLine();
            
            System.out.print("계속 입력 하시겠습니까?(y/n) ");
            String answer = keyScan.nextLine();

            if (!answer.equalsIgnoreCase("y")) {
                break;
            }
            su++;
        }

        System.out.println("-------------------------");
        
        for (int i = 0; i < su; i++) {
            System.out.println(s[i].teamName + ", " + s[i].description + ", "
                + s[i].maxQty + "명, " + s[i].startDate + " ~ " + s[i].endDate);
        }

    }
}
