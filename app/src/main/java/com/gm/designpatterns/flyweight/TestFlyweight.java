package com.gm.designpatterns.flyweight;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.ArrayList;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/24 17:41
 * Description: TestFlyweight
 * Company : 北京四维图新科技股份有限公司
 */
public class TestFlyweight {

    public static void main() {
        /**
         * @see android.os.Message#obtain()
         */
        //例子1
        Message msg = Message.obtain();
        new Handler().sendMessage(msg);
        new Handler().dispatchMessage(msg);

        //例子2
        //JVM中字符串一般保存在字符串常量池中
        String str1 = "abcd";
        String str2 = "abcd";
        String str3 = "ab" + "cd";
        String str4 = "ab" + new String("cd");
        Log.e("gaomstring ",""+(str1 == str2));
        //true

        Log.e("gaomstring ",""+(str1 == str3));
        //true

        Log.e("gaomstring ",""+(str1 == str4));
        //false


        //参考: https://blog.csdn.net/wwwdc1012/article/details/82833965
    }
}
