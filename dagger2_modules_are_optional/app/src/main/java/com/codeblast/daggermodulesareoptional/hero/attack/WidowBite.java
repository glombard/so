package com.codeblast.daggermodulesareoptional.hero.attack;

import javax.inject.Inject;

public class WidowBite implements SuperPower {

    @Inject
    public WidowBite() {
    }

    @Override
    public String getSoundEffect() {
        return "Zap!";
    }

    @Override
    public int attackDamage() {
        return 4;
    }
}
