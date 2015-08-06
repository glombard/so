package com.codeblast.daggermodulesareoptional.hero;

import com.codeblast.daggermodulesareoptional.hero.attack.AttackCoordinator;
import com.codeblast.daggermodulesareoptional.hero.attack.HandToHandCombat;
import com.codeblast.daggermodulesareoptional.hero.attack.SuperPower;
import com.codeblast.daggermodulesareoptional.util.EventReporter;

public class CaptainAmerica implements SuperHero {

    private final AttackCoordinator mAttackCoordinator;

    private final HandToHandCombat mHandToHandCombat;

    public CaptainAmerica(EventReporter eventReporter) {
        mHandToHandCombat = new HandToHandCombat();
        mAttackCoordinator = new AttackCoordinator(eventReporter);
    }

    @Override
    public String getName() {
        return "Captain America";
    }

    @Override
    public SuperPower getSuperPower() {
        return mHandToHandCombat;
    }

    @Override
    public void attack(BadGuy badGuy) {
        mAttackCoordinator.attack(this, badGuy);
    }
}
