package com.codeblast.daggermodulesareoptional.hero;

import com.codeblast.daggermodulesareoptional.hero.attack.AttackCoordinator;
import com.codeblast.daggermodulesareoptional.hero.attack.RepulsorRay;
import com.codeblast.daggermodulesareoptional.hero.attack.SuperPower;
import com.codeblast.daggermodulesareoptional.util.EventReporter;

public class IronMan implements SuperHero {

    private final RepulsorRay mRepulsorRay;

    private final AttackCoordinator mAttackCoordinator;

    public IronMan(EventReporter eventReporter) {
        mRepulsorRay = new RepulsorRay();
        mAttackCoordinator = new AttackCoordinator(eventReporter);
    }

    @Override
    public String getName() {
        return "Iron Man";
    }

    @Override
    public SuperPower getSuperPower() {
        return mRepulsorRay;
    }

    @Override
    public void attack(BadGuy badGuy) {
        mAttackCoordinator.attack(this, badGuy);
    }
}
