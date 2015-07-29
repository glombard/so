package com.codeblast.daggergenerics;

import dagger.Module;
import dagger.Provides;

@Module(injects = MainActivity.class)
public class MainModule {

    private final MainActivity mMainActivity;

    public MainModule(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    @Provides
    MainPresenter mainPresenter() {
        return new MainPresenter(mMainActivity);
    }
}
