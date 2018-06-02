package com.crossker.bitcoinwallet.di.activity;

import com.crossker.bitcoinwallet.di.ActiveScope;
import com.crossker.bitcoinwallet.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindModule {
    @ActiveScope
    @ContributesAndroidInjector
    abstract SplashActivity contributeSplashActivity();
}
