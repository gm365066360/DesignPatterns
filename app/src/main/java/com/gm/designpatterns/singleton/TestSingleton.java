package com.gm.designpatterns.singleton;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.gm.designpatterns.R;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/21 16:01
 * Description: TestSingleton
 * Company : 北京四维图新科技股份有限公司
 */
public class TestSingleton {

    public static void main(Context context) {
        EarlySingleton.getInstance();
        LayzilySingleton.getInstance();
        DoubleCheckSingleton.getInstance();
        StaticInnerClassSingleton.getInstance();


        /**
         * SDK中的单例模式
         * @see Context#getSystemService(String)
         */
        //WindowManager获取屏幕宽高
        WindowManager windowManager = (WindowManager)context. getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metric = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metric);
        int windowwidth = metric.widthPixels;
        int windowheight = metric.heightPixels;

        //ClipboardManager实现copy字符串到剪切板
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData mClipData = ClipData.newPlainText("Label", "123");
        clipboardManager.setPrimaryClip(mClipData);

        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_main, null);
    }
}
