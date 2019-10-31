package com.gm.designpatterns.mvp.wrongexample;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.gm.designpatterns.R;
import com.gm.designpatterns.mvp.BaseActivity;
import com.gm.designpatterns.mvp.DetailContract;
import com.gm.designpatterns.mvp.DetailPresenter;

public class WrongActivity extends AppCompatActivity {

    WrongPresenter wrongPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        wrongPresenter = new WrongPresenter(this);
        initData();

    }


    public void initData() {
        wrongPresenter.getData();
    }

    public void onSuccess(String data) {
        Toast.makeText(this, "result: ".concat(data), Toast.LENGTH_SHORT).show();
    }


}
