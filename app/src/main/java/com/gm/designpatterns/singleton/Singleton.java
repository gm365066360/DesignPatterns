package com.gm.designpatterns.singleton;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/11 14:12
 * Description: EarlySingleton
 * Company : 北京四维图新科技股份有限公司
 */
public class Singleton {
    private Singleton() {
    }
    private static class SingletonHolder {
        private final static Singleton instance = new Singleton();
    }
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
