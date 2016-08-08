package com.example.hanth2.simpleproject;

import android.app.Application;

import com.example.hanth2.simpleproject.base.component.ApplicationComponent;
import com.example.hanth2.simpleproject.base.component.DaggerApplicationComponent;
import com.example.hanth2.simpleproject.base.module.ApplicationModule;

/**
 * Created by HanTH2 on 8/8/2016.
 */
public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        this.initializeLeakDetection();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initializeLeakDetection() {
        // TODO: add leak manager here
        //    if (BuildConfig.DEBUG) {
        //      LeakCanary.install(this);
        //    }
        }
}
