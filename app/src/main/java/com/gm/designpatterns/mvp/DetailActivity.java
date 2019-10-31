package com.gm.designpatterns.mvp;


import android.view.View;
import android.widget.Toast;

import com.gm.designpatterns.R;

public class DetailActivity extends BaseActivity<DetailPresenter> implements DetailContract.View {


    @Override
    public int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    public void initView() {

    }

    @Override
    public void addSuc() {
        Toast.makeText(this, "addSuc", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addFail() {
        Toast.makeText(this, "addFail", Toast.LENGTH_SHORT).show();
    }

    public void addShopCar(View view) {
        mPresenter.addShopCar("", "");
    }


}
