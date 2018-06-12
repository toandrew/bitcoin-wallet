package com.crossker.bitcoinwallet.component.core;

import com.billy.cc.core.component.CC;

public class CComponentManager {
    public static void registerComponent(CComponent component) {
        CC.registerComponent(component);
    }

    public static void unregisterComponent(CComponent component) {
        CC.registerComponent(component);
    }
}
