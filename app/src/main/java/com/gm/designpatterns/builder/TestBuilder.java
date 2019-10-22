package com.gm.designpatterns.builder;

import android.app.AlertDialog;
import android.content.Context;

import com.gm.designpatterns.R;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/21 10:58
 * Description: TestBuilder
 * Company : 北京四维图新科技股份有限公司
 */
public class TestBuilder {

    public static void main(Context context) {
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("标题")
                .setPositiveButton("sure", null)
                .setNegativeButton("cancel", null)
                .create();
//        dialog.show();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10_000)
                .readTimeout(10_000)
                .writeTimeout(10_000)
                .addInterceptor(new OkHttpClient.Interceptor())
                .build();
    }
    }
