package com.example.hanth2.simpleproject.dagger;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HanTH2 on 8/5/2016.
 */
@Module(library = true)
public class AndroidModule {
    private Application mApplication;

    public AndroidModule(Application application){
        this.mApplication = application;
    }

    @Provides
    @Singleton
    @ForApplication
    Context provideApplicationContext(){
        return mApplication;
    }
}
