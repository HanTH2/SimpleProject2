package com.example.hanth2.simpleproject.login;

import android.text.TextUtils;

import com.example.hanth2.simpleproject.dagger.Injector;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public class LoginPresenterImpl implements LoginPresenter {
    private final CompositeSubscription mSubscription = new CompositeSubscription();

    protected CompositeSubscription getSubscription() {
        return mSubscription;
    }

    protected void clearSubscription() {
        mSubscription.clear();
    }

    private LoginView mView;
    private LoginRouter mRouter;

    @Inject
    Repository mRepository;

    public LoginPresenterImpl(LoginView view, LoginRouter router) {
        mView = view;
        mRouter = router;
        Injector.INSTANCE.inject(this);
    }

    @Override
    public void onLoginButtonClick(String userName, String password) {
        if (!isInputAll(userName, password)) {
            mView.showErrorMessage("Please input all data!");
            return;
        }
        if (!isNetworkOK()) {
            return;
        }
        // Login
        getSubscription()
                .add(mRepository.login(userName, password)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<LoginModel>() {
                            @Override
                            public void call(LoginModel loginModel) {
                                mView.dismissProgressDialog();
                                if (loginModel.errorcode == 0) {
                                    mRouter.openMainScreen();
                                    // Some other logic such as: save username and password to Section... TODO
                                } else {
                                    mView.showErrorMessage("Login failure!");
                                }
                            }
                        }, new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                // Error here
                                mView.dismissProgressDialog();
                                mView.showErrorMessage("Login failure!");
                            }
                        }));
    }

    @Override
    public boolean isInputAll(String userName, String passWord) {
        return !TextUtils.isEmpty(userName) && !TextUtils.isEmpty(passWord);
    }

    @Override
    public boolean isNetworkOK() {
        return true;
    }

    @Override
    public boolean hasErrorInResponse() {
        return false;
    }
}
