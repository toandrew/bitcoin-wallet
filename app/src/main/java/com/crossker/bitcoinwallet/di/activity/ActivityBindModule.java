package com.crossker.bitcoinwallet.di.activity;

import com.crossker.bitcoinwallet.di.ActiveScope;
import com.crossker.bitcoinwallet.di.ui.main.MainModule;
import com.crossker.bitcoinwallet.ui.main.MainActivity;
import com.crossker.bitcoinwallet.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindModule {
    @ActiveScope
    @ContributesAndroidInjector
    abstract SplashActivity contributeSplashActivity();

    @ActiveScope
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity contributeMainActivity();
}
