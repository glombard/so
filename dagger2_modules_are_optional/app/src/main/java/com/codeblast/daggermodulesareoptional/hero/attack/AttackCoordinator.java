package com.codeblast.daggermodulesareoptional.hero.attack;

import com.codeblast.daggermodulesareoptional.hero.BadGuy;
import com.codeblast.daggermodulesareoptional.hero.SuperHero;
import com.codeblast.daggermodulesareoptional.util.EventReporter;

public class AttackCoordinator {

    private final EventReporter mEventReporter;

    public AttackCoordinator(EventReporter eventReporter) {
        mEventReporter = eventReporter;
    }

    public void attack(SuperHero superHero, BadGuy badGuy) {
        mEventReporter.show(superHero.getName() + " vs " + badGuy.getName() + "... " +
                superHero.getSuperPower().getSoundEffect());
        badGuy.takeHit(superHero.getSuperPower());
    }
}
