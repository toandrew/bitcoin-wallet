package com.crossker.bitcoinwallet.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.crossker.bitcoinwallet.R;
import com.crossker.bitcoinwallet.ui.base.BaseActivity;
import com.crossker.bitcoinwallet.ui.main.MainActivity;

import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> {
            finish();
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @OnClick(R.id.btn_register)
    void onLoginClicked() {
        Intent intent = new Intent();
        intent.setClass(RegisterActivity.this, MainActivity.class);
        startActivity(intent);

        finish();
    }
}
