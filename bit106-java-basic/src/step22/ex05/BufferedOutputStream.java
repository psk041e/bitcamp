package step22.ex05;

import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStream extends FileOutputStream {
    byte[] buf = new byte[8196];
    int cursor;
    
    public BufferedOutputStream(String filename) throws Exception {
        super(filename);
    }
    
    @Override
    public void write(int b) throws IOException {
        if (cursor == buf.length) { // 버퍼가 다 차면
            this.write(buf); // 버퍼에 들어있는 데이터를 한 번에 출력한다.
            cursor = 0; // 다시 커서를 초기화시킨다.
        }
    
        // 1바이트 출력하라고 하면 일단 버퍼에 저장할 것이다.
        buf[cursor++] = (byte) b;
    }
    
    @Override
    public void close() throws IOException {
        this.flush();
        super.close();
    }
    
    // close하지 않아도 현제 데이터에 남아있는 내용이 있으면 출력하라!
    // flush() -> 방출하라.
    public void flush() throws IOException { // 버퍼에 있는 내용을 강제로 비우는 일을 한다.
        if (cursor > 0) { // 버퍼에 데이터가 1byte라도 있다.
            this.write(buf, 0, cursor);
            // cursor가 10이면 0에서 9까지 10개가 들어가있다.
            // cursor개-> 빈 방을 가리키는 것이기 때문에 값자체가 입력된 값의 갯수이다.
        }
    }
    
    
    
    
}
