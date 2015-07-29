package com.codeblast.dagger1app;

import android.content.Context;
import android.util.Log;

import javax.inject.Singleton;

@Singleton
public class DbManager {

    private static final String TAG = "DbManager";

    private final Context mContext;

    public DbManager(Context context) {
        mContext = context;
    }

    public void readDatabase() {
        assert mContext != null;
        Log.d(TAG, "readDatabase...");
    }
}
