package com.example.hanth2.simpleproject.login;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public interface LoginView {
    void showErrorMessage(String message);
    void showSuccessMessage();
    void showProgressDialog();
    void dismissProgressDialog();
}
