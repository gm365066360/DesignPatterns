package com.gm.designpatterns.mvp;



public interface DetailContract {

    interface View extends BaseView {
        void addSuc();
        void addFail();
    }

    abstract class BaseDetailPresenter extends BasePresenter<View> {
        public abstract void addShopCar(String userId, String productId);
    }
}

