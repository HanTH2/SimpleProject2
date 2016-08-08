package com.example.hanth2.simpleproject.base.net;

import com.example.hanth2.simpleproject.login.LoginDto;

import rx.Observable;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public interface LoginApiRequester {
    Observable<LoginDto> login(String username, String password);
}
