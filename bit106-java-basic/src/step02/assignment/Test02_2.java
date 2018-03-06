package step02.assignment;

// 입력? 홍길동 100 90 80
// 입력? 임꺽정 100 100 100
// 입력? 유관순 90 90 90 
// 입력? 안중근 80 80 80
// 입력? 윤봉길 70 70 70
// -----------
// 홍길동 100 90 80 270 90.0 
// 임꺽정 100 100 100 300 100.0 
// 유관순 90 90 90 270 90.0 
// 안중근 80 80 80 240 80.0 
// 윤봉길 70 70 70 210 70.0 

// 1단계: 1명의 성적 데이터 입력 받아서 처리하기
// 2단계: 여러 명의 성적 정보를 받아서 처리하기
// 3단계: 변수 선언을 모아서 일괄적으로 처리하기
// 4단계: 배열을 사용하여 같은 종류의 메모리를 쉽게 만들기 
// 5단계: 반복문을 사용하여 입력과 출력 코드를 간단히 하라!
// 6단계: 형식을 갖춘 문자열 출력하기
public class Test02_2 {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);

        System.out.print("입력? ");
        String name1 = keyScan.next();
        int kor1 = keyScan.nextInt();
        int eng1 = keyScan.nextInt();
        int math1 = keyScan.nextInt();

        System.out.print("입력? ");
        String name2 = keyScan.next();
        int kor2 = keyScan.nextInt();
        int eng2 = keyScan.nextInt();
        int math2 = keyScan.nextInt();
        
        System.out.print("입력? ");
        String name3 = keyScan.next();
        int kor3 = keyScan.nextInt();
        int eng3 = keyScan.nextInt();
        int math3 = keyScan.nextInt();

        System.out.print("입력? ");
        String name4 = keyScan.next();
        int kor4 = keyScan.nextInt();
        int eng4 = keyScan.nextInt();
        int math4 = keyScan.nextInt();

        System.out.print("입력? ");
        String name5 = keyScan.next();
        int kor5 = keyScan.nextInt();
        int eng5 = keyScan.nextInt();
        int math5 = keyScan.nextInt();

        
        int sum1 = kor1 + eng1 + math1;
        float aver1 = sum1 / 3;

        int sum2 = kor2 + eng2 + math2;
        float aver2 = sum2 / 3;

        int sum3 = kor3 + eng3 + math3;
        float aver3 = sum3 / 3;

        int sum4 = kor4 + eng4 + math4;
        float aver4 = sum4 / 3;

        int sum5 = kor5 + eng5 + math5;
        float aver5 = sum5 / 3;
        
        System.out.println("-----------------------");
        System.out.println(name1 + " " + kor1 + " " + eng1 + " " + 
                            math1 + " " + sum1 + " " + aver1);
        System.out.println(name2 + " " + kor2 + " " + eng2 + " " + 
                            math2 + " " + sum2 + " " + aver2);
        System.out.println(name3 + " " + kor3 + " " + eng3 + " " + 
                            math3 + " " + sum3 + " " + aver3);
        System.out.println(name4 + " " + kor4 + " " + eng4 + " " + 
                            math4 + " " + sum4 + " " + aver4);
        System.out.println(name5 + " " + kor5 + " " + eng5 + " " + 
                            math5 + " " + sum5 + " " + aver5);


        }

    }