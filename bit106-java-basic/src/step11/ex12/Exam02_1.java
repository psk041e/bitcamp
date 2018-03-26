// Object 클래스의 메서드를 오버라이딩 하기 - hashcode()
package step11.ex12;

public class Exam02_1 {
    
    static class Score {
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float aver;
        
        public Score(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
            this.sum = kor + eng + math;
            this.aver = this.sum / 3f;
        }
    }
        
    public static void main(String[] args) {
        Score s1 = new Score("홍길동", 100, 100, 100);
        Score s2 = new Score("홍길동", 100, 100, 100);
        
        // 인스턴스 전체를 비교하면 시간이 걸리므로 4byte의 hashcode를 비교한다.
        // Object에서 상속 받아 사용하는 hashCode()는
        // 기본적으로 인스턴스 마다 고유의 값을 리턴한다.
        // 주의! 인스턴스 주소가 아니다!
        // 그래서 다음 출력은 비록 같은 값을 갖고 있다하더라도
        // 인스턴스가 다르기 때문의 해시코드의 값이 다르다!
        System.out.printf("%d, %d\n", s1.hashCode(), s2.hashCode());
        
    }

}
