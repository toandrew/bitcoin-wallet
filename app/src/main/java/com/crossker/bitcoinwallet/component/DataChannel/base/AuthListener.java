package com.crossker.bitcoinwallet.component.DataChannel.base;

public interface AuthListener {
    void onAuthSuccess();

    void onAuthFailure(int code);

    void onAuthKickOut();
}
