package com.codeblast.library;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
public interface LibraryComponent {

    // Provide instances of MyManager to MainComponent:
    MyManager getMyManager();
}
