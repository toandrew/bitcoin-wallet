package com.crossker.bitcoinwallet.component.DataChannel.base;

public interface ChannelEventListener extends EventListener {
    void onConnected();

    void onDisconnected();

    void onUserJoin();

    void onUserLeave();

    void onError();
}
