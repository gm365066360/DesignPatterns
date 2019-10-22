package com.gm.designpatterns.decorator;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/13 21:16
 * Description: Milk
 * Company : 北京四维图新科技股份有限公司
 */
public class Milk extends Ingredient {


    public Milk(Drink drink) {
        super(drink);
        desc = "牛奶";
    }

    @Override
    public float getCost(){
        return 4f +drink.getCost();
    }
}
