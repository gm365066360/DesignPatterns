package com.gm.designpatterns.decorator;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/13 21:15
 * Description: Drink
 * Company : 北京四维图新科技股份有限公司
 */
public abstract class Drink {

    String desc = "Unknown Drink";
    float cost;

    public abstract float getCost();

    public String getDesc(){
        return desc;
    }
}
/**
 * 类结构分析
 *                         abs  Drink
 *                           - getCost()
 * abs Ingredient(装饰者)                                class Coffee (被装饰者)
 * - Ingredient(Drink drink)                             - cost=5f
 *                                                       - desc=name+咖啡
 *
 * class IceWater  class Milk  class Sugar
 * 2f              4f          3f
 *
 *
 */

