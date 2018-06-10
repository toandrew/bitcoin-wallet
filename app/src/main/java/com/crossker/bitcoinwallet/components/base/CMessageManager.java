package com.crossker.bitcoinwallet.components.base;

import java.util.ArrayList;

public class CMessageManager {
    private ArrayList<CMessage.Builder> builders = new ArrayList<>();

    public static void init() {
    }

    public static CResult call(CMessage message) {
        return message.call();
    }

    public static int callAsync(CMessage message) {
        return message.callAsync();
    }
}
