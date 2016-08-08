package com.example.hanth2.simpleproject;

import android.app.Application;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public class App extends Application {
    private static App sInstance;

    public static App getsInstance(){
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
}
