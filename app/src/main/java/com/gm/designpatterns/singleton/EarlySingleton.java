package com.gm.designpatterns.singleton;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/11 14:12
 * Description: EarlySingleton
 * Company : 北京四维图新科技股份有限公司
 */
public class EarlySingleton {
    private static EarlySingleton instance = new EarlySingleton();
    private EarlySingleton() {}
    public static EarlySingleton getInstance() { return instance; }
}
