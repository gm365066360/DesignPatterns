package com.gm.designpatterns.okhttpchain;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/9/30 18:17
 * Description: RealInterceptor
 * Company : 北京四维图新科技股份有限公司
 */
public class RealInterceptor implements Interceptor{

    public static final String CLASS_NAME=RealInterceptor.class.getSimpleName();

    @Override
    public String intercept(Chain chain,int index) {
        RealChain realInterceptorChain= (RealChain) chain;
        //[RealInterceptor0]->
        realInterceptorChain.requestString+= "["+CLASS_NAME+index+"]"+"->";
        String response = realInterceptorChain.process();
        return response;
    }
}
