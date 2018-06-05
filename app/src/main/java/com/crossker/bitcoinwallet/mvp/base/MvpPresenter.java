package com.crossker.bitcoinwallet.mvp.base;

public interface MvpPresenter<V extends MvpView> {
    void attachView(V view);
    void detachView();
}
