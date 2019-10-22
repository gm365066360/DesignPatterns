package com.gm.designpatterns.adapter.newsys;

import android.util.Log;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/14 14:07
 * Description: Computer
 * Company : 北京四维图新科技股份有限公司
 */
public class NewComputer {
    public void charge(BaseAdapter baseAdapter) {
        String s="新型电脑";

        s=baseAdapter.leftConnect(s);
        s=baseAdapter.rightConnect(s);
        Log.e("gaom",s);
        addPower();
    }
    private void addPower() {
        Log.e("gaom","电源已连接，充电中...");
    }
}
