package com.example.hanth2.simpleproject.login;

import com.example.hanth2.simpleproject.base.view.LoadingView;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public interface LoginView extends LoadingView {
    void showErrorMessage(String message);
    void showSuccessMessage();
}
