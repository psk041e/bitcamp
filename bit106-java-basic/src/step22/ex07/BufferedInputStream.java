package step22.ex07;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStream{
    
    InputStream in;
    
    byte[] buf = new byte[8196];
    int size; // 배열에 저장되어 있는 바이트의 수
    int cursor; // 바이트를 읽은 배열의 위치
    
    public BufferedInputStream(InputStream in) {
        this.in = in;
    }
    
    public int read() throws IOException {
        if (cursor == size) { // 버퍼에 저장되어 있는 데이터를 모두 읽었다는 의미
                              // 새로 읽어온다.
            size = in.read(buf); // 버퍼 크기만큼 읽어와라
            if (size == -1) { // 파일에서 데이터를 읽으려했는데 데이터가 없다. 
                                                  // (파일을 다 읽었다.)
                return -1;
            }
            cursor = 0;
        }
        return 0x000000ff & buf[cursor++]; // 버퍼에 현재 커서의 값을 리턴한 후 하나를 증가시킨다.
                                            // & : 둘다 0일때만 0이다. 앞의3 자리가 0이면 0이다.
    }

    public void close() throws IOException {
        in.close();
    }
    
}
