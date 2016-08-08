package com.example.hanth2.simpleproject.base.component;

import android.content.Context;

import com.example.hanth2.simpleproject.activity.BaseActivity;
import com.example.hanth2.simpleproject.base.module.ApplicationModule;
import com.example.hanth2.simpleproject.base.thread.PostExecutionThread;
import com.example.hanth2.simpleproject.base.thread.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by HanTH2 on 8/8/2016.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    //Exposed to sub-graphs.
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    void inject(BaseActivity baseActivity);
}
