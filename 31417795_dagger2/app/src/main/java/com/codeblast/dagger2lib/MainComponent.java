package com.codeblast.dagger2lib;

import com.codeblast.library.LibraryComponent;

import dagger.Component;

@ActivityScope
@Component(dependencies = LibraryComponent.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);
}
