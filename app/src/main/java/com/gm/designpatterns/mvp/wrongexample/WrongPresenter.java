package com.gm.designpatterns.mvp.wrongexample;


public class WrongPresenter  implements WrongModel.IWrongListener {

    WrongActivity wrongActivity;
    WrongModel wrongModel;

    public WrongPresenter(WrongActivity wrongActivity) {
        this.wrongActivity = wrongActivity;
        wrongModel=new WrongModel(this);
    }

    public void getData() {
        wrongModel.getData();
    }

    @Override
    public void onGetData(String data) {
        wrongActivity.onSuccess(data);
    }
}


