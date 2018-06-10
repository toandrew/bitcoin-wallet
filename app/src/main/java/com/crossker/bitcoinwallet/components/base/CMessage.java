package com.crossker.bitcoinwallet.components.base;

import java.util.ArrayList;
import java.util.List;

public class CMessage {
    private int msssageId;

    List<Interceptor> interceptors = new ArrayList<>();

    private CMessage() {
    }

    public CResult call() {
        return null;
    }

    public int callAsync() {
        return msssageId;
    }

    public static class Builder {
        private CMessage message;

        private static CMessage init() {
            return new CMessage();
        }
    }
}
