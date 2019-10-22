package com.gm.designpatterns.adapter;

import android.util.Log;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/14 14:08
 * Description: Socket_Three
 * Company : 北京四维图新科技股份有限公司
 */
public class Socket_Three {
    public void connect() {
        leftConnect();
        rightconnect();
        extraConner();
    }
    public void rightconnect() {
        Log.e("gaom","火线接通...");
    }
    public void leftConnect() {
        Log.e("gaom","零线接通...");
    }
    public void extraConner() {
        Log.e("gaom","地线接通...");
    }
}
