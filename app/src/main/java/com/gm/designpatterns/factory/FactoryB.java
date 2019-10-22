package com.gm.designpatterns.factory;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/14 17:46
 * Description: FactoryA
 * Company : 北京四维图新科技股份有限公司
 */
public class FactoryB extends Factory{

    @Override
    Product produce() {
        return new ProductB();
    }
}
