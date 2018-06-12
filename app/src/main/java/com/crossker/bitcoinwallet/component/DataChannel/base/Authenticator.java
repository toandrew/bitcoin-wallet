package com.crossker.bitcoinwallet.component.DataChannel.base;

public interface Authenticator {
    void login(String userName, String token, AuthListener listener);

    void quit();
}
