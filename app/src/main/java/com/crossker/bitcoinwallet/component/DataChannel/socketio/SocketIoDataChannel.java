package com.crossker.bitcoinwallet.component.DataChannel.socketio;

import com.crossker.bitcoinwallet.component.DataChannel.base.CustomMessageListener;
import com.crossker.bitcoinwallet.component.DataChannel.base.DataChannel;

public class SocketIoDataChannel extends DataChannel {
    protected SocketIoDataChannel(CustomMessageListener listener) {
        super(listener);
    }

    @Override
    public void create() {

    }

    @Override
    public void destroy() {

    }
}
