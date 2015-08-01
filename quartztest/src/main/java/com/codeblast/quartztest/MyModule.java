package com.codeblast.quartztest;

import dagger.Module;
import dagger.Provides;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;

import javax.inject.Singleton;

@Module
public class MyModule {
    @Provides
    @Singleton
    Messager provideMessager(CustomMessager impl) {
        return impl;
    }

    @Provides
    Scheduler provideScheduler() {
        try {
            return new org.quartz.impl.StdSchedulerFactory().getScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
            return null;
        }
    }
}
