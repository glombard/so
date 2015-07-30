package com.codeblast.simplestdagger2example;

import javax.inject.Inject;

public class SomeClass {

    @Inject
    MyManager myManager;

    @Inject
    public SomeClass() {}

    public void doSomething() {
        myManager.doSomething();
    }
}
