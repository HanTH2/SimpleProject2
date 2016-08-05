package com.example.hanth2.simpleproject;

import android.app.Application;

import com.example.hanth2.simpleproject.dagger.AndroidModule;
import com.example.hanth2.simpleproject.dagger.ApplicationModule;
import com.example.hanth2.simpleproject.dagger.Injector;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

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
        Injector.INSTANCE.setObjectGraph(ObjectGraph.create(getModules().toArray()));
    }

    protected List<Object> getModules(){
        return Arrays.asList(new AndroidModule(this), new ApplicationModule(this));
    }
}
