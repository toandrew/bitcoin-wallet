package com.crossker.bitcoinwallet.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.crossker.bitcoinwallet.R;
import com.crossker.bitcoinwallet.ui.base.BaseActivity;
import com.crossker.bitcoinwallet.ui.main.MainActivity;

import butterknife.BindView;

public class SplashActivity extends BaseActivity {
    private static final String TAG = "SplashActivity";

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

            Intent intent = new Intent();
            intent.setClass(SplashActivity.this, MainActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
