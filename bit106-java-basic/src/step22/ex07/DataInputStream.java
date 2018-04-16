// DataInputStream을 FileInputStream이나 ByteArrayInputStream에 붙일 수 있도록
// 기능을 변경한다. 즉, DataInputStream을 장신구(decorator)로 만든다.
package step22.ex07;

import java.io.InputStream;

public class DataInputStream {
    
    InputStream in;
    
    // 생성자?
    // 그 객체가 자신의 역할을 수행하는데 필요한 최소한의 준비작업을 행하는 것이다.
    // 필수 객체나, 필수데이터를 준비하는 것이다.
    // InputStream, 이 값이 없으면 작업을 할 수 없다!
    public DataInputStream(InputStream in) {
        this.in = in; 
    }
    
    public String readUTF() throws Exception {
        // 어떤 InputStream이 넘어 오더라도 그 객체는 read()라는 메서드가 반드시 있다.
        int size = in.read(); 
        byte[] bytes = new byte[size];
        in.read(bytes);
        return new String(bytes, "UTF-8");
    }

    public int readInt() throws Exception {
        int value = 0;
        value = in.read() << 24;
        value += in.read() << 16;
        value += in.read() << 8;
        value += in.read();
        
        return value;
    }
    
    public long readLong() throws Exception {
        long value = 0;
        
        value += (long)in.read() << 56; 
        value += (long)in.read() << 48;
        value += (long)in.read() << 40;
        value += (long)in.read() << 32;
        value += (long)in.read() << 24;
        value += (long)in.read() << 16;
        value += (long)in.read() << 8;
        value += (long)in.read();
        
        return value;
    }
    
    public boolean readBoolean() throws Exception {
        if (in.read() == 1) 
            return true;
        else
            return false;
    }
    
    public void close() throws Exception {
        in.close(); // 생성자에서 받은 InputStream객체 close()
    }
}
