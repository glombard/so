package com.codeblast.daggermultiplescopes;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = MainModule.class)
public interface MainComponent {
    void initialize(MainActivityFragment mainActivityFragment);
}
