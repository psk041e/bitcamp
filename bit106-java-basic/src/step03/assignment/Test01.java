
// # 과제(2018-03-07)
// 사용자로부터 입력받은 성적 데이터(이름, 국어, 영어, 수학)를 클래스 문법을
// 이용하여 만든 메모리에 저장하라. 또한 평균, 합계를 구하고 출력하라. 입력과
// 출력에 반복문을 적용하라!
// > java -classpath bin step03.assignment.Test01
// 입력? 홍길동 100 100 100
// 입력? 임꺽정 90 90 90
// 입력? 유관순 80 80 80
// -----------
// 홍길동 100 100 100 300 100.0 
// 임꺽정  90  90  90 270  90.0 
// 유관순  80  80  80 240  80.0 

package step03.assignment;

public class Test01 {
    public static void main(String[] args) {
        java.util.Scanner keyScan = new java.util.Scanner(System.in);
        // 키보드에서 Scanner를 읽어들인다.

        // Score 메모리(인스턴스)의 주소를 저장할 변수: 레퍼런스 준비
        step03.Score[] s = new step03.Score[3]; 
        // 입력 값을 저장할 Score 메모리를 준비한다.
        // 사용하려는 클래스가 다른 패키지에 있으면 
        // 무조건 그 패키지, 클래스 명을 명시해야 한다.
        // 메모리에 접근을 하려면 주소가 어딘가에 있어야 한다.

        for (int i = 0; i < s.length; i++) {
            s[i] = new step03.Score();
            System.out.print("입력? ");
            s[i].name = keyScan.next();
            s[i].kor = keyScan.nextInt();
            s[i].eng = keyScan.nextInt();
            s[i].math = keyScan.nextInt();

            s[i].sum = s[i].kor + s[i].eng + s[i].math;
            s[i].aver = s[i].sum / 3;
        }
        
        System.out.println("----------------");

        for (int i = 0; i < s.length; i++) {
            System.out.printf("%s %3d %3d %3d %3d %5.1f\n",
            s[i].name, s[i].kor, s[i].eng, s[i].math, s[i].sum, s[i].aver);
        }


    }
}