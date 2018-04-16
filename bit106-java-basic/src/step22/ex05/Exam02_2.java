// 버퍼 사용 후 - 파일 복사 및 시간 측정
package step22.ex05;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam02_2 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/jls8.pdf");
        FileOutputStream out = new FileOutputStream("temp/jls8_3.pdf");
        
        byte[] buf = new byte[8196]; // 보통 8KB 정도 메모리를 준비한다.
        // 그러다면 버퍼크기를 한번에 크게 잡으면 더 빨리 읽을 수 있지 않은가?
        // => 서버인 경우 많은 사람들이 한번에 서버에서 데이터를 읽는다고 할 때
        //    
        int count = 0;
        
        long startTime = System.currentTimeMillis(); // 밀리초
        
        while ((count = in.read(buf)) != -1) {
            for (int i = 0; i < count; i++) 
                out.write(buf, 0, count);
        }; // 파일을 끝까지 읽는다.
        
        long endTime = System.currentTimeMillis();
        
        System.out.println(endTime - startTime);
        
        in.close();
        out.close();
    }
}

//데이터 읽기 시간 = average seek time + data transfer time
//퀀텀 HDD 예)
//average seek time = 0.0105초
//data transfer time = 0.00000005초 / 1 byte당
//
//1000 바이트 읽을 때
//1) 1 바이트를 1000번 읽는 경우
// 0.01050005초 * 1000 byte = 10.50005초
//2) 1000 바이트 한 번 읽는 경우
// 0.0105초 * 0.00000005초 * 1000 byte = 0.01055초
//1 바이트를 여러 번 읽을 경우 매번 바이트의 위치를 찾아야 하기 때문에 
//평균 탐색 시간이 누적되어 한 번에 1000 바이트를 읽는 것 보다 시간이 오래 걸린다.
//
//그러면 RAM에 배열의 크기를 크게 잡으면 좋지 않겠는가?
//=> PC 처럼 소수의 프로그램이 동시에 실행될 때는 상관 없지만,
// 서버처럼 동시에 데이터를 읽는 코드가 동시에 수천개에서 수십만개일 때는
// 아무리 작은 크기의 메모리라도 매우 많아지게 된다.
// 그래서 보통 8KB 정도의 버퍼 크기를 유지하고 있다.
//=> 물론 프로그램의 용도나 목적에 따라 버퍼의 크기가 이보다 더 작아지거나,
// 커질 수 있다.


