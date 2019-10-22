package com.gm.designpatterns.proxy;

import android.util.Log;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/14 20:06
 * Description: Proxy
 * Company : 北京四维图新科技股份有限公司
 */
public class Proxy implements Callable {

    Callable callable;

    public Proxy(Callable callable) {
        this.callable = callable;
    }

    @Override
    public void call() {
        Log.e("gaom","before...");
        callable.call();
        Log.e("gaom","after...");
    }

}