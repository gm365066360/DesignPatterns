package com.gm.designpatterns.singleton;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/11 14:12
 * Description: EarlySingleton
 * Company : 北京四维图新科技股份有限公司
 */
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton() {
    }
    private static class SingletonHolder {
        private final static StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }
    public static StaticInnerClassSingleton getInstance() {
        return StaticInnerClassSingleton.SingletonHolder.instance;
    }
}
