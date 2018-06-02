package com.crossker.bitcoinwallet.ui.login;

import android.content.Intent;
import android.os.Bundle;

import com.crossker.bitcoinwallet.R;
import com.crossker.bitcoinwallet.ui.base.BaseActivity;

import butterknife.OnClick;

public class AuthActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_auth;
    }

    @OnClick(R.id.login)
    void onLoginClicked() {
        Intent intent = new Intent();
        intent.setClass(AuthActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.register)
    void onRegisterClicked() {
        Intent intent = new Intent();
        intent.setClass(AuthActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.license)
    void onLicenseClicked() {

    }

}
