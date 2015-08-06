package com.codeblast.daggermodulesareoptional.hero;

import com.codeblast.daggermodulesareoptional.hero.attack.AttackCoordinator;
import com.codeblast.daggermodulesareoptional.hero.attack.HandToHandCombat;
import com.codeblast.daggermodulesareoptional.hero.attack.SuperPower;

import javax.inject.Inject;

public class CaptainAmerica implements SuperHero {

    private final AttackCoordinator mAttackCoordinator;

    private final HandToHandCombat mHandToHandCombat;

    @Inject
    public CaptainAmerica(HandToHandCombat handToHandCombat, AttackCoordinator attackCoordinator) {
        mHandToHandCombat = handToHandCombat;
        mAttackCoordinator = attackCoordinator;
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
