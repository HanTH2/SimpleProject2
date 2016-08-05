package com.example.hanth2.simpleproject.login;

import com.example.hanth2.simpleproject.dagger.Injector;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public class RepositoryImpl implements Repository {

    @Inject
    ApiRequester mApiRequester;

    public RepositoryImpl() {
        Injector.INSTANCE.inject(this);
    }

    @Override
    public Observable<LoginModel> login(String userName, String password) {
        return mApiRequester.login(userName, password)
                .map(new Func1<LoginDto, LoginModel>() {
                    @Override
                    public LoginModel call(LoginDto loginDto) {
                        return new LoginModel(loginDto);
                    }
                });
    }
}
