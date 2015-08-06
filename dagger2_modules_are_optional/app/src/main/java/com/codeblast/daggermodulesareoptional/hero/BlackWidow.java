package com.codeblast.daggermodulesareoptional.hero;

import com.codeblast.daggermodulesareoptional.hero.attack.AttackCoordinator;
import com.codeblast.daggermodulesareoptional.hero.attack.SuperPower;
import com.codeblast.daggermodulesareoptional.hero.attack.WidowBite;
import com.codeblast.daggermodulesareoptional.util.EventReporter;

public class BlackWidow implements SuperHero {

    private final AttackCoordinator mAttackCoordinator;

    private final WidowBite mWidowBite;

    public BlackWidow(EventReporter eventReporter) {
        mWidowBite = new WidowBite();
        mAttackCoordinator = new AttackCoordinator(eventReporter);
    }

    @Override
    public String getName() {
        return "Black Widow";
    }

    @Override
    public SuperPower getSuperPower() {
        return mWidowBite;
    }

    @Override
    public void attack(BadGuy badGuy) {
        mAttackCoordinator.attack(this, badGuy);
    }
}
