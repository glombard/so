package com.codeblast.library;

import android.util.Log;

import javax.inject.Inject;

public class MyUtility {

    private static final String TAG = "MyUtility";

    @Inject
    public MyUtility() {
    }

    public void doSomething() {
        Log.d(TAG, "doing something");
    }
}
