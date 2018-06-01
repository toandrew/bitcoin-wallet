package com.crossker.bitcoinwallet.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());

        unbinder = ButterKnife.bind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        unbinder.unbind();
    }

    protected abstract int getLayoutId();
}
