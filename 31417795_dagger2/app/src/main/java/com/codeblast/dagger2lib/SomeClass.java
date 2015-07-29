package com.codeblast.dagger2lib;

import android.util.Log;

import com.codeblast.library.MyManager;

public class SomeClass {

    private static final String TAG = "SomeClass";

    MyManager myManager;

    public void useDependency() {
        assert myManager != null;
        Log.d(TAG, "Doing something with myManager...");
    }
}
