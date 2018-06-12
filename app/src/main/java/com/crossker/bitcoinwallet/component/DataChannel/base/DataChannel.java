package com.crossker.bitcoinwallet.component.DataChannel.base;

public abstract class DataChannel {
    protected ChannelEventListener channelEventListener = new ChannelEventListener() {
        @Override
        public void onEvent(Object o) {

        }

        @Override
        public void onConnected() {

        }

        @Override
        public void onDisconnected() {

        }

        @Override
        public void onUserJoin() {

        }

        @Override
        public void onUserLeave() {

        }

        @Override
        public void onError() {

        }
    };

    protected DataEventListener dataEventListener = new DataEventListener() {
        @Override
        public void onEvent(Object o) {
        }
    };

    CustomMessageListener listener = null;

    protected DataChannel(CustomMessageListener listener) {
        this.listener = listener;
    }

}
