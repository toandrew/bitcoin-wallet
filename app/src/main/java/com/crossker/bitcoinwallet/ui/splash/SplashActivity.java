package com.crossker.bitcoinwallet.ui.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import com.crossker.bitcoinwallet.R;
import com.crossker.bitcoinwallet.ui.base.BaseActivity;
import com.crossker.bitcoinwallet.ui.login.LoginActivity;
import com.crossker.bitcoinwallet.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import dagger.android.AndroidInjection;

public class SplashActivity extends BaseActivity {
    private static final String TAG = "SplashActivity";

    @Inject
    SharedPreferences sharedPreferences;

    @BindView(R.id.sp_jump_btn)
    Button skipBtn;

    private CountDownTimer timer = new CountDownTimer(3400, 1000) {
        @Override
        public void onTick(long l) {
            skipBtn.setText(l / 1000 + "s");
        }

        @Override
        public void onFinish() {
            skipBtn.setVisibility(View.GONE);

            if (!sharedPreferences.getString("token", "").isEmpty()) {
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent();
                intent.setClass(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
            }

            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);

        timer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        timer.cancel();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

}
