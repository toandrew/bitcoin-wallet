package com.crossker.bitcoinwallet.component.DataChannel.nim;

import com.crossker.bitcoinwallet.component.DataChannel.base.CustomMessageListener;
import com.crossker.bitcoinwallet.component.DataChannel.base.DataChannel;

public class NimDataChannel extends DataChannel {
    private String sessionId;

    RTSChannelStateObserver channelStateObserver = new RTSChannelStateObserver() {
        @Override
        public void onConnectResult(String s, RTSTunnelType rtsTunnelType, long l, int i, String s1) {
            if (channelEventListener != null) {
                channelEventListener.onConnected();
            }
        }

        @Override
        public void onChannelEstablished(String s, RTSTunnelType rtsTunnelType) {
            // TODO
        }

        @Override
        public void onUserJoin(String s, RTSTunnelType rtsTunnelType, String s1) {
            if (channelEventListener != null) {
                channelEventListener.onUserJoin();
            }
        }

        @Override
        public void onUserLeave(String s, RTSTunnelType rtsTunnelType, String s1, int i) {
            if (channelEventListener != null) {
                channelEventListener.onUserLeave();
            }
        }

        @Override
        public void onDisconnectServer(String s, RTSTunnelType rtsTunnelType) {
            if (channelEventListener != null) {
                channelEventListener.onDisconnected();
            }
        }

        @Override
        public void onError(String s, RTSTunnelType rtsTunnelType, int i) {
            if (channelEventListener != null) {
                channelEventListener.onError();
            }
        }

        @Override
        public void onNetworkStatusChange(String s, RTSTunnelType rtsTunnelType, int i) {
            // TODO
        }
    };

    private Observer<RTSTunData> receiveDataObserver = new Observer<RTSTunData>() {

        @Override
        public void onEvent(RTSTunData rtsTunData) {
            if (dataEventListener != null) {
                dataEventListener.onEvent(rtsTunData);
            }
        }
    };

    public NimDataChannel(CustomMessageListener listener) {
        super(listener);
    }

    @Override
    public void create() {
        registerObservers();
    }

    @Override
    public void destroy() {
        unregisterObservers();
    }

    private void registerObservers() {
        RTSManager2.getInstance().observeChannelState(sessionId, channelStateObserver, true);
        RTSManager2.getInstance().observeReceiveData(sessionId, receiveDataObserver, true);
    }

    private void unregisterObservers() {
        RTSManager2.getInstance().observeChannelState(sessionId, channelStateObserver, false);
        RTSManager2.getInstance().observeReceiveData(sessionId, receiveDataObserver, false);
    }
}
