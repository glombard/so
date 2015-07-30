package com.codeblast.simplestdagger2example;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
public interface Bootstrap {
    void initialize(MainActivity activity);
}
