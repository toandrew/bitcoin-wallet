package com.crossker.bitcoinwallet.di.app;

import android.content.Context;
import android.content.SharedPreferences;

import com.crossker.bitcoinwallet.app.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Singleton
    @Provides
    public Context provideAppContext(App app) {
        return app.getApplicationContext();
    }

    @Singleton
    @Provides
    public SharedPreferences preferences(Context context) {
        return context.getSharedPreferences("config", Context.MODE_PRIVATE);
    }
}
