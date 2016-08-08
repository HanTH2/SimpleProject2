package com.example.hanth2.simpleproject.base.module;

import android.support.v4.app.ActivityCompat;

import com.example.hanth2.simpleproject.base.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HanTH2 on 8/8/2016.
 */
@Module
public class ActivityModule {
    private final ActivityCompat activity;

    public ActivityModule(ActivityCompat activity) {
        this.activity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    ActivityCompat activity() {
        return this.activity;
    }
}
