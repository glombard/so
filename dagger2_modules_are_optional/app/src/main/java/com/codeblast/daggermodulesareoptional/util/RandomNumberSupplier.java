package com.codeblast.daggermodulesareoptional.util;

import java.util.Random;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RandomNumberSupplier {

    private final Random mRandom;

    @Inject
    public RandomNumberSupplier() {
        mRandom = new Random();
    }

    public int nextInt(int max) {
        return mRandom.nextInt(max);
    }
}
