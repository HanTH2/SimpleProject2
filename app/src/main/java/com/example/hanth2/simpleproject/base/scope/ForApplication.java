package com.example.hanth2.simpleproject.base.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by HanTH2 on 8/5/2016.
 */
@Qualifier
@Retention(RUNTIME)
public @interface ForApplication {
}
