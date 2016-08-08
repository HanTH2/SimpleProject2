package com.example.hanth2.simpleproject.login;

import com.example.hanth2.simpleproject.base.component.ApplicationComponent;
import com.example.hanth2.simpleproject.base.scope.PerActivity;

import dagger.Component;

/**
 * Created by HanTH2 on 8/8/2016.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}