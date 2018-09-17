package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class da extends JceStruct {
    public int result = 0;

    public void readFrom(JceInputStream jceInputStream) {
        this.result = jceInputStream.read(this.result, 0, false);
    }

    public void writeTo(JceOutputStream jceOutputStream) {
        if (this.result != 0) {
            jceOutputStream.write(this.result, 0);
        }
    }
}
