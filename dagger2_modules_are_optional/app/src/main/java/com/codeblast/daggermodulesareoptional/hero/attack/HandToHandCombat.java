package com.codeblast.daggermodulesareoptional.hero.attack;

import javax.inject.Inject;

public class HandToHandCombat implements SuperPower {

    @Inject
    public HandToHandCombat() {
    }

    @Override
    public String getSoundEffect() {
        return "Pow!";
    }

    @Override
    public int attackDamage() {
        return 3;
    }
}
