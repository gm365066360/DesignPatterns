package com.gm.designpatterns.mvp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.ParameterizedType;

@SuppressWarnings("unchecked")
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    public P mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initPresenter();
        initView();
    }
    public abstract int getLayoutId();
    public abstract void initView();
    protected void initPresenter() {
        if (this instanceof BaseView &&
                this.getClass().getGenericSuperclass() instanceof ParameterizedType &&
                ((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments().length > 0) {
            Class mPresenterClass = (Class) ((ParameterizedType) (this.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[0];
            try {
                mPresenter = (P) mPresenterClass.newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            if (mPresenter != null) {
                mPresenter.setView(this);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDetached();
        }
    }
}
