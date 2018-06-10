package com.crossker.bitcoinwallet.components.base;

public interface IComponent {
    String getName();

    String onCall(CMessage message);
}
