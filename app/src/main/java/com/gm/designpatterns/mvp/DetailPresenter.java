package com.gm.designpatterns.mvp;


import android.widget.Toast;

public class DetailPresenter extends DetailContract.BaseDetailPresenter {

    @Override
    public void addShopCar(String userId, String productId) {
        mView.addSuc();
    }

    @Override
    public void onAttached() {

    }
}


