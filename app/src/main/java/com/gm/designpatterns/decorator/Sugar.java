package com.gm.designpatterns.decorator;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/13 21:16
 * Description: Milk
 * Company : 北京四维图新科技股份有限公司
 */
public class Sugar extends Ingredient {


    public Sugar(Drink drink) {
        super(drink);
        desc = "焦糖";
    }

    @Override
    public float getCost(){
        return 3f +drink.getCost();
    }

}
