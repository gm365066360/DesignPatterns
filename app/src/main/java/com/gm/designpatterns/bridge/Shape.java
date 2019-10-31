package com.gm.designpatterns.bridge;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/12 17:34
 * Description: Color
 * Company : 北京四维图新科技股份有限公司
 */
public abstract class Shape {
    protected Color color;
    public Shape(Color color) {
        this.color = color;
    }

    public abstract void draw();
}
