package com.example.hanth2.simpleproject.login;

import com.example.hanth2.simpleproject.base.net.LoginApiRequester;
import com.example.hanth2.simpleproject.base.net.LoginApiRequesterImpl;
import com.example.hanth2.simpleproject.base.scope.PerActivity;
import com.example.hanth2.simpleproject.base.thread.PostExecutionThread;
import com.example.hanth2.simpleproject.base.thread.ThreadExecutor;
import com.example.hanth2.simpleproject.base.interactor.UseCase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HanTH2 on 8/8/2016.
 */
@Module
public class LoginModule {

    public LoginModule() {
    }

    @Provides
    @PerActivity
    UseCase provideLoginUseCase(LoginRepository userRepository,
                                ThreadExecutor threadExecutor,
                                PostExecutionThread postExecutionThread) {
        return new LoginCase(userRepository, threadExecutor, postExecutionThread);
    }

    @Provides
    @PerActivity
    LoginApiRequester provideLoginApiRequester() {
        return new LoginApiRequesterImpl();
    }

    @Provides
    @PerActivity
    LoginRepository provideLoginRepository(LoginApiRequester apiRequester) {
        return new LoginRepositoryImpl(apiRequester);
    }
}