package com.crossker.bitcoinwallet.component.core;

import java.util.HashMap;
import java.util.Map;

public class CMessage {
    // null for broadcast?
    private String componentId;

    private String messageId;

    // required service which is provided by component
    private int service;
    private final Map<String, Object> params = new HashMap<>();

    public CMessage(String componentId) {
        this.componentId = componentId;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getService() {
        return service;
    }

    public void addParam(String key, Object value) {
        this.params.put(key, value);
    }

    public void addParams(Map<String, Object> params) {
        if (params != null) {
            for (String key : params.keySet()) {
                addParam(key, params.get(key));
            }
        }
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public <T> T getParamItem(String key, T defaultValue) {
        T item = getParamItem(key);
        if (item == null) {
            return defaultValue;
        }
        return item;
    }

    public <T> T getParamItem(String key) {
        try {
            return (T) params.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
