package com.codeblast.daggermultiplescopes;

import android.app.Application;

public class App extends Application {

    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerApplicationComponent.create();
    }

    public ApplicationComponent getComponent() {
        return mComponent;
    }
}
