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

// 컴파일러에게 클래스의 위치 정보를 알려준다.
// => 컴파일한 후 import 명령은 제거된다.
//    즉 .class 파일에 포함되지 않는다.
// => **** 그러니 import 문장이 많으면 .class 파일이 커지지 않을까 걱정말라! ****
//    (자바 버추얼 머신이 아니라 컴파일러에게 제공하는 것이다)
import bitcamp.java106.pms.domain.Team;
import java.util.Scanner;

// next() 와 nextLine()의 차이

// 1단계: 클래스 적용
// 2단계: 배열 적용
// 3단계: 반복문 적용
// 4단계: 조건문 적용
public class App {
    public static void main(String[] args){
        Scanner keyScan = new Scanner(System.in);
        // 매일 하루종일 돌아가는 프로그램에서는 keyScan.close를 해 주어야
        // garbage가 생기지 않지만 짧은 소스코드에서는
        // 자바 버추얼머신이 종료하면 어차피 자원을 다 반납하기 때문에
        // 써주지 않아도 된다.
        
        // 팀 정보를 받을 메모리 준비
        // S => 인스턴스의 주소를 저장하는 레퍼런스 
        //      (teamRef에서 Ref는 생략해서 사용한다.)
        Team[] teams = new Team[5]; 


        int count = 0;
        for (int i = 0; i < teams.length; i++){ // index의 약자로써 i를 사용
            count++;
            teams[i] = new Team(); 
            // 배열에 팀 객체를 넣어라 (객체의 주소를 넣어라)
            // 주소는 주고받을수 있어도 객체는 주고받을 수 없다.
            System.out.print("팀명? ");
            teams[i].name = keyScan.nextLine();
            System.out.print("설명? ");
            teams[i].description = keyScan.nextLine();
            System.out.print("최대인원? ");
            teams[i].maxQty = keyScan.nextInt();
            keyScan.nextLine(); // 숫자 뒤에 줄바꿈 코드를 읽는다.
                                // 읽고 난 뒤에 아무것도 안하기 때문에
                                // 일종의 줄바꿈 코드를 제거하는 효과가 있다.
            System.out.print("시작일? ");
            teams[i].startDate = keyScan.nextLine();
            System.out.print("종료일? ");
            teams[i].endDate = keyScan.nextLine();
            
            System.out.print("계속 입력 하시겠습니까?(Y/n) ");
            String str = keyScan.nextLine();
            // 메모리를 더 희생시키더라도
            // 개발자가 코드를 봤을때 반복문 안에서만 쓰는 변수라는것을 알수있다
            // 컴파일러가 알아서 옵티마이징한다 - 최소화

            if(count == teams.length) { 
                // => if (i == teams.length - 1) 과 같다.
                // 배열의 끝에 도달하면 질문하지 않고 종료
                break;
            }

            if (str.toLowerCase().equals("n")) {
                // .toLowerCase() : 입력받은 문자열을 대문자든 소문자든 소문자로
                // 만들기 때문에 대문자를 넣어도 동일하게 돌아간다.
                break;
            }
        }

        System.out.println("-------------------------");
        
        for (int i = 0; i < count; i++) {
            System.out.printf("%s, %d명, %s ~ %s\n",
            teams[i].name, teams[i].maxQty, 
            teams[i].startDate, teams[i].endDate);
        }

    }
}
