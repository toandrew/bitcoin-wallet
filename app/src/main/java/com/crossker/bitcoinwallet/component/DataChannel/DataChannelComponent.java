package com.crossker.bitcoinwallet.component.DataChannel;

import android.text.TextUtils;
import android.util.Log;

import com.crossker.bitcoinwallet.component.DataChannel.base.AuthListener;
import com.crossker.bitcoinwallet.component.DataChannel.base.Authenticator;
import com.crossker.bitcoinwallet.component.DataChannel.base.CustomMessageListener;
import com.crossker.bitcoinwallet.component.DataChannel.base.DataChannel;
import com.crossker.bitcoinwallet.component.DataChannel.nim.NimAuthenticator;
import com.crossker.bitcoinwallet.component.DataChannel.nim.NimDataChannel;
import com.crossker.bitcoinwallet.component.core.CComponent;
import com.crossker.bitcoinwallet.component.core.CMessage;
import com.crossker.bitcoinwallet.component.core.CMessageManager;

public class DataChannelComponent extends CComponent {
    private static final String NAME = "DataChannelComponent";

    public enum Services {
        AUTH_LOGIN,
        AUTH_QUIT,
        CHANNEL_CREATE,
        CHANNEL_DESTROY,
    }

    public static final String LOGIN_PARAM_USERNAME = "user";
    public static final String LOGIN_PARAM_TOKEN = "token";

    public enum DataChannelType {
        NIM,
        SOCKET_IO
    }

    private DataChannelType channelType;

    private DataChannel dataChannel;

    private Authenticator authenticator;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected boolean onCall(CMessage message) {
        Services service = Services.values()[message.getService()];
        switch (service) {
            case AUTH_LOGIN:
                Log.w(NAME, "AUTH_LOGIN[" + message.getParams() + "]");

                doLogin(message);

                // true for async, false for sync
                return true;

            case AUTH_QUIT:
                Log.w(NAME, "AUTH_QUIT");
                break;

            case CHANNEL_CREATE:
                Log.w(NAME, "CHANNEL_CREATE");
                break;

            case CHANNEL_DESTROY:
                Log.w(NAME, "CHANNEL_DESTROY");
                break;

            default:
                Log.w(NAME, "unknown required service:" + service);
                break;
        }

        return false;
    }

    @Override
    protected void init() {
        // Change it according to the config file?
        channelType = DataChannelType.NIM;

        if (channelType == DataChannelType.NIM) {
            authenticator = NimAuthenticator.getInstance();

            dataChannel = new NimDataChannel(new CustomMessageListener() {
                @Override
                public void onUserJoin(String account) {
                    Log.w(NAME, "onUserJoin: " + account);
                }
            });
        } else {
            // TODO
        }
    }

    /**
     * Do login
     *
     * @param message
     */
    private void doLogin(CMessage message) {
        String userName = message.getParamItem(LOGIN_PARAM_USERNAME);
        String token = message.getParamItem(LOGIN_PARAM_TOKEN);
        if (userName != null && !TextUtils.isEmpty(userName)
                && token != null && !TextUtils.isEmpty(token)
                && authenticator != null) {
            authenticator.login(userName, token, new AuthListener() {
                @Override
                public void onAuthSuccess() {
                    if (message != null) {
                        CMessageManager.sendResult(message.getMessageId(), true, "onAuthSuccess");
                    }
                }

                @Override
                public void onAuthFailure(int code) {
                    if (message != null) {
                        CMessageManager.sendResult(message.getMessageId(), false, "onAuthFailure");
                    }
                }

                @Override
                public void onAuthKickOut() {
                    if (message != null) {
                        CMessageManager.sendResult(message.getMessageId(), false, "onAuthKickOut");
                    }
                }
            });
        } else {
            if (message != null) {
                CMessageManager.sendResult(message.getMessageId(), false, "error");
            }
        }
    }
}
