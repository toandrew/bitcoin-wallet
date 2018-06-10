package com.crossker.bitcoinwallet.components.base;

import java.util.concurrent.ConcurrentHashMap;

public class ComponentManager {
    private ConcurrentHashMap<String, IComponent> components = new ConcurrentHashMap<>();

    public void registerComponent(IComponent component) {
        if (hasComponent(component)) {
            return;
        }

        components.put(component.getName(), component);
    }

    public void unregisterComponent(IComponent component) {
        components.remove(component.getName());
    }

    public boolean hasComponent(IComponent component) {
        if (components.containsKey(component.getName())) {
            return true;
        }

        return false;
    }

    public void reset() {
        components.clear();
    }

}
