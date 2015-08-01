package com.codeblast.quartztest;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = MyModule.class)
public interface MyComponent {
    void inject(MyJob job);

    MyJobScheduler getMyJobScheduler();
}
