package com.codeblast.daggeruserscope;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {ModuleA.class})
@Singleton
public interface ComponentA {

    Bus getBus();

    void inject(MainActivity target);
}
