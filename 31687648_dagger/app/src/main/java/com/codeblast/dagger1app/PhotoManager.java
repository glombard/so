package com.codeblast.dagger1app;

import javax.inject.Singleton;

@Singleton
public class PhotoManager {

    private final DbManager mDbManager;

    public PhotoManager(DbManager dbManager) {
        mDbManager = dbManager;
    }

    public void doSomething() {
        mDbManager.readDatabase();
    }
}
