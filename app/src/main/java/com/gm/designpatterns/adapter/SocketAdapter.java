package com.gm.designpatterns.adapter;

import android.util.Log;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/14 14:08
 * Description: SocketAdapter
 * Company : 北京四维图新科技股份有限公司
 */
public class SocketAdapter implements Socket_Two{
    private Socket_Three socket_Three;
    public SocketAdapter(Socket_Three socket_Three) {
        this.socket_Three=socket_Three;
    }
    @Override
    public void connect() {
        //使用委托的方式完成特殊功能
        Log.e("gaom","我是适配器：通过我可以让两脚插头使用三孔插座");
        socket_Three.leftConnect();
        socket_Three.rightconnect();
    }
}
