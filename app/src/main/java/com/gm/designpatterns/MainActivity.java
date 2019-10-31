package com.gm.designpatterns;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gm.designpatterns.adapter.TestAdapter;
import com.gm.designpatterns.bridge.TestBridge;
import com.gm.designpatterns.builder.TestBuilder;
import com.gm.designpatterns.command.TestCommand;
import com.gm.designpatterns.decorator.TestDecorator;
import com.gm.designpatterns.factory.TestFactory;
import com.gm.designpatterns.flyweight.TestFlyweight;
import com.gm.designpatterns.mvp.DetailActivity;
import com.gm.designpatterns.okhttpchain.Test;
import com.gm.designpatterns.iterator.TestIterator;
import com.gm.designpatterns.observer.TestObserver;
import com.gm.designpatterns.proxy.TestProxy;
import com.gm.designpatterns.singleton.TestSingleton;
import com.gm.designpatterns.strategy.TestStrategy;

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

        //享元
        TestFlyweight.main();

        //Command命令
        new TestCommand().main(this);

        //Bridge桥
        TestBridge.main();

        //Adapter适配器
        TestAdapter.main();
    }

    public void detail(View view) {
        startActivity(new Intent(this, DetailActivity.class));
    }
}
