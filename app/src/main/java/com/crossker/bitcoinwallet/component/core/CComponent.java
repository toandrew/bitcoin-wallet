package com.crossker.bitcoinwallet.component.core;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.IDynamicComponent;

public abstract class CComponent implements IDynamicComponent {
    protected CComponent() {
        init();
    }

    public CResult send(CMessage message) {
        return CMessageManager.send(message);
    }

    @Override
    public boolean onCall(CC cc) {

        // TODO: Create new component message according to cc
        CMessage message = new CMessage(getName());
        message.setMessageId(cc.getCallId());
        message.setService(Integer.parseInt(cc.getActionName()));
        message.addParams(cc.getParams());

        return onCall(message);
    }

    protected abstract boolean onCall(CMessage message);

    protected abstract void init();
}
