package com.crossker.bitcoinwallet.ui.main;

import android.os.Bundle;
import android.util.Log;

import com.crossker.bitcoinwallet.R;
import com.crossker.bitcoinwallet.mvp.main.MainContract;
import com.crossker.bitcoinwallet.mvp.main.MainPresenter;
import com.crossker.bitcoinwallet.ui.base.BaseActivity;
import com.crossker.bitcoinwallet.ui.base.LceNormalActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends LceNormalActivity implements MainContract.View {
    private static final String TAG = "MainActivity";

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        mainPresenter.attachView(this);

        mainPresenter.test();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void showContentView() {

    }

    @Override
    public void onViewEvent() {
        Log.w(TAG, "onViewEvent!");
    }
}
