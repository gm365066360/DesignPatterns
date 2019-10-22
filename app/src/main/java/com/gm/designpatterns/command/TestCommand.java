package com.gm.designpatterns.command;

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
    public  Context context;
    public   void main(Context context) {
        this.context=context;
        Invoker invoker = new Invoker();
        Light light = new Light();
        LightOnCommand loc = new LightOnCommand(light);
        invoker.setCommand(loc);
        invoker.buttonPressed();

        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        Log.e("gaom","msg.arg1="+msg.arg1);
                        break;
                    default:
                }
            }
        };
        Message message = handler.obtainMessage();
        message.what=1;
        message.arg1=2;
        handler.sendMessage(message);

        new Thread(){
            @Override
            public void run() {
                super.run();
                Looper.prepare();
                Toast.makeText(TestCommand.this.context, Thread.currentThread().getName() , Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        }.start();

        //参考class ActivityThread . main()方法
    }

//    命令角色：Message
//    调用者：Looper
//    接受者：Handler
//    客户端: 创建Message(命令角色)并绑定Handler（接受者）。

    class Handler1 {
      void   sendMessage(Message msg){
//            msg.target = this;
//            queue.enqueueMessage(msg);
        }
    }

    class  Message1 {
        Handler target;
    }

    class  Looper1 {
        void  loop(){
            while (true) {
//                Message msg = queue.next();
//                msg.target.dispatchMessage(msg);
            }
        }
    }

}
