package com.crossker.bitcoinwallet.component.DataChannel.nim;

import com.crossker.bitcoinwallet.component.DataChannel.base.AuthListener;
import com.crossker.bitcoinwallet.component.DataChannel.base.Authenticator;

import java.lang.ref.WeakReference;

public class NimAuthenticator implements Authenticator {
    private static final String TAG = "NimAuthenticator";

    private static AuthListener authListener;

    private AbortableFuture<LoginInfo> loginInfoAbortableFuture;

    private static WeakReference<NimAuthenticator> authenticator;

    private static Observer<StatusCode> userStatusObserver = new Observer<StatusCode>() {
        @Override
        public void onEvent(StatusCode statusCode) {
            if (statusCode == StatusCode.KICKOUT) {
                if (authListener != null) {
                    authListener.onAuthKickOut();
                }
            }
        }
    };

    private NimAuthenticator() {
    }

    public static NimAuthenticator getInstance() {
        if (authenticator == null || authenticator.get() == null) {
            authenticator = new WeakReference<>(new NimAuthenticator());
        }

        return authenticator.get();
    }

    @Override
    public void login(String userName, String token, AuthListener listener) {
        authListener = listener;

        NIMSDK.getAuthServiceObserve().observeOnlineStatus(userStatusObserver, true);

        LoginInfo loginInfo = new LoginInfo(userName, token);
        loginInfoAbortableFuture = NIMSDK.getAuthService().login(loginInfo);
        loginInfoAbortableFuture.setCallback(new RequestCallback<LoginInfo>() {
            @Override
            public void onSuccess(LoginInfo info) {
                authListener.onAuthSuccess();
            }

            @Override
            public void onFailed(int code) {
                authListener.onAuthFailure(code);
            }

            @Override
            public void onException(Throwable throwable) {
                Logger.t(TAG).e("nim->login->onException" + throwable.toString());
                authListener.onAuthFailure(1000);
            }
        });
    }

    @Override
    public void quit() {
        NIMSDK.getAuthServiceObserve().observeOnlineStatus(userStatusObserver, false);
        NIMSDK.getAuthService().logout();

        if (null != loginInfoAbortableFuture) {
            loginInfoAbortableFuture.abort();
        } else {
            Logger.t(TAG).e("quit with null loginInfo");
        }

        authListener = null;
        authenticator = null;
    }
}
