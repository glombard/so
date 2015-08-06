package com.codeblast.daggermodulesareoptional.hero;

import com.codeblast.daggermodulesareoptional.util.RandomNumberSupplier;

import javax.inject.Inject;

public class RandomHeroSupplier {

    private final BlackWidow mBlackWidow;

    private final CaptainAmerica mCaptainAmerica;

    private final IronMan mIronMan;

    private final RandomNumberSupplier mRandom;

    @Inject
    public RandomHeroSupplier(BlackWidow blackWidow, CaptainAmerica captainAmerica, IronMan ironMan,
            RandomNumberSupplier randomNumberSupplier) {
        mBlackWidow = blackWidow;
        mCaptainAmerica = captainAmerica;
        mIronMan = ironMan;
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
