package com.crossker.bitcoinwallet.ui.main;

import android.os.Bundle;
import android.util.Log;

import com.crossker.bitcoinwallet.R;
import com.crossker.bitcoinwallet.mvp.main.MainContract;
import com.crossker.bitcoinwallet.mvp.main.MainPresenter;
import com.crossker.bitcoinwallet.ui.base.LceNormalActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

public class MainActivity extends LceNormalActivity implements MainContract.View {
    private static final String TAG = "MainActivity";

    @Inject
    MainPresenter mainPresenter;

    @BindView(R.id.bottom_navigation)
    BottomNavigationViewEx bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        mainPresenter.attachView(this);

        mainPresenter.test();

        bottomNavigation.enableAnimation(false);
        bottomNavigation.enableShiftingMode(false);
        bottomNavigation.enableItemShiftingMode(false);
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
