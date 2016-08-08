package com.example.hanth2.simpleproject.base.thread;

import rx.Scheduler;

/**
 * Created by HanTH2 on 8/8/2016.
 */
public interface PostExecutionThread {
    Scheduler getScheduler();
}
