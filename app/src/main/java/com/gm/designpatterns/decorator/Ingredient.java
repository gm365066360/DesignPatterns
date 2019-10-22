package com.gm.designpatterns.decorator;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/13 21:15
 * Description: Drink
 * Company : 北京四维图新科技股份有限公司
 */
public abstract  class Ingredient extends Drink{
    Drink drink;

    public Ingredient(Drink drink) {
        this.drink=drink;
    }


    @Override
    public String getDesc() {
        return "["+desc+"]"+drink.getDesc();
    }


}
