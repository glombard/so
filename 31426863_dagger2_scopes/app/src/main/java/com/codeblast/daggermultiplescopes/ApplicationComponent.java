package com.codeblast.daggermultiplescopes;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
public interface ApplicationComponent {
    MainPresenter getMainPresenter();
}
