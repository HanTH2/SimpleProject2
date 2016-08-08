package com.example.hanth2.simpleproject.base.module;

import android.content.Context;

import com.example.hanth2.simpleproject.AndroidApplication;
import com.example.hanth2.simpleproject.base.executor.JobExecutor;
import com.example.hanth2.simpleproject.base.thread.PostExecutionThread;
import com.example.hanth2.simpleproject.base.thread.ThreadExecutor;
import com.example.hanth2.simpleproject.base.thread.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HanTH2 on 8/8/2016.
 */
@Module
public class ApplicationModule {

    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

}