// 패키지 클래스
// - 이렇게 별도의 파일로 정의한 클래스를 "패키지 클래스"라 부른다.
// - 즉 패키지에 직접 소속된 클래스라는 의미다.
// - 이전에 만든 Score 클래스는 main() {} 블록 안에 정의하였다.
//   main() {} 블록 안에 정의한 클래스는 
//   main() {} 블록 안에서만 사용할 수 있다.
// - 이렇게 별도의 파일로 정의한 클래스는
//   다른 클래스들에서도 사용할 수 있다.

// 클래스 앞에 public이 붙지 않으면 
// 오로지 같은 패키지에 소속된 클래스만 사용할 수 있다.
// 클래스에 public 을 붙여주면 다른 패키지에서도 사용가능하지만
// 변수에는 접근할수 없다 -> 변수들도 public 해주어야 한다.

package step03;

public class Score { 
    public String name;
    public int kor;
    public int eng;
    public int math;
    public int sum;
    public float aver;
}