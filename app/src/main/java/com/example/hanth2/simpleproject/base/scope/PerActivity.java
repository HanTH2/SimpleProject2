package com.example.hanth2.simpleproject.base.scope;

import java.lang.annotation.Retention;
import javax.inject.Scope;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by HanTH2 on 8/8/2016.
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}