// 키보드 입력 받기
package step02; 
// src.step02 (X) scr는 소스파일을 두는 폴더 소스 밑에있는것이 패키지


public class Exam02_1 {
    public static void main(String[] args) {
        // 키보드 정보를 가져온다.
        java.io.InputStream keyborad = System.in;
        Scanner sc = new Scanner(System.in);

        // 키보드에서 값을 꺼내주는 도구를 연결한다.
        java.util.Scanner keyScan = new java.util.Scanner(keyborad);
        // 새로 스캐너를 만들어라, 이 스캐너는 키보드가 입력한값을 꺼내준다.

        // print()는 문자열을 출력한 후 줄바꿈을 하지 않는다.
        System.out.print("팀명? "); 

        // nextLine()
        // - Scanner 도구를 사용하여 키보드로부터 입력된 데이터를 읽어서
        //   한 줄의 문자열을 가져올때 사용하는 명령이다.
        // - 동작은?
        //   사용자가 한 줄 입력할 때까지,
        //   즉 입력 데이터에 줄바꿈을 의미하는 0D0A 2byte가 들어올 때까지 대기한다.
        //   사용자가 enter키를 누르면 입력값으로 0D0A 2byte 값이 들어오고,
        //   nextLine()은 비로서 사용자가 입력한 값을 리턴한다.
        // - 그 리턴값을 println() 명령을 사용하여 콘솔로 출력한다. 
        System.out.println(keyScan.nextLine());
        
    }
}

// System.out
// - 표준 출력장치.
// - 즉 콘솔(모니터, 명령창)을 가리킨다.
// System.in
// - 표준 입력장치
// - 즉 키보드를 가리킨다.