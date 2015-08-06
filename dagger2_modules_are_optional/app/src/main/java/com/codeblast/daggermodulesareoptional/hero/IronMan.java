package com.codeblast.daggermodulesareoptional.hero;

import com.codeblast.daggermodulesareoptional.hero.attack.AttackCoordinator;
import com.codeblast.daggermodulesareoptional.hero.attack.RepulsorRay;
import com.codeblast.daggermodulesareoptional.hero.attack.SuperPower;

import javax.inject.Inject;

public class IronMan implements SuperHero {

    private final RepulsorRay mRepulsorRay;

    private final AttackCoordinator mAttackCoordinator;

    @Inject
    public IronMan(RepulsorRay repulsorRay, AttackCoordinator attackCoordinator) {
        mRepulsorRay = repulsorRay;
        mAttackCoordinator = attackCoordinator;
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
