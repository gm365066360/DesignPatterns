package com.gm.designpatterns.observer;

import java.util.Observable;


/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/12 14:14
 * Description: NumObservable
 * Company : 北京四维图新科技股份有限公司
 */
public class NumObservable extends Observable {

    private int data = 0;

    public int getData() {
        return data;
    }

    public void setData(int i) {
        data = i;
        setChanged();
        notifyObservers();
    }
}
