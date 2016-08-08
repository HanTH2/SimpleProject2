package com.example.hanth2.simpleproject.login;

import com.example.hanth2.simpleproject.base.presenter.Presenter;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public interface LoginPresenter extends Presenter<LoginView, LoginRouter>{
    void onLoginButtonClick(String userName, String password);
}
