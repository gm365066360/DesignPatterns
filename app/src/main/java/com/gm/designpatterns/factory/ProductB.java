package com.gm.designpatterns.factory;

import android.util.Log;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/14 17:45
 * Description: ProductA
 * Company : 北京四维图新科技股份有限公司
 */
public class ProductB extends  Product{

    @Override
    void showProductName() {
        Log.e("gaom","生产出了产品B");
    }
}
