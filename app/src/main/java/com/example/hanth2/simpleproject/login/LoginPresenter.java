package com.example.hanth2.simpleproject.login;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public interface LoginPresenter {
    void onLoginButtonClick(String userName, String password);

    boolean isInputAll(String userName, String passWord);

    boolean isNetworkOK();

    boolean hasErrorInResponse();
}
