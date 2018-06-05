package com.crossker.bitcoinwallet.di.ui.main;

import com.crossker.bitcoinwallet.mvp.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }
}
