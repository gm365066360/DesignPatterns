package com.gm.designpatterns.adapter;

import android.util.Log;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/14 14:07
 * Description: Computer
 * Company : 北京四维图新科技股份有限公司
 */
public class Computer {
    public void charge(Socket_Two socket_Two) {
        socket_Two.connect();
        addPower();
    }
    private void addPower() {
        Log.e("gaom","电源已连接，充电中...");
    }
}
