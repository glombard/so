package com.codeblast.daggermodulesareoptional.util;

import java.util.Random;

public class RandomNumberSupplier {

    private final Random mRandom;

    public RandomNumberSupplier() {
        mRandom = new Random();
    }

    public int nextInt(int max) {
        return mRandom.nextInt(max);
    }
}
