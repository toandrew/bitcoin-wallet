package com.crossker.bitcoinwallet.di.app;

import com.crossker.bitcoinwallet.app.App;
import com.crossker.bitcoinwallet.di.activity.ActivityBindModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AppModule.class, AndroidInjectionModule.class, ActivityBindModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(App app);

        AppComponent build();
    }

    void inject(App app);
}
