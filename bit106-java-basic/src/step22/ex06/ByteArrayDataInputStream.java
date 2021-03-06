package step22.ex06;

import java.io.ByteArrayInputStream;

public class ByteArrayDataInputStream extends ByteArrayInputStream {

    public ByteArrayDataInputStream(byte[] buf, int offset, int length) {
        super(buf, offset, length);
    }

    public ByteArrayDataInputStream(byte[] buf) {
        super(buf);
    }

    public String readUTF() throws Exception {
        byte[] bytes = new byte[100];
        int size = this.read(); 
        this.read(bytes, 0, size);
        return new String(bytes, 0, size, "UTF-8");
    }

    public int readInt() throws Exception {
        int value = 0;
        value = this.read() << 24;
        value += this.read() << 16;
        value += this.read() << 8;
        value += this.read();
        
        return value;
    }
    
    public long readLong() throws Exception {
        long value = 0;
        
        value += (long)this.read() << 56;
        value += (long)this.read() << 48;
        value += (long)this.read() << 40;
        value += (long)this.read() << 32;
        value += (long)this.read() << 24;
        value += (long)this.read() << 16;
        value += (long)this.read() << 8;
        value += (long)this.read();
        
        return value;
    }
    
    public boolean readBoolean() throws Exception {
        if (this.read() == 1) 
            return true;
        else
            return false;
    }
    
}
