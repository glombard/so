package com.codeblast.daggermultiplescopes;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private final Activity mActivity;

    public MainModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    Context provideContext() {
        return mActivity;
    }

    // and other activity-specific dependencies here...
}
