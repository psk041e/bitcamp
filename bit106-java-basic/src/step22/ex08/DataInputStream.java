// InputStream에 붙이는 플러그인(decorator)을 다른 플러그인에 붙이려면,
// 플러그인(decorator) 클래스도 InputStream의 가족이 되어야 한다.
package step22.ex08;

import java.io.IOException;
import java.io.InputStream;

// 이 상속은 기능을 상속 받기 위한 것이 아니다.
// 같은 그룹으로 묶기 위함이다.
public class DataInputStream extends InputStream {
    
    InputStream in;
    
    // 생성자?
    // 그 객체가 자신의 역할을 수행하는데 필요한 최소한의 준비작업을 행하는 것이다.
    // 필수 객체나, 필수데이터를 준비하는 것이다.
    // InputStream, 이 값이 없으면 작업을 할 수 없다!
    public DataInputStream(InputStream in) {
        this.in = in; 
    }
    
    @Override
    public int read() throws IOException {
        // 상속 받은 read() 추상메서드이기 때문에 구현하였지만,
        // 플러그인으로서 사용되는 이 클래스 입장에서는
        // 아무런 일도 하지 않는다.
        return in.read(); // 생성자에서 입력받은 read()메서드를 호출한다.
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
    
    @Override
    public void close() throws IOException {
        in.close(); // 생성자에서 받은 InputStream객체 close()
    }

}
