package com.gm.designpatterns.okhttpchain;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/9/30 18:19
 * Description: TestStrategy
 * Company : 北京四维图新科技股份有限公司
 */
public class Test {

    public static void main() {
        String request="测试责任链模式:";
        List<Interceptor> interceptors=new ArrayList<>();
        interceptors.add(new RealInterceptor());
        interceptors.add(new RealInterceptor());
        interceptors.add(new RealInterceptor());
        interceptors.add(new RealInterceptor());

        RealChain chain=new RealChain(interceptors,0,request);
        String response = chain.process();
        Log.e("gaom response=",response);

        /**
         * @see okhttp3.RealCall
         * @see okhttp3.internal.http.RealInterceptorChain
         * @see okhttp3.internal.cache.CacheInterceptor
         */
    }
}
