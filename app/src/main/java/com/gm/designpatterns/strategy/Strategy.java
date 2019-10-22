package com.gm.designpatterns.strategy;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/12 16:00
 * Description: Strategy
 * Company : 北京四维图新科技股份有限公司
 */
public interface Strategy {

    double calc(double paramA, double paramB);

    //加法的具体实现策略
    public class AddStrategy implements Strategy {
        @Override
        public double calc(double paramA, double paramB) {
            System.out.println("执行加法策略...");
            return paramA + paramB;
        }
    }

    //减法的具体实现策略
    public class SubStrategy implements Strategy {
        @Override
        public double calc(double paramA, double paramB) {
            System.out.println("执行减法策略...");
            return paramA - paramB;
        }
    }

    //乘法的具体实现策略
    public class MultiStrategy implements Strategy {
        @Override
        public double calc(double paramA, double paramB) {
            System.out.println("执行乘法策略...");
            return paramA * paramB;
        }
    }

    //除法的具体实现策略
    public class DivStrategy implements Strategy {
        @Override
        public double calc(double paramA, double paramB) {
            System.out.println("执行除法策略...");
            if (paramB == 0) {
                throw new IllegalArgumentException("除数不能为0!");
            }
            return paramA / paramB;
        }
    }


}
