package com.gm.designpatterns;


import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.gm.designpatterns.adapter.TestAdapter;
import com.gm.designpatterns.bridge.TestBridge;
import com.gm.designpatterns.builder.OkHttpClient;
import com.gm.designpatterns.builder.TestBuilder;
import com.gm.designpatterns.command.TestCommand;
import com.gm.designpatterns.decorator.TestDecorator;
import com.gm.designpatterns.factory.TestFactory;
import com.gm.designpatterns.http.Test;
import com.gm.designpatterns.iterator.TestIterator;
import com.gm.designpatterns.observer.NumObservable;
import com.gm.designpatterns.observer.NumObserver;
import com.gm.designpatterns.observer.TestObserver;
import com.gm.designpatterns.proxy.TestProxy;
import com.gm.designpatterns.singleton.Singleton;
import com.gm.designpatterns.singleton.TestSingleton;
import com.gm.designpatterns.strategy.TestStrategy;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Singleton单例
        TestSingleton.main(this);


        //Builder建造者
        TestBuilder.main(this);

        //Observer观察者
        TestObserver.main();

        //Iterator迭代器
        TestIterator.main();

        //Strategy策略
        TestStrategy.main();

        //Factory工厂
        TestFactory.main();

        //Proxy代理
        TestProxy.main();

        //Decorator装饰器
        TestDecorator.main();

        //责任链
        Test.main();

        /**
         * 命令模式会在我的下次分享中与大家分析
         * @see android.os.Handler
         * @see android.os.Looper
         * @see android.os.Message
         */
        //Command命令
        new TestCommand().main(this);

        /**
        * 以下模式由于个人能力, 不与大家分享了
        * 感兴趣同学可以参看相应demo
        */
        //Bridge桥
        TestBridge.main();
        //Adapter适配器
        TestAdapter.main();
    }
}
