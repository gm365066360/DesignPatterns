package com.gm.designpatterns.proxy;

import android.util.Log;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/14 20:07
 * Description: TestProxy
 * Company : 北京四维图新科技股份有限公司
 */
public class TestProxy {

    public static void main() {
        Callable target = new Target();
        Callable proxy = new Proxy(target);
        proxy.call();

        /**
         * JDK中的代理模式
         * Thread与Runnable
         */
        Runnable target1 = new MyRunnable();
        Thread proxy1 = new Thread(target1);
        proxy1.start();

        /**
         * @see     Thread#run()
         */



        /**
         * 动态代理
         * @see retrofit2.Retrofit#create(Class)
         */
    }


   static class MyRunnable implements Runnable {

        @Override
        public void run() {
            Log.e("gaom","MyRunnable run...");
        }
    }
}
