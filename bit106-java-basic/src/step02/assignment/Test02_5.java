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
public class Test02_5 {
    public static void main(String[] args) {
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);

        String[] name = new String[5];
        int[] kor = new int[5];
        int[] eng = new int[5];
        int[] math = new int[5];
        int[] sum = new int[5];
        float[] aver = new float[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("입력? ");
            name[i] = keyScan.next();
            kor[i] = keyScan.nextInt();
            eng[i] = keyScan.nextInt();
            math[i] = keyScan.nextInt();

            sum[i] = kor[i] + eng[i] + math[i];
            aver[i] = sum[i] / 3;
        }

        
        System.out.println("-----------------------");

        for (int i = 0; i < 5; i++) {
        System.out.println(name[i] + " " + kor[i] + " " + eng[i] + " " + 
                            math[i] + " " + sum[i] + " " + aver[i]);
            }
        }

    }