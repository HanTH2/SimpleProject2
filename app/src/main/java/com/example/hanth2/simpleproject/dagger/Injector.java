package com.example.hanth2.simpleproject.dagger;

import java.util.Objects;

import dagger.ObjectGraph;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public enum Injector {
    INSTANCE;

    private ObjectGraph mObjectGraph;

    public ObjectGraph getObjectGraph() {
        return mObjectGraph;
    }

    public void setObjectGraph(ObjectGraph objectGraph) {
        this.mObjectGraph = objectGraph;
    }

    public void inject(Object object){
        mObjectGraph.inject(object);
    }
}
