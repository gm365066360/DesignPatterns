package com.gm.designpatterns.bridge;

import android.util.Log;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/12 17:34
 * Description: Color
 * Company : 北京四维图新科技股份有限公司
 */
public class RedColor implements Color{
    @Override
    public void coloring() {
        Log.e("gaom","红色");
    }
}
