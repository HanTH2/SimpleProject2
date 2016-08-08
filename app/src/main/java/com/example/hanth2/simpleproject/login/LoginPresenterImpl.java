package com.example.hanth2.simpleproject.login;

import com.example.hanth2.simpleproject.base.interactor.DefaultSubscriber;
import com.example.hanth2.simpleproject.base.interactor.UseCase;
import com.fernandocejas.frodo.annotation.RxLogSubscriber;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public class LoginPresenterImpl implements LoginPresenter {
    private LoginView mView;
    private LoginRouter mRouter;
    private UseCase mLoginCase;


    public LoginPresenterImpl(UseCase loginCase) {
                this.mLoginCase = loginCase;
    }

    @Override
    public void setViewAndRouter(LoginView loginView, LoginRouter router) {
        mView = loginView;
        mRouter = router;
    }

    @Override
    public void onLoginButtonClick(String userName, String password) {
        mLoginCase.execute(new LoginSubscriber());
    }

    @RxLogSubscriber
    private final class LoginSubscriber extends DefaultSubscriber<LoginModel> {

        @Override
        public void onCompleted() {
        LoginPresenterImpl.this.mView.dismissLoadingView();
        }

        @Override
        public void onError(Throwable e) {
            LoginPresenterImpl.this.mView.dismissLoadingView();
            LoginPresenterImpl.this.mView.showErrorMessage("There is error when logging in.");
        }

        @Override
        public void onNext(LoginModel loginModel) {
            LoginPresenterImpl.this.mRouter.openMainScreen();
        }
    }
}
