package com.crossker.bitcoinwallet.mvp.main;

import android.util.Log;

import com.crossker.bitcoinwallet.mvp.base.BasePresenter;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {
    private static final String TAG = "MainPresenter";

    @Override
    public void test() {
        Log.w(TAG, "test!!!");
        getView().onViewEvent();
    }
}
