package com.gm.designpatterns.observer;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/12 14:14
 * Description: NumObserver
 * Company : 北京四维图新科技股份有限公司
 */
public class NumObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        NumObservable myObserable = (NumObservable) o;
        Log.e("gaom ","Data has changed to " + myObserable.getData());
    }

}
