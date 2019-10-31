package com.gm.designpatterns.mvp;


public abstract class BasePresenter<V> {
    protected V mView;

    public void setView(V v) {
        this.mView = v;
        this.onAttached();
    }

    public abstract void onAttached();

    public void onDetached() { }
}
