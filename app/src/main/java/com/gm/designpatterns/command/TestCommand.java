package com.gm.designpatterns.command;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import java.util.Observable;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/12 13:25
 * Description: TestStrategy
 * Company : 北京四维图新科技股份有限公司
 */
public class TestCommand {

    public Context context;

    public void main(Context context) {
        this.context = context;

//        调用者：   Invoker
//        命令角色： Command
//        接受者：   Receiver

        Invoker invoker = new Invoker();
        Light light = new Light();
        LightOnCommand loc = new LightOnCommand(light);
        invoker.setCommand(loc);
        invoker.buttonPressed();


        @SuppressLint("HandlerLeak")
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        Log.e("gaom", "msg.arg1=" + msg.arg1);
                        break;
                    default:
                }
            }
        };
        Message message = handler.obtainMessage();
        message.what = 1;
        message.arg1 = 2;
        handler.sendMessage(message);
        handler.dispatchMessage(message);

        /**
         * handler loop message 关系
         * @see  ActivityThread  6623
         *
         * @see android.os.Handler#Handler -> 1. mLooper = Looper.myLooper();  2. mQueue = mLooper.mQueue;
         * @see android.os.Handler#sendMessage  -> 1.queue.enqueueMessage(msg) 2. msg.target = this;
         *
         * @see android.os.Looper#loop
         * 1.for (;;) 2.Message msg = queue.next(); 3.msg.target.dispatchMessage(msg);
         *
         * @see android.os.Message#obtain
         */

        /**
         * @see Looper#loop 几个疑问
         * 1.msg.target.dispatchMessage(msg);  我在我的系统中调用你的系统中的我,然后把你传过去
         * 2.for死循环为什么不阻塞主线程
         * 3.Handler#sendMessage 与 Handler#dispatchMessage 这些方法的异同
         * 4.Looper.prepare();
         * 5.handler如何切换线程
         */


        /**/
//        调用者：Looper
//        命令角色：Message
//        接受者：Handler
//        客户端: 创建Message(命令角色)并绑定Handler（接受者）。

//        调用者：Invoker invoker = new Invoker();
//        命令角色：LightOnCommand loc = new LightOnCommand(light);
//        接受者：Light light = new Light();

//        invoker.setCommand(loc);
//        invoker.buttonPressed();


        //子线程如何showToast
        new Thread() {
            @Override
            public void run() {
                super.run();
                Looper.prepare();
                Toast.makeText(TestCommand.this.context, Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        }.start();

        /**
         * 因为
         * @see Toast.TN#mHandler
         * @see Toast.TN#show
         */

    }

//    命令角色：Message
//    调用者：Looper
//    接受者：Handler
//    客户端: 创建Message(命令角色)并绑定Handler（接受者）。

    //调用者
    class Looper1 {
        void loop() {
            while (true) {
//                Message msg = queue.next();
//                msg.target.dispatchMessage(msg);
            }
        }
    }

    //命令角色
    class Message1 {
        Handler target;
    }

    //接受者
    class Handler1 {
        void sendMessage(Message msg) {
//            msg.target = this;
//            queue.enqueueMessage(msg);
        }
    }


}
