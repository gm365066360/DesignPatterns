package com.gm.designpatterns.factory;

import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/14 18:01
 * Description: ExecutorTest
 * Company : 北京四维图新科技股份有限公司
 */
public class ExecutorTest {
    private static Integer num = 1;
    private static boolean exeFlag = true;

    //简单工厂 创建与使用分离
    public static void main() throws InterruptedException {
        //初始化3个 超过3个堵塞
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        while (exeFlag){
            if(num <=10){
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("gaom","第" + num + "个 currentThreadName="+Thread.currentThread().getName());
                        num++;
                    }
                });
            }else{
                if(((ThreadPoolExecutor)executorService).getActiveCount()==0){
                    executorService.shutdown();//关闭executors
                    exeFlag=false;
                    Log.e("gaom","任务结束！");
                }
            }
            Thread.sleep(100);
        }
    }
}
