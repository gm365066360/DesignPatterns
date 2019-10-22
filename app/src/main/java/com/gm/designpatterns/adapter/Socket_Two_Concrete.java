package com.gm.designpatterns.adapter;

import android.util.Log;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/14 14:07
 * Description: Socket_Two
 * Company : 北京四维图新科技股份有限公司
 */
public class Socket_Two_Concrete implements Socket_Two{

    @Override
    public void connect() {
        leftConnect();
        rightconnect();
    }

    public void rightconnect() {
        Log.e("gaom","火线接通...");
    }

    public void leftConnect() {
        Log.e("gaom","零线接通...");
    }

}
