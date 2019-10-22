package com.gm.designpatterns.factory;

import android.util.Log;

import java.util.concurrent.Executors;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/14 17:47
 * Description: TestFactory
 * Company : 北京四维图新科技股份有限公司
 */
public class TestFactory {

    public static void main(){
        SimpleFactory simpleFactory=new SimpleFactory();
        simpleFactory.produce("A");

        //客户要产品A
        FactoryA mFactoryA = new FactoryA();
        mFactoryA.produce().showProductName();

        //客户要产品B
        FactoryB mFactoryB = new FactoryB();
        mFactoryB.produce().showProductName();


        /**
         * 线程池-简单工厂
         */
        try {
            ExecutorTest.main();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * 工厂方法模式
         * @see retrofit2.Retrofit
         * @see retrofit2.Converter
         * @see retrofit2.CallAdapter
         */

        //为什么用工厂,
        //工厂是创建型模式,它的作用就是创建对象；
        //关注点 :关注对象创建
        //将对象的创建完全独立出来，让对象的创建和具体的使用客户无关。


        //https://www.cnblogs.com/me115/p/3790615.html
        //工厂与策略模式比较
    }
}
