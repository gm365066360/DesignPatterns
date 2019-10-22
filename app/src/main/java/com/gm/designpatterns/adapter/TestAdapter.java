package com.gm.designpatterns.adapter;

import android.util.Log;

import com.gm.designpatterns.adapter.newsys.BaseAdapter;
import com.gm.designpatterns.adapter.newsys.NewComputer;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/14 14:09
 * Description: TestAdapter
 * Company : 北京四维图新科技股份有限公司
 */
public class TestAdapter {
    public static void main() {
        //原系统
        Computer computer=new Computer();
        Socket_Two_Concrete socket_two_concrete=new Socket_Two_Concrete();
        computer.charge(socket_two_concrete);

        //新增三孔进行适配
        Log.e("gaom","使用适配器：");
        Socket_Three socket_three=new Socket_Three();
        //调用适配器类来完成适配
        SocketAdapter socketAdapter=new SocketAdapter(socket_three);
        computer.charge(socketAdapter);

        //新型电脑
        NewComputer newComputer=new NewComputer();
        newComputer.charge(new BaseAdapter() {
            @Override
            public String leftConnect(String s) {
                return s+"\n零线接通...";
            }

            @Override
            public String rightConnect(String s) {
                return s+"\n火线接通...";
            }
        });

//        Computer -=Socket_Two
//        SocketAdapter -=Socket_Three

    }
}
