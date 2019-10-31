package com.gm.designpatterns.okhttpchain;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/9/30 18:10
 * Description: Interceptor
 * Company : 北京四维图新科技股份有限公司
 */
public interface Interceptor {
    String intercept(Chain chain,int index);
}
