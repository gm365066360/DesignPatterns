package com.gm.designpatterns.strategy;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/12 16:03
 * Description: Calculator
 * Company : 北京四维图新科技股份有限公司
 */
public class Calculator {
    private Strategy strategy;

    public Calculator(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public double calc(double paramA, double paramB) {
        if (this.strategy == null) {
            throw new IllegalStateException("你还没有设置计算的策略");
        }
        return this.strategy.calc(paramA, paramB);
    }
}
