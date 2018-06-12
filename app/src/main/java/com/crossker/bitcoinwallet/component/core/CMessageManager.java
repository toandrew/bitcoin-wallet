package com.crossker.bitcoinwallet.component.core;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.IComponentCallback;

public class CMessageManager {
    public static CMessage obtainMessage(String componentId) {
        return new CMessage(componentId);
    }

    public static CResult send(CMessage message) {
        CCResult result = CC.obtainBuilder(message.getComponentId())
                .setActionName(message.getService() + "")
                .addParams(message.getParams())
                .build()
                .call();

        return new CResult(result);
    }

    public static boolean sendAsync(CMessage message, CCallback callback) {
        String messageId = CC.obtainBuilder(message.getComponentId())
                .setActionName(message.getService() + "")
                .addParams(message.getParams())
                .build().callAsync(new IComponentCallback() {

                    @Override
                    public void onResult(CC cc, CCResult result) {

                        if (callback != null) {
                            callback.onResult(message, new CResult(result));
                        }
                    }
                });

        return messageId != null;
    }

    public static void sendResult(String messageId, boolean success, String info) {
        if (success) {
            CC.sendCCResult(messageId, CCResult.success("info", info));
        } else {
            CC.sendCCResult(messageId, CCResult.error(info));
        }
    }
}
