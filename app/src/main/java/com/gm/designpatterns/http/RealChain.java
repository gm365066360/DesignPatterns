package com.gm.designpatterns.http;

import java.util.List;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/9/30 18:12
 * Description: RealChain
 * Company : 北京四维图新科技股份有限公司
 */
public class RealChain implements  Chain {
    public static final String CLASS_NAME=RealChain.class.getSimpleName();

    private List<Interceptor> interceptors;
    public int index;
    public String requestString;

    public RealChain(List<Interceptor> interceptors, int index, String requestString) {
        this.interceptors = interceptors;
        this.index = index;
        this.requestString = requestString;
    }

    @Override
    public String process() {
        //<RealChain0>->
        requestString+="<"+CLASS_NAME+index+">"+"->";
        if (index>=interceptors.size()) {return requestString+"[return]";}


        //1.实例化下一个Chain
        RealChain next=new RealChain(
                interceptors,index+1,requestString
        );

        //2.取出当前拦截器Interceptor 并把下一个Chain传递过去
        Interceptor interceptor=interceptors.get(index);

        String response = interceptor.intercept(next,index);

        return response;
    }
}
