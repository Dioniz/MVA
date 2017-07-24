package com.diodev.mva.fragment;


public interface IMainFragment {
    void enableInputs();
    void disableInputs();
    void showProgress();
    void hideProgress();

    void navigateToHomeActivity();
    void loginError(String error);
}