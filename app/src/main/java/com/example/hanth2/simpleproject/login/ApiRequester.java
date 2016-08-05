package com.example.hanth2.simpleproject.login;

import rx.Observable;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public interface ApiRequester {
    Observable<LoginDto> login(String username, String password);
}
