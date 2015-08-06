package com.codeblast.daggermodulesareoptional.hero;

import com.codeblast.daggermodulesareoptional.hero.attack.AttackCoordinator;
import com.codeblast.daggermodulesareoptional.hero.attack.SuperPower;
import com.codeblast.daggermodulesareoptional.hero.attack.WidowBite;

import javax.inject.Inject;

public class BlackWidow implements SuperHero {

    private final AttackCoordinator mAttackCoordinator;

    private final WidowBite mWidowBite;

    @Inject
    public BlackWidow(WidowBite widowBite, AttackCoordinator attackCoordinator) {
        mWidowBite = widowBite;
        mAttackCoordinator = attackCoordinator;
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
