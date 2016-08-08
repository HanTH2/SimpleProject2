package com.example.hanth2.simpleproject.base.component;

import android.support.v4.app.ActivityCompat;

import com.example.hanth2.simpleproject.base.module.ActivityModule;
import com.example.hanth2.simpleproject.base.scope.PerActivity;

import dagger.Component;

/**
 * Created by HanTH2 on 8/8/2016.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    //Exposed to sub-graphs.
    ActivityCompat activity();
}
