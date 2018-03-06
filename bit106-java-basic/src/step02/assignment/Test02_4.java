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
public class Test02_4 {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);

        String[] name = new String[5];
        int[] kor = new int[5];
        int[] eng = new int[5];
        int[] math = new int[5];
        int[] sum = new int[5];
        float[] aver = new float[5];


        System.out.print("입력? ");
        name[0] = keyScan.next();
        kor[0] = keyScan.nextInt();
        eng[0] = keyScan.nextInt();
        math[0] = keyScan.nextInt();

        System.out.print("입력? ");
        name[1] = keyScan.next();
        kor[1] = keyScan.nextInt();
        eng[1] = keyScan.nextInt();
        math[1] = keyScan.nextInt();

        System.out.print("입력? ");
        name[2] = keyScan.next();
        kor[2] = keyScan.nextInt();
        eng[2] = keyScan.nextInt();
        math[2] = keyScan.nextInt();

        System.out.print("입력? ");
        name[3] = keyScan.next();
        kor[3] = keyScan.nextInt();
        eng[3] = keyScan.nextInt();
        math[3] = keyScan.nextInt();

        System.out.print("입력? ");
        name[4] = keyScan.next();
        kor[4] = keyScan.nextInt();
        eng[4] = keyScan.nextInt();
        math[4] = keyScan.nextInt();

        
        sum[0] = kor[0] + eng[0] + math[0];
        aver[0] = sum[0] / 3;
        sum[1] = kor[1] + eng[1] + math[1];
        aver[1] = sum[1] / 3;
        sum[2] = kor[2] + eng[2] + math[2];
        aver[2] = sum[2] / 3;
        sum[3] = kor[3] + eng[3] + math[3];
        aver[3] = sum[3] / 3;
        sum[4] = kor[4] + eng[4] + math[4];
        aver[4] = sum[4] / 3;
        
        System.out.println("-----------------------");
        System.out.println(name[0] + " " + kor[0] + " " + eng[0] + " " + 
                            math[0] + " " + sum[0] + " " + aver[0]);
        System.out.println(name[1] + " " + kor[1] + " " + eng[1] + " " + 
                            math[1] + " " + sum[1] + " " + aver[1]);
        System.out.println(name[2] + " " + kor[2] + " " + eng[2] + " " + 
                            math[2] + " " + sum[2] + " " + aver[2]);
        System.out.println(name[3] + " " + kor[3] + " " + eng[3] + " " + 
                            math[3] + " " + sum[3] + " " + aver[3]);
        System.out.println(name[4] + " " + kor[4] + " " + eng[4] + " " + 
                            math[4] + " " + sum[4] + " " + aver[4]);


        }

    }