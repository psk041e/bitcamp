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
public class Test02_3 {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);

        String name1, name2, name3, name4, name5;
        int kor1, kor2, kor3, kor4, kor5;
        int eng1, eng2, eng3, eng4, eng5;
        int math1, math2, math3, math4, math5;
        int sum1, sum2, sum3, sum4, sum5;
        float aver1, aver2, aver3, aver4, aver5;





        System.out.print("입력? ");
        name1 = keyScan.next();
        kor1 = keyScan.nextInt();
        eng1 = keyScan.nextInt();
        math1 = keyScan.nextInt();

        System.out.print("입력? ");
        name2 = keyScan.next();
        kor2 = keyScan.nextInt();
        eng2 = keyScan.nextInt();
        math2 = keyScan.nextInt();
        
        System.out.print("입력? ");
        name3 = keyScan.next();
        kor3 = keyScan.nextInt();
        eng3 = keyScan.nextInt();
        math3 = keyScan.nextInt();

        System.out.print("입력? ");
        name4 = keyScan.next();
        kor4 = keyScan.nextInt();
        eng4 = keyScan.nextInt();
        math4 = keyScan.nextInt();

        System.out.print("입력? ");
        name5 = keyScan.next();
        kor5 = keyScan.nextInt();
        eng5 = keyScan.nextInt();
        math5 = keyScan.nextInt();

        
        sum1 = kor1 + eng1 + math1;
        aver1 = sum1 / 3;

        sum2 = kor2 + eng2 + math2;
        aver2 = sum2 / 3;

        sum3 = kor3 + eng3 + math3;
        aver3 = sum3 / 3;

        sum4 = kor4 + eng4 + math4;
        aver4 = sum4 / 3;

        sum5 = kor5 + eng5 + math5;
        aver5 = sum5 / 3;
        
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