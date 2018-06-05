package com.crossker.bitcoinwallet.mvp.base;

public interface MvpView {
    void showLoading();
    void showEmptyView();
    void showError(Throwable throwable);
    void showContentView();
}
