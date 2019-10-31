package com.gm.designpatterns.mvp.wrongexample;


import android.os.Handler;

public class WrongModel   {

    IWrongListener iWrongListener;

    public WrongModel(IWrongListener iWrongListener) {
        this.iWrongListener = iWrongListener;
    }

    public  interface IWrongListener{
        void onGetData(String data);
    }

    public void getData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                iWrongListener.onGetData("WrongExample");
            }
        },2_000);
    }

}


