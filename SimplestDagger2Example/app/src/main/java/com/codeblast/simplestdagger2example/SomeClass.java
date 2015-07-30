package com.codeblast.simplestdagger2example;

import javax.inject.Inject;

public class SomeClass {

    @Inject
    MyManager myManager;

    public void doSomething() {
        myManager.doSomething();
    }
}
