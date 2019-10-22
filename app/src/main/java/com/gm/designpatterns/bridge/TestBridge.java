package com.gm.designpatterns.bridge;

import java.io.FilterInputStream;
import java.io.InputStream;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/12 17:40
 * Description: TestBridge
 * Company : 北京四维图新科技股份有限公司
 */
public class TestBridge {
    public static void main() {
        //我们要给圆、长方形添加白色或黑色
        //1、实现部分: 我们实现出添加颜色，所以称之为实现部分
        //2、抽象部分: 抽象出具体的事物：图形，具体的图形:圆、长方形。
        Color whiteColor = new WhiteColor();
        Color redColor = new RedColor();
        Shape rectShape = new RectShape(whiteColor);
        Shape circularShape = new CircularShape(redColor);
        rectShape.draw();
        circularShape.draw();

    }
}
