package com.gm.designpatterns.decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/13 9:03
 * Description: LowerCaseInputStream
 * Company : 北京四维图新科技股份有限公司
 */
public class LowerCaseInputStream extends FilterInputStream {

    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1)?c:Character.toLowerCase((char)c);
    }

}