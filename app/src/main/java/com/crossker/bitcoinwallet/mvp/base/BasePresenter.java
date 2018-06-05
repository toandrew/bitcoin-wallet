package com.crossker.bitcoinwallet.mvp.base;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    public V getView() {
        return view;
    }
}
