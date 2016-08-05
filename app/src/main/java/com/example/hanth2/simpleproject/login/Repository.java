package com.example.hanth2.simpleproject.login;

import rx.Observable;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public interface Repository {
    Observable<LoginModel> login(String username, String password);
}
