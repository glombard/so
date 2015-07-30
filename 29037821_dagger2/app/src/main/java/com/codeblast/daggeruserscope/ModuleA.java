package com.codeblast.daggeruserscope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleA {
    @Provides
    @Singleton
    Bus provideBus() {
        return new Bus();
    }
}
