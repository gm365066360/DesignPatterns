package com.gm.designpatterns.interceptor;

import java.util.ArrayDeque;
import java.util.Queue;


/**
 * @author gaoming2@autoai.com
 * @des 登录等行为拦截器
 * @date 2019/9/30
 *  question: 1
 */
public class Interceptor {

    //拦截器Queue
    private Queue<Intercept> interceptQueue = new ArrayDeque<>();
    //上一个拦截器
    private Intercept lastIntercept;
    private ActionCallBack callBack;


    //单例
    public static Interceptor getInstance() {
        return SingletonHolder.mInstance;
    }

    private static class SingletonHolder {
        private static Interceptor mInstance = new Interceptor();
    }

    //最终目的
    public interface ActionCallBack {
        void proceed();
    }

    //拦截器
    public interface Intercept {
        boolean verifyPermission();

        void requestPermission();
    }

    public class InterceptUnit{
        Interceptor interceptor;

        public InterceptUnit(Interceptor interceptor) {
            this.interceptor = interceptor;
        }

        public InterceptUnit addIntercept(Intercept intercept) {
            //只添加有效拦截器
            if (intercept.verifyPermission()) {
                return this;
            }
            interceptQueue.add(intercept);
            return this;
        }

        //开始执行
        public void action() {
            interceptor.execute();
        }

    }



    public InterceptUnit setActionCallBack(ActionCallBack callBack) {
        clear();
        this.callBack = callBack;
        return new InterceptUnit(this);
    }


    //执行
    public void execute() {

        //如果上一条valid难没有通过，执行拦截
        if (lastIntercept != null && !lastIntercept.verifyPermission()) {
            return;
        }

        //最后目的
        if (interceptQueue.size() == 0 && callBack != null) {
            callBack.proceed();
            //清空
            clear();
        } else {
            //执行拦截
            Intercept intercept = interceptQueue.poll();
            lastIntercept = intercept;
            if (intercept != null) {
                intercept.requestPermission();
            }
        }

    }

    private void clear() {
        interceptQueue.clear();
        lastIntercept = null;
        callBack = null;
    }


}
