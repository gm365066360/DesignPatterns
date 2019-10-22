package com.gm.designpatterns.bridge;

import android.util.Log;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/12 17:38
 * Description: CircularShape
 * Company : 北京四维图新科技股份有限公司
 */
public class CircularShape extends Shape {


    public CircularShape(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        Log.e("gaom", "画圆形");
        color.coloring();
    }
}
