package com.codeblast.simplestdagger2example;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MyManager {

    private static final String TAG = "MyManager";

    @Inject
    public MyManager() {
        Log.d(TAG, "Do some initializing");
    }

    public void doSomething() {
        Log.d(TAG, "Doing something");
    }
}
