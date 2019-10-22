package com.gm.designpatterns.proxy;

import android.util.Log;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/14 20:05
 * Description: Target
 * Company : 北京四维图新科技股份有限公司
 */
public class Target implements Callable {

    @Override
    public void call() {
        Log.e("gaom","call...");
    }

}
