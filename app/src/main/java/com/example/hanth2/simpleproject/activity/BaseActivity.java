package com.example.hanth2.simpleproject.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by HanTH2 on 8/8/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
    }

    protected void initializeInjector() {
        // Implement at sub class if needed
    }
}
