package com.codeblast.library;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MyManager {

    private static final String TAG = "MyManager";

    @Inject
    public MyManager(MyUtility utility) {
        Log.d(TAG, "Creating MyManager");
        utility.doSomething();
    }
}
