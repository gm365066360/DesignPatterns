package com.gm.designpatterns.strategy;

import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/12 16:02
 * Description: TestStrategy
 * Company : 北京四维图新科技股份有限公司
 */
public class TestStrategy {
    public static double calc(String op, double paramA, double paramB) {
        if ("+".equals(op)) {
            Log.e("gaom ", "执行加法...");
            return paramA + paramB;
        } else if ("-".equals(op)) {
            Log.e("gaom ", "执行减法...");
            return paramA - paramB;
        } else if ("*".equals(op)) {
            Log.e("gaom ", "执行乘法...");
            return paramA * paramB;
        } else if ("/".equals(op)) {
            Log.e("gaom ", "执行除法...");
            if (paramB == 0) {
                throw new IllegalArgumentException("除数不能为0!");
            }
            return paramA / paramB;
        } else {
            throw new IllegalArgumentException("未找到计算方法!");
        }
    }

    public static void main() {
        double paramA = 5;
        double paramB = 2;

        /**
         * 系统中有加减乘除等运算形式
         */
        Log.e("gaom ", "加法结果是：" + calc("+", paramA, paramB));
        Log.e("gaom ", "减法结果是：" + calc("-", paramA, paramB));
        Log.e("gaom ", "乘法结果是：" + calc("*", paramA, paramB));
        Log.e("gaom ", "除法结果是：" + calc("/", paramA, paramB));

        /**
         * 策略模式
         */
        Log.e("gaom ", "加法结果是：" + new Calculator(new Strategy.AddStrategy()).calc(paramA, paramB));
        Log.e("gaom ", "减法结果是：" + new Calculator(new Strategy.SubStrategy()).calc(paramA, paramB));
        Log.e("gaom ", "乘法结果是：" + new Calculator(new Strategy.MultiStrategy()).calc(paramA, paramB));
        Log.e("gaom ", "除法结果是：" + new Calculator(new Strategy.DivStrategy()).calc(paramA, paramB));

        /**
         * 系统的可扩展性增强
         */
        Log.e("gaom ", "求余结果是：" + new Calculator(new Strategy() {
            @Override
            public double calc(double paramA, double paramB) {
                Log.e("gaom ", "执行求余策略...");
                if (paramB == 0) {
                    throw new IllegalArgumentException("除数不能为0!");
                }
                return paramA % paramB;
            }
        }).calc(paramA, paramB));


        /**
         * SDK中的策略模式
         * 动画差值器
         * @see    android.view.animation.Interpolator
         * @see   Animation#setInterpolator(Interpolator)
         */
        Animation animation = new AlphaAnimation(1, 0);
        //系统中已有的策略
        animation.setInterpolator(new AccelerateInterpolator());
        //可扩展的策略
        animation.setInterpolator(new Interpolator() {
            @Override
            public float getInterpolation(float input) {
                return (float) (Math.sin(2 * 1.0f * Math.PI * input));
            }
        });

        /**
         * 对班级中的学生按身高体重年龄等不同的策略进行排序
         */
        ClassA classA = new ClassA();
        ClassA.Student[] students = classA.getStudents();
        classA.sort(students, new ClassA.AgeComparator());
        Log.e("gaom AgeComparator =", Arrays.toString(students));
        classA.sort(students, new ClassA.HeightComparator());
        Log.e("gaom HeightComparator =", Arrays.toString(students));
        classA.sort(students, new ClassA.IComparator<ClassA.Student>() {
            @Override
            public int compare(ClassA.Student o1, ClassA.Student o2) {
                return o1.weight > o2.weight ? 1 : -1;
            }
        });
        Log.e("gaom WeightComparator =", Arrays.toString(students));


        /**
         * JDK中的比较器接口
         * @see     java.util.Comparator
         * @see     java.lang.Comparable
         */

        List<String> list = new ArrayList<String>();
        list.add("beijing");
        list.add("shanghai");
        list.add("hangzhou");
        list.add("anhui");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                // 按首字母升序排
                 return str1.compareTo(str2);
            }
        });
        Log.e("gaom Collections.sort =", Arrays.toString(list.toArray()));
//        E/gaom Collections.sort1 =: [anhui, beijing, hangzhou, shanghai]

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                // 按第二个字母升序排
                char c1 = str1.charAt(1);
                char c2 = str2.charAt(1);
                return c1 - c2;
            }
        });
        Log.e("gaom Collections.sort =", Arrays.toString(list.toArray()));
//        E/gaom Collections.sort2 =: [hangzhou, beijing, shanghai, anhui]
    }


}
