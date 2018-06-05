package com.crossker.bitcoinwallet.mvp.main;

import com.crossker.bitcoinwallet.mvp.base.MvpPresenter;
import com.crossker.bitcoinwallet.mvp.base.MvpView;

public interface MainContract {
    interface View extends MvpView {
        void onViewEvent();
    }

    interface Presenter extends MvpPresenter<MainContract.View> {
        void test();
    }
}
