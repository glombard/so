package com.codeblast.daggermodulesareoptional.hero;

import com.codeblast.daggermodulesareoptional.util.EventReporter;
import com.codeblast.daggermodulesareoptional.util.RandomNumberSupplier;

public class RandomHeroSupplier {

    private final BlackWidow mBlackWidow;

    private final CaptainAmerica mCaptainAmerica;

    private final IronMan mIronMan;

    private final RandomNumberSupplier mRandom;

    public RandomHeroSupplier(EventReporter eventReporter, RandomNumberSupplier randomNumberSupplier) {
        mBlackWidow = new BlackWidow(eventReporter);
        mCaptainAmerica = new CaptainAmerica(eventReporter);
        mIronMan = new IronMan(eventReporter);
        mRandom = randomNumberSupplier;
    }

    public SuperHero anyHero() {
        switch (mRandom.nextInt(3)) {
            case 0:
                return mBlackWidow;
            case 1:
                return mIronMan;
            case 2:
                return mCaptainAmerica;
        }
        throw new IllegalStateException("No hero?!");
    }
}
