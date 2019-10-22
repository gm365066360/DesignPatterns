package com.gm.designpatterns.factory;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/14 17:44
 * Description: Factory
 * Company : 北京四维图新科技股份有限公司
 */
public class SimpleFactory {

    //1 违背对修改封闭 对扩展开放
    //2 高层依赖低层 违背依赖倒置原则
    public Product produce(String productName) {
        switch (productName) {
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            default:
                return new ProductA();
        }
    }

}
