package com.crossker.bitcoinwallet.component.core;

import com.billy.cc.core.component.CCResult;

public class CResult {
    private CCResult result;

    public CResult(CCResult result) {
        this.result = result;
    }

    public int getCode() {
        if (result != null) {
            return result.getCode();
        }

        return -1;
    }
}
