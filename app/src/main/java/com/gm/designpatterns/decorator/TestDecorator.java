package com.gm.designpatterns.decorator;

import android.os.Environment;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;

import com.gm.designpatterns.strategy.Calculator;
import com.gm.designpatterns.strategy.Strategy;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/12 16:02
 * Description: TestStrategy
 * Company : 北京四维图新科技股份有限公司
 */
public class TestDecorator {
    public static void main() {
        /**
         *  Starbucks
         */
        //点美式 (清咖,无糖无奶)
        Coffee coffee2 = new Coffee("美式");
        Log.e("gaom", "总价:" + coffee2.getCost() + " 详细:" + coffee2.getDesc());
        //E/gaom: 总价:5.0 详细:[美式]咖啡

        //加牛奶 (latte)
        Drink milk = new Milk(coffee2);
        Log.e("gaom", "总价:" + milk.getCost() + " 详细:" + milk.getDesc());
        //E/gaom: 总价:9.0 详细:[牛奶][美式]咖啡

        //加糖(焦糖拿铁)
        Drink sugar = new Sugar(milk);
        Log.e("gaom", "总价:" + sugar.getCost() + " 详细:" + sugar.getDesc());
        //E/gaom: 总价:12.0 详细:[焦糖][牛奶][美式]咖啡

        //加冰
        Drink iceWater = new IceWater(sugar);
        Log.e("gaom", "总价:" + iceWater.getCost() + " 详细:" + iceWater.getDesc());
        //E/gaom: 总价:14.0 详细:[加冰][焦糖][牛奶][美式]咖啡

        //服务员受不了了, 一口气点完
        Drink drink = new IceWater(new Sugar(new Milk(new Coffee("美式"))));
        Log.e("gaom", "总价:" + drink.getCost() + " 详细:" + drink.getDesc());
        //E/gaom: 总价:14.0 详细:[加冰][焦糖][牛奶][美式]咖啡



        /**
         * 装饰器模式=组合+继承
         */

        /**
         * jdk中的装饰器模式
         * @see InputStream
         * @see FileInputStream(被装饰者)
         * @see java.io.FilterInputStream(装饰者)
         * @see java.io.BufferedInputStream(real装饰者)
         */
        File file = new File( Environment.getExternalStorageDirectory()+"/decorator.txt" );

        int c = 0;
        try {
            StringBuilder stringBuilder=new StringBuilder();
            InputStream inputStream =    new BufferedInputStream( new FileInputStream( file ) );
            while ((c = inputStream.read()) != -1) {
                stringBuilder.append((char) c);
            }
            Log.e("gaom",stringBuilder.toString());
            //E/gaom: ABCDefgHijkLmn
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 实现小写转换。
        try {
            StringBuilder stringBuilder=new StringBuilder();
            InputStream inputStream = new LowerCaseInputStream( new BufferedInputStream( new FileInputStream( file ) ) );
            while ((c = inputStream.read()) != -1) {
                stringBuilder.append((char) c);
            }
            Log.e("gaom",stringBuilder.toString());
            // E/gaom: abcdefghijklmn
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


//  类结构分析:
//                                                 [abs] InputStream
//       -[abs] FilterInputStream (装饰者)                             - FileInputStream (被装饰者)
//       - LowerCaseInputStream  BufferedInputStream

    }


}
