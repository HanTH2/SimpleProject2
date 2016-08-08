package com.example.hanth2.simpleproject.login;

import com.example.hanth2.simpleproject.base.thread.PostExecutionThread;
import com.example.hanth2.simpleproject.base.thread.ThreadExecutor;
import com.example.hanth2.simpleproject.base.interactor.UseCase;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by HanTH2 on 8/8/2016.
 */
public class LoginCase extends UseCase {
    private LoginRepository mRepository;
    private String mUserName;
    private String mPassword;

    protected LoginCase(LoginRepository loginRepository,
                        ThreadExecutor threadExecutor,
                        PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        mRepository = loginRepository;
    }

    public void setUserNameAndPass(String userName, String password) {
        mUserName = userName;
        mPassword = password;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mRepository.login(mUserName, mPassword);
    }
}
