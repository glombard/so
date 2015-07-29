package com.codeblast.dagger1app;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PhotoManager {

    @Inject
    DbManager mDbManager;

    public void doSomething() {
        mDbManager.readDatabase();
    }
}
