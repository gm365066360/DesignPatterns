package com.gm.designpatterns.observer;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/12 14:15
 * Description: TestStrategy
 * Company : 北京四维图新科技股份有限公司
 */
public class TestObserver {

    //假设隔壁王大爷有个古老的水壶,烧水时需要人在旁一直看着,等水开再去干其他事情.
    //王大爷去淘宝买了个更高级一点的水壶, 水开报警, 王大爷可以在烧水的时候去做其他事情了.

    public static void main() {
        /**
         * JDK Observable被观察者 & Observer观察者
         */
        NumObservable number = new NumObservable();
        number.addObserver(new NumObserver());
        number.setData(1);
        number.setData(2);
        number.setData(3);
//        E/gaom: Data has changed to 1
//        E/gaom: Data has changed to 2
//        E/gaom: Data has changed to 3

        /**
         * 回调与观察者模式
         */
        ClassA classA = new ClassA();
        classA.register(new CallBack() {
            @Override
            public void onCall() {
                System.out.println("回调函数被调用");
            }
        });
        classA.call();
        /**
         * 插一个话题, java无法将一个函数作为参数进行传递,代替是用接口实现
         * lambda(兰布达)表达式看似传递一个匿名方法,实际上只是简化显示
         */
        classA.register(() -> System.out.println("回调函数被调用"));


        //其他语言 python举例 函数作为参数传递
        /*
       //以下为 .py文件中代码:
         from functools import reduce

         #定义一个add方法
         def add(x, y):
                return x + y


         # 将add方法传入reduce方法, 同样传递一个数组
         m = reduce(add, [1, 3, 5, 7, 9])
         print(m)
         # 25

         # map
         m = map(lambda x: x * x, [1, 2, 3, 4])
         print(m)
         # [1, 4, 9, 16]

         */
    }


    public interface CallBack {
        void onCall();
    }

    public static class ClassA {
        private CallBack callback;

        void register(CallBack callback) {
            this.callback = callback;
        }

        void call() {
            callback.onCall();
        }
    }
}
