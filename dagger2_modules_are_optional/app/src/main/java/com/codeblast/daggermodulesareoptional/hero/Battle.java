package com.codeblast.daggermodulesareoptional.hero;

import com.codeblast.daggermodulesareoptional.util.EventReporter;
import com.codeblast.daggermodulesareoptional.util.RandomNumberSupplier;

import javax.inject.Provider;

public class Battle {

    private final RandomHeroSupplier mRandomHeroSupplier;

    private final Provider<BadGuy> mBadGuyProvider;

    private final EventReporter mEventReporter;

    private BadGuy mCurrentBadGuy;

    public Battle(EventReporter eventReporter) {
        mEventReporter = eventReporter;
        final RandomNumberSupplier random = new RandomNumberSupplier();
        mRandomHeroSupplier = new RandomHeroSupplier(eventReporter, random);
        mBadGuyProvider = new Provider<BadGuy>() {
            @Override
            public BadGuy get() {
                return new BadGuy(random);
            }
        };
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
