package com.codeblast.dagger1app;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

public class TestApp extends Application {

    private ObjectGraph mObjectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        mObjectGraph = ObjectGraph.create(getModules().toArray());
    }

    protected List<Object> getModules() {
        return Arrays.asList(new AndroidModule(this), new PhotosModule());
    }

    public void inject(Object object) {
        mObjectGraph.inject(object);
    }
}
