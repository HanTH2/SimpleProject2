package com.example.hanth2.simpleproject.base.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by HanTH2 on 8/5/2016.
 */
@Scope
@Retention(RUNTIME)
public @interface ForApplication {
}
