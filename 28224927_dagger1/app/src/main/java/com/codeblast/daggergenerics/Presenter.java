package com.codeblast.daggergenerics;

public abstract class Presenter<T extends BaseView> {

    private final T mView;

    public Presenter(T view) {
        mView = view;
    }

    public void showLoadingIndicator() {
        mView.showLoading();
    }
}
