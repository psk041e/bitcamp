package step02.assignment;
// 1단계: 1명의 성적 데이터 입력 받아서 처리하기
// 2단계: 여러 명의 성적 정보를 받아서 처리하기
// 3단계: 변수 선언을 모아서 일괄적으로 처리하기
// 4단계: 배열을 사용하여 같은 종류의 
// 5단계: 
public class Test02 {
    public static void main(String[] args) {
        
        // 사용할 변수를 먼저 선언한다.
        // 배열을 사용하면 같은 종류의 메모리를 아주 간단하게 만들 수 있다.
        String[] name = new String[5];
        int[] kor = new int[5];
        int[] eng = new int[5];
        int[] math = new int[5];
        int[] sum = new int[5];
        float[] aver = new float[5];
        
        java.io.InputStream keyboard = System.in;
        java.util.Scanner keyScan = new java.util.Scanner(keyboard);

        for (int i = 0; i < 5; i++) {
            // next();
            // 전체를 리턴하는 것이 아니라 
            // 공백문자를 만나면 그 앞부분의 값을 리턴해준다.
            System.out.print("입력? ");
            name[i] = keyScan.next();
            kor[i] = keyScan.nextInt();
            eng[i] = keyScan.nextInt();
            math[i] = keyScan.nextInt();

            sum[i] = kor[i] + eng[i] + math[i];
            aver[i] = (float)(sum[i] / 3);
        }

        System.out.println("-------------");

        for (int i = 0; i < 5; i++) {
            System.out.println(name[i] + " " + kor[i] + " " + eng[i] + " "
                         + math[i] + " " + sum[i] + " " + aver[i]);
        }

    }
}