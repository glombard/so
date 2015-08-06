package com.codeblast.daggermodulesareoptional.hero;

import com.codeblast.daggermodulesareoptional.util.EventReporter;

import javax.inject.Inject;
import javax.inject.Provider;

public class Battle {

    private final RandomHeroSupplier mRandomHeroSupplier;

    private final Provider<BadGuy> mBadGuyProvider;

    private final EventReporter mEventReporter;

    private BadGuy mCurrentBadGuy;

    @Inject
    public Battle(EventReporter eventReporter, RandomHeroSupplier randomHeroSupplier, Provider<BadGuy> badGuyProvider) {
        mEventReporter = eventReporter;
        mRandomHeroSupplier = randomHeroSupplier;
        mBadGuyProvider = badGuyProvider;
        mCurrentBadGuy = mBadGuyProvider.get();
    }

    public void nextMove() {
        if (mCurrentBadGuy.isDead()) {
            mEventReporter.show(mCurrentBadGuy.getName() + " died.");
            mCurrentBadGuy = mBadGuyProvider.get();
            return;
        }

        final SuperHero hero = mRandomHeroSupplier.anyHero();
        hero.attack(mCurrentBadGuy);
    }
}
