package com.example.hanth2.simpleproject.dagger;

import android.content.Context;

import com.example.hanth2.simpleproject.App;
import com.example.hanth2.simpleproject.login.ApiRequester;
import com.example.hanth2.simpleproject.login.ApiRequesterImpl;
import com.example.hanth2.simpleproject.login.LoginActivity;
import com.example.hanth2.simpleproject.login.LoginPresenterImpl;
import com.example.hanth2.simpleproject.login.Repository;
import com.example.hanth2.simpleproject.login.RepositoryImpl;

import java.net.ResponseCache;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HanTH2 on 8/5/2016.
 */
@Module(
        injects = {
                App.class,
                LoginActivity.class,
                RepositoryImpl.class,
                LoginPresenterImpl.class,
                ApiRequesterImpl.class,
        },
        complete = false, library = true
)

public class ApplicationModule {
    private Context mContext;

    public ApplicationModule(Context context){
        mContext = context;
    }

    @Provides
    @Singleton
    Repository provideRepository() {
        return new RepositoryImpl();
    }

    @Provides
    @Singleton
    ApiRequester provideApiRequester() {
        return new ApiRequesterImpl();
    }

}
