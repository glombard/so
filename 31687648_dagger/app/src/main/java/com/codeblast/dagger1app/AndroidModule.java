package com.codeblast.dagger1app;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(library = true, injects = PhotoManager.class)
public class AndroidModule {

    private final TestApp mApplication;

    public AndroidModule(TestApp application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    @ForApplication
    Context provideApplicationContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    DbManager provideDbManager() {
        return new DbManager(mApplication);
    }
}